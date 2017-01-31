
Start a mysql docker container

    docker run --name mysql -p 3306:3306 -v /tmp/datadir:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -d mysql:5.5 

To build this application

    mvn package docker:build     

To start this application

    docker run --name=demo -p 8080:8080 --link mysql:mysql -t gangaraju/spring-boot-docker-demo
    
    (or)
    
    docker run --name=demo -p 8080:8080 -e spring.datasource.host=mysql -e spring.datasource.port=3306 --link mysql:mysql -t gangaraju/spring-boot-docker-demo