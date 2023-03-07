import os
import boto3
import time
import base64
from PIL import Image
from image_classification import func1


req_queue = "https://sqs.us-east-1.amazonaws.com/701308535121/input"
res_queue = "https://sqs.us-east-1.amazonaws.com/701308535121/output"
input_bucket = 'cse-546-input-kamakazie'
output_bucket = 'cse-546-output-kamakazie'
sqs = boto3.client('sqs',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')
s3 = boto3.client('s3',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')
ec2 = boto3.client('ec2',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')


def fetch_request():
	print("Getting Latest Messages")
	
	response = sqs.receive_message(
		QueueUrl=req_queue,
		MaxNumberOfMessages=1,
		MessageAttributeNames=['ALL']
		)
	
	receipt_handle = response['Messages'][0]['ReceiptHandle']
	body_string = response['Messages'][0]['Body']
	body,file_name = body_string.split(',')
	body = body.encode('utf-8')
	decoded_image = base64.decodebytes(body)
	temp = file_name.split('-')
	filename = temp[0] + '.'+ temp[1].split('.')[1]
	print(filename)
	path= os.getcwd()+'/'+filename
	with open(filename,'wb') as f:
		f.write(decoded_image)
	f.close()
	
	s3.upload_file(
		path,
		input_bucket,
		filename
		)
	clear_queue(req_queue,receipt_handle,filename)	
	return(receipt_handle,path,filename,file_name)

def fetch_results(file_name,receipt_handle,orginal_file_name):
	
	result = func1(file_name)	
	try:
		file_extension=file_name.split('.')
		file_name=file_extension[0]
		s3.put_object(
			Bucket = output_bucket,
			Key = str(file_name),
			Body = str(result),
			Metadata={
			"string": 'string'
            }
			)
		message = orginal_file_name+','+ str(result)
		print(message)
		try:
			sqs.send_message(
				QueueUrl=res_queue,
				MessageBody= (message),
				)
		except Exception as e:
			print("Error while placing in output queue",e)
			
	except:
		print("Error while placing in output bucket")	
	#os.remove(path)
	return(result)

def clear_queue(queue,receipt_handle,file_name):
	print("Deleting Queue from SQS_Input for input " + file_name)
	try:
		sqs.delete_message(
		QueueUrl = queue,
		ReceiptHandle = receipt_handle
		)
		print("Message deleted")
	except:
		print("Could not delete Queue message")

def run_job():
	try:
		
		receipt_handle,path,filename,orginal_file_name = fetch_request()		
		result = fetch_results(filename,receipt_handle,orginal_file_name)
		print(filename,result)
		print(path)
		os.remove(path)
		time.sleep(5)
		
	except:
		print("No more messages available")

while(1):
	run_job()


