# 3Frames Assignment Project
### Problem Statement:
### TASK 1.
Implement a version control file system similar to (Git), but unlike Git, which may be used offline. This version control file system will be available only online. Maintain strong concurrency and read capability. The number of concurrent hits on read will be greater than on write, hence write should not obstruct read during concurrent operations. Write APIs to display files, file folder operations, diffs, conflicts, and merges! Please include folders as part of the version control system. We can ignore binary files for the time being.

## The project has been implemented using Spring Boot, Docker, PostGres SQL. Postman was used to validate the APIs.

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
