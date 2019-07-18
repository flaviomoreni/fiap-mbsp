maven clean
maven install
scp -i ~/.ssh/fiap-mpsp.pem target/fiap-mpsp-1.jar ec2-user@18.231.116.58:/home/ec2-user
ssh -i ~/.ssh/fiap-mpsp.pem ec2-user@18.231.116.58