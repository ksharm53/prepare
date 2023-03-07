import os
from flask import Flask,render_template,request,redirect,url_for,abort
from werkzeug.utils import secure_filename
import boto3
from botocore.exceptions import NoCredentialsError
import base64
from datetime import datetime
from time import sleep
import threading
from autoscaling import autoscaling


app = Flask(__name__)
flag = 0
images_from_sqs = []
img_req = 0
sqs = boto3.client('sqs',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')
req_queue = "https://sqs.us-east-1.amazonaws.com/701308535121/input"
res_queue = "https://sqs.us-east-1.amazonaws.com/701308535121/output"

@app.route('/', methods=['POST'])
def process_image():
	global img_req
	global flag
	print("flag: ",flag)
	img_req =img_req + 1
	print("Test request: ",img_req)
	in_count = img_req
	print("Triggered iamges count: ",in_count)
	output_result = Process_req()
	fr_images = request.files.getlist('file')
	if(flag == 0):
		flag = 1
		sqs_thread = threading.Thread(name="generate_output" , target = get_sqs_response )
		sqs_thread.start()
		autoscaling_thread = threading.Thread(name="autoscaling" , target = autoscaling)
		autoscaling_thread.start()
	output_result.images_upload(fr_images)
	img_req = img_req - 1
	return render_template('results.html', results=output_result.fetch_data())


def get_sqs_response():
	global images_from_sqs
	global img_req
	global flag
	print("Response Thread Started")
	while(1):
		response = sqs.get_queue_attributes(QueueUrl=res_queue,AttributeNames=['ApproximateNumberOfMessages'])
		res_queue_load = int(response['Attributes']['ApproximateNumberOfMessages'])
		if(res_queue_load > 0):
			try:
				response = sqs.receive_message(
					QueueUrl=res_queue,
					MaxNumberOfMessages=1
				)
				message = response['Messages'][0]['Body']
				receipt_handle=response['Messages'][0]['ReceiptHandle']
				message = message.split(',')
				print(message)
				images_from_sqs.append(message)
				clear_response_queue(res_queue,receipt_handle)
			except Exception as e:
				print("Exception Occurred while fetching queue response: ",e)
				sleep(5)
		elif(res_queue_load == 0 and img_req == 0):
			flag = 0
			break


class Process_req:
	def __init__(self):
		global img_req
		self.results = []
		self.files_names = []
		now =datetime.now()
		self.date_time = now.strftime("%m%d%Y%H%M%S")
		self.result =[]
		self.request_number = img_req
	def images_upload(self,data):
		try:
			for each_req in data:
				if each_req.filename != '':
					filename = secure_filename(each_req.filename)
					temp = filename.split('.')
					updated_file_name = temp[0] + '-'+self.date_time+'.'+temp[1]
					print(updated_file_name)
					self.files_names.append(updated_file_name)
				if filename != '':
					uploaded = self.send_img_to_queue(each_req,updated_file_name)
					print("image sent to Input Queue",filename)
		except Exception as e:
			print("Exception Occurred while triggering image Process Request ",e)
		sleep(30)
		self.fetch_results_from_output_queue()

	def send_img_to_queue(self,file,filename):
		print("Sending images to Queue")
		encoded_img = base64.b64encode(file.read()).decode('utf-8')
		try:
			
			response = sqs.send_message(
    			QueueUrl=req_queue,
    			MessageBody= encoded_img + ',' +str(filename),
    			
    			)
		
		except Exception as e:
			print("Exception occured while sending image to queue: ", e)
			sleep(5)
			return e

	
	def fetch_results_from_output_queue(self):
		global images_from_sqs
		print("Fetching images from output queue")
		while(1):
			
			for each_image in images_from_sqs:
				
				if each_image[0] in self.files_names:
					images_from_sqs.remove(each_image)
					temp = each_image[0].split('-')
					temp[1]=temp[1].split('.')[1]
					each_image[0]=temp[0]+'.'+temp[1]
					self.result.append(each_image)
			
			if(len(self.result) == len(self.files_names)):
				break
		self.results=sorted(self.result)
		print("Images fetched from output queue")
	

	def fetch_data(self):
		return self.results
	
def clear_response_queue(dele_queue_url,receipt_handle):
	try:
		response = sqs.delete_message(
		QueueUrl = dele_queue_url,
		ReceiptHandle = receipt_handle
		)
		
	except Exception as e:
		print("Exception occured while deleting Queue Data",e)


if __name__ == '__main__':
	app.run(
		threaded=True,		
        host='0.0.0.0',
		port=int(os.getenv('PORT', '5000')),
		use_reloader=True
		)
