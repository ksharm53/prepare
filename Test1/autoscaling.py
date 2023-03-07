#!usr/bin/python

import boto3
import json
import paramiko
import threading
import time
import sys
from time import sleep
import os
sqs = boto3.client('sqs',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')
ec2 = boto3.resource('ec2',aws_access_key_id='AKIA2GSJ7AFIW5DIA34A',aws_secret_access_key='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',region_name='us-east-1')

input_queue = "https://sqs.us-east-1.amazonaws.com/701308535121/input"
output_queue = "https://sqs.us-east-1.amazonaws.com/701308535121/output"


def autoscaling():
	each_execution = []
	running_instances = []
	while(True):
		
		request_queue_length =input_queue_load(input_queue)
		instance_count = len([instance for instance in ec2.instances.all()])		
		if(instance_count<20):
			for i in range(instance_count+1, 21):
				print("Creating Instances: ",i)
				scale_up(i)
			sleep(5)
		running_instances_count =running_instance_count()
		stopped_instances_count = stopped_instances_count()
		print("request_queue_length : " + str(request_queue_length))
		print("running_instances_count : " + str(running_instances_count))
		print("stopped_instances_count : " + str(stopped_instances_count))
		if(request_queue_length>running_instances_count-len(running_instances)):
			stoppedIds = fetch_stopped_instances()
			no_of_instances_to_start = min(stopped_instances_count, request_queue_length-(running_instances_count-len(running_instances)))


			print("stopped_instances_count: " + stopped_instances_count)
			print("length queue" + (request_queue_length-(running_instances_count-len(running_instances))))
			
			try:
				ec2.instances.filter(InstanceIds = stoppedIds[:no_of_instances_to_start]).start()
			except Exception as e:
				print("Exception occured while spinning up EC2 instances: ",e)
				continue
			time.sleep(30)
		elif request_queue_length<running_instances_count-len(running_instances):
			running_ids = fetch_running_instances()
			instances_completed_app_execution = [i for i in running_ids if i not in running_instances]
			try:
				ec2.instances.filter(InstanceIds = instances_completed_app_execution[:len(instances_completed_app_execution)-request_queue_length]).stop()
			except Exception as e:
				print("Exception occured while spinning up ec2 instances",e)
			time.sleep(30)
		for running_id in fetch_running_instances():
			if running_id not in running_instances:
				t = threading.Thread(name=running_id, target = deep_learning, args=(running_id,))
				each_execution.append(t)
				running_instances.append(running_id)
				t.start()
				print("Thread started for fetching running ids", t)
		updated_threads = []
		for t in each_execution:
			print("Health Check: ",t.is_alive())
			if not t.is_alive():
				
				running_instances.remove(t.getName())
				print("Length of running instances: " +len(running_instances))
			else:
				updated_threads.append(t)
		each_execution = updated_threads
		print("Each Execution : "+each_execution)

		
		
def fetch_running_instances():
	ids = []
	for each in ec2.instances.all():
		if(each.state['Name']=='running' or each.state['Name']=='pending'):
			ids.append(each.id)
	return ids


def scale_up( app_number):
	instance = ec2.create_instances(
		BlockDeviceMappings=[
			{
				'DeviceName': "/dev/xvda",
				'Ebs': {
					'DeleteOnTermination': True,
					'SnapshotId': 'snap-0282ee1fcda2b0657'
					},
			},
		],
		ImageId='ami-0550a9fff253a14f5',
		InstanceType='t2.micro',
		MaxCount=1,
		MinCount=1,
		KeyName='delete1',
		Monitoring={
			'Enabled': True
		},
		TagSpecifications=[
			{
				'ResourceType': 'instance',
				'Tags': [
					{
						'Key': 'Name',
						'Value': 'app-instance'+ str(app_number).zfill(2)
					},
				]
			},
		],
		NetworkInterfaces=[
			{
				'AssociatePublicIpAddress': True,
				'DeleteOnTermination': True,
				'DeviceIndex': 0,
				'Groups': [
					'sg-0eb3f01b0aca4ab8f'
				]
			}
		],
		InstanceInitiatedShutdownBehavior='stop',
	)



def input_queue_load(sqsQueueUrl):
	response = sqs.get_queue_attributes(QueueUrl=sqsQueueUrl,AttributeNames=['ApproximateNumberOfMessages',])
	response = int(response['Attributes']['ApproximateNumberOfMessages'])
	return response


def running_instance_count():
	counter = 0
	for each in ec2.instances.all():
		if(each.state['Name']=='running' or each.state['Name']=='pending'):
			counter+=1
	return counter

def stopped_instances_count():
	counter = 0
	for each in ec2.instances.all():
		if(each.state['Name']=='stopped' or each.state['Name']=='stopping'):
			counter+=1
	return counter



def fetch_stopped_instances():
	ids = []
	for each in ec2.instances.all():
		if(each.state['Name']=='stopped' or each.state['Name']=='stopping'):
			ids.append(each.id)
	return ids

def deep_learning(instance_id):
	path= os.getcwd()
	key = paramiko.RSAKey.from_private_key_file( '/home/ec2-user/delete1.pem')
	client = paramiko.SSHClient()
	client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
	print("Inside deep leaning method to process images")
	instance = [i for i in ec2.instances.filter(InstanceIds=[instance_id])][0]
	print("trying to connect each instance",instance)
	while(1):
		try:
			client.connect(hostname=instance.public_ip_address, username='ubuntu',pkey=key, timeout=30)
			print("Instance connected")
			sin ,sout ,serr = client.exec_command('python3 /home/ubuntu/main.py')
			exit_status = sout.channel.recv_exit_status()
			print(client.close())
			print("Completed deep_learning method")
			break
		except Exception as e:
			print("Reattempting to connect "+str(e))
			sleep(5)




if __name__ == '__main__':
	
	while(1):
		autoscaling()


