
# Student App  [![Build Status](https://travis-ci.org/geraldoms/student-app.svg?branch=master)](https://travis-ci.org/geraldoms/student-app)  
=======================

This is a basic example of Java web application using Spring Boot version 2. The app has some hard-coded information about Students and Courses and provides some Restful APIs to make it accessible.

## Requirements
* JDK 8 or later
* Maven 3.2+

## Instalation
`$ mvn package`

## Usage

After running the command above, a jar file should be in the `target` folder. Run the command below using that jar file.   
 
`java -jar target/student-app-0.0.1-SNAPSHOT.jar`

## Running the tests

For the unit and integration test, run the command below: 

`$ mvn test`

## Request samples

##### Getting a student by ID.

Request:
```bash
curl -X GET -H 'Cache-Control: no-cache' -H 'Content-Type: application/json' http://localhost:8080/api/v1/students/2
```

Response:
```json
{
    "id": 2,
    "firstName": "Richard",
    "lastName": "Yok",
    "memberId": "88201918",
    "birthDate": "3893-05-21T04:00:00.000+0000",
    "courses": [
        {
            "id": 2,
            "name": "History",
            "description": "History is the study of the past as it is described in written documents.",
            "createdAt": "2018-07-07T21:57:51.914+0000"
        }
    ],
    "createdAt": "2018-07-07T21:57:51.915+0000"
}
```

##### Getting a specific course by student.

Request:
```bash
curl -X GET -H 'Cache-Control: no-cache' -H 'Content-Type: application/json' http://localhost:8080/api/v1/students/3/courses/2
```

Response:
```json
{
    "id": 2,
    "name": "History",
    "description": "History is the study of the past as it is described in written documents.",
    "createdAt": "2018-07-07T21:57:51.914+0000"
}
```
