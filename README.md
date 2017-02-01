
Start a mysql docker container

    docker run --name mysql -p 3306:3306 -v /tmp/datadir:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -d mysql:5.5 
    
Go inside the container and create database.
    
    docker exec -it mysql bash
    mysql -uroot -ppassword
    mysql> create database demo;
    

To build this application

    mvn package docker:build     

To start this application

    docker run --name=demo -p 8080:8080 --link mysql:mysql -t gangaraju/spring-boot-docker-demo
    
    (or)
    
    docker run --name=demo -p 8080:8080 -e spring.datasource.host=mysql -e spring.datasource.port=3306 --link mysql:mysql -t gangaraju/spring-boot-docker-demo
    
REST API's:

 1. Create User
 
   POST http://localhost:8080/user
   
   {
      "firstName" : "Gangaraju",
      "lastName": "Chaganti"
   }
   
 2. Get User
 
    GET http://localhost:8080/user/\<id\>
    
 3. Get All users
 
     GET http://localhost:8080/users
 
