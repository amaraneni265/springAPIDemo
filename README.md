# springAPIDemo
My first Attempt at Sample spring API  with H2 In-memory DB


This service is a simpel Rest service using H2 IN-memory DB with default 2 records (refer to data.sql ) on initial load. 

Developed using Java/Maven/SpringBoot

Features API with   one GET and one POST end point

End point URLS:

GET: http://localhost:8080/feature?email=test@test.com&featureName=test 

Sample Response:
{
    "canAccess": true
} 


POST/PUT: http://localhost:8080/feature

sample Request Payload: {
"featureName" : "test",
"email" : "test@test.com",
"enable" : false
}

Response:  Empty response with status code 200 (Db update or insert)
           Empty response with status code 304 (No insert or update in DB)
           
           






