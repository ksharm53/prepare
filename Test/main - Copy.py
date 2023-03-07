import os
import boto3
# from s3_url import S3Url
import time
from datetime import datetime,timezone
import subprocess
import requests
import json
import base64
from PIL import Image
from image_classification import func1
'''
Reference for aws boto3 :
https://boto3.amazonaws.com/v1/documentation/api/latest/guide/quickstart.html
All boto3 comands usage was reffered from above reference site.
'''

#SQS Queue URL
input_queue_url = "https://sqs.us-east-1.amazonaws.com/701308535121/input"
output_queue_url = "https://sqs.us-east-1.amazonaws.com/701308535121/output"
#S3 Buckets
input_bucket = 'cse-546-input-kamakazie'
output_bucket = 'cse-546-output-kamakazie'
sqs = boto3.client('sqs',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')
s3 = boto3.client('s3',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')
ec2 = boto3.client('ec2',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')

def get_num_messages_available():
	""" Returns the number of messages in the queue """
	response = sqs.get_queue_attributes(QueueUrl=input_queue_url,AttributeNames=['ApproximateNumberOfMessages'])
	messages_available = int(response['Attributes']['ApproximateNumberOfMessages'])
	print(messages_available)
	return messages_available

def get_num_messages_visible():
	""" Returns the number of messages visible in the queue """
	response = sqs.get_queue_attributes(QueueUrl=input_queue_url,AttributeNames=['ApproximateNumberOfMessagesNotVisible'])
	messages_available = response['Attributes']['ApproximateNumberOfMessagesNotVisible']
	return int(messages_available)

def get_latest_message():
	print("Getting Latest Messages")
	""" Gets the first available message in queue """
	response = sqs.receive_message(
		QueueUrl=input_queue_url,
		MaxNumberOfMessages=1,
		MessageAttributeNames=['ALL']
		)
	# print(response)
	receipt_handle = response['Messages'][0]['ReceiptHandle']
	# print(receipt_handle)
	'''String to image conversion was refered from below url
		Referal: https://www.geeksforgeeks.org/python-convert-image-to-string-and-vice-versa/
		'''
	body_string = response['Messages'][0]['Body']
	body,file_name = body_string.split(',')
	body = body.encode('utf-8')
	imgdata = base64.decodebytes(body)
	temp_file_name = file_name.split('-')
	filename = temp_file_name[0] + '.'+ temp_file_name[1].split('.')[1]
	print(filename)
	path= os.getcwd()+'/'+filename
	with open(filename,'wb') as f:
		f.write(imgdata)
	f.close()
	# print(path)
	s3.upload_file(
		path,
		input_bucket,
		filename
		)
	delete_message_from_queue(input_queue_url,receipt_handle,filename)
	# time.sleep(5)
	return(receipt_handle,path,filename,file_name)
def get_result(file_name,receipt_handle,orginal_file_name):
	# print("Executing Image recognition algorithm")
	#result = func1(os.getcwd()+'/'+file_name)
	#os.system("python3 ~/Downloads/Tadavarti_PunepalliSai_Musunuru/app_tier/image_classification.py " + file_name )
	
	result = func1(file_name)
	# message = {file_name: result[0]}
	try:
		file_name_with_out_extension=file_name.split('.')
		file_name=file_name_with_out_extension[0]
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
			response = sqs.send_message(
				QueueUrl=output_queue_url,
				MessageBody= (message),
				)
		except Exception as e:
			print("Error while placing in output queue",e)
			# print("Result placed in s3 bucket")
	except:
		print("Error while placing in output bucket")
	# print("Executed Image recognition algorithm")
	os.remove(path)
	return(result)

def delete_message_from_queue(dele_queue_url,receipt_handle,file_name):
	print("Deleting Queue from SQS_Input for input " + file_name)
	try:
		response = sqs.delete_message(
		QueueUrl = dele_queue_url,
		ReceiptHandle = receipt_handle
		)
		print("Message deleted")
	except:
		print("Could not delete Queue message")

def run_job():
	try:
		# print("Retrieving Image from SQS")
		receipt_handle,path,filename,orginal_file_name = get_latest_message()
		# print(receipt_handle,path,filename)
		result = get_result(filename,receipt_handle,orginal_file_name)
		print(filename,result)
		print(path)
		os.remove(path)
		time.sleep(5)
		# os.system("shutdown /s /t 1")
	except:
		print("No more messages available")
	# else:
		# print("shutting dowm system")
		# os.system("shutdown -h")
			# time.sleep(2)

# while(get_num_messages_available()>0):
while(1):
	run_job()
#run_job()
#if run_cont: #Run forever
#	while True:
#		run_job()
#		time.sleep(5) #poll every 5 seconds


#if shutdown_after:
#	print("Job Complete. Shutting Down")
#else:
#	print("Job Comlete. Quitting...")

