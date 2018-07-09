sudo docker build -t home-control:mysql home-mysql
sudo docker run --name home-mysql -p 3306:3306 -d home-control:mysql
