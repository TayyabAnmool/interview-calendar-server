
# Interview calendar Server

This repository contains a REST API for an interview calendar implemented with Spring Boot.

## How to run 

Make sure you have installed Maven command line tool and Java with version at least 1.8.

To run the application locally, clone the repository, create database

```
interview_calender_db
```

navigate to the folder and type:

```
mvn spring-boot:run
```

The server will be available at http://localhost:8080

## Endpoints
 

**Important:** `Content-Type: application/json` header must be present to use API.

The most common HTTP status codes are returned when there is an error.

### Add a INTERVIEWER

```
/api/user/ [POST]
```

```

Content-Type: application/json

{
    "name":"Tayyab Anmool",
    "userRole":"INTERVIEWER"
}
```


Upon successfull creation, the server will respond with 201: Created, and it will return newly created user.

### Add a Candidate

```
/api/user/ [POST]
```

```

Content-Type: application/json

{
    "name":"Mike",
    "userRole":"CANDIDATE"
}
```


Upon successfull creation, the server will respond with 201: Created, and it will return newly created user.

### List all candidates

```
/api/user/candidates [GET]
```

Lists all available candidates known to the system, including their IDs.

### List all interviewers

```
/api/user/interviewers [GET]
```

Lists all available interviewers known to the system, including their IDs.

### List all users


```
/api/user [GET]
```

Lists all available users known to the system, including their IDs.


### Add an availability

```
/api/availability [PUT]
```
```
{
    "date":"2022-05-17",
    "userId":1,
    "hourTo":9,
    "hourFrom":7
       
}
```

### Check availability

```
/api/availability/check [POST]
```
```
{
    "candidateId":1,
    "interviewerIds":[5,2]
}
```
