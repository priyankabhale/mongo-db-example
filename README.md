# Description
This project enables the user to perform basic CRUD operations on mongo-db via Java.
It use various methods for querying such as MongoRepository, mongo-query-lang and querydsl.

# Technical details
The user can install mongo db by downloading its msi file and installing it or 
the user can run the mongo image in the docker container. 

port used for running mongo = 27017
port used for running java application = 8080

The first step is to run the mongo-db and then start the java application.

Below setps can be used if the user wishes to run mongo-db via docker

# Docker setup
1) For this project user has to set up a mongo application running on port 27017 of the host machine.
2) docker run -d -p 27017:27017 mongo:latest (This command runs the latest image of mongo-db in background mode inside docker on port 27017 of the hostmachine)
3) docker exec -it name_of_container bash (This command lets the user enter in bash of the container)
4) mongo (This command lets the user enter the shell of mongo)
5) show dbs (It is used to check the various available dbs)
6) db.collection_name.find() (It is used to find record for a particular collection)
7) db.Hotels.find() (In this case the collection name is Hotel)
