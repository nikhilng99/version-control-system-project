3Frames Assignment Project

The project has been implemented using Spring Boot, Docker, PostGres SQL. Postman was used to validate the APIs.

# Steps to run the project:
1. Run ```mvn clean package -DskipTests``` on the project
  2. Run ```docker-compose up --build``` to start the docker containers
  3. Run the VersionControlSystemApplication.java

# Design:<br>
## Controller
  1. FileController.java
  2. FolderController.java

## Model
 1. File.java
 2. Folder.java
 3. Change.java
 4. MergeRequest.java

## Repository (DAO)
  1. FileRepository.java
  2. FolderRepository.java
  3. ChangeRepository.java

## Service
  1. FileService.java
  2. FolderService.java

## Main application: 
  VersionControlSystemApplication.java
