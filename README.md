# Purpose
This is a demo project to build web API that returns a set of food trucks.
## Description:
- A single spring boot application load input csv files into db and provide web apis.
## Features
- Use JPA and sqlite as data persistence strategy
- All APIs have a unified corresponding format
- Global exception handling
- Use tlog for call chain tracking
- Secure the tcp conection by ssl(self-signed certificate)
- Use shiro for identity authentication and authentication
- Use CaffeineCache for local cache and response cache
- Use Knife4j as api document
# System Diagram
![DemoDiagram.jpg](https://leowebsite.blob.core.windows.net/images/DemoDiagram.jpg)

# Buld project and run
1. Clone the project from git hub.
2. Use mvn build each project:./mvnw clean package -Dmaven.test.skip=true
3. Start app with this command: java -jar food-api-0.0.1-SNAPSHOT.jar
4. Go to Eureka endpoint:https://localhost:8081/doc.html Knife4j's UI will show as blow:
![image.png](https://leowebsite.blob.core.windows.net/images/eureka.png)
# Run project with docker
- sudo docker run -it -d --restart always -p 8088:8081 --name food-api-8088 dawnwin1102/dawnwin1102:latest bash
when container started goto https://localhost:8088/doc.html
# API Description
There is 3 controller and 7 apis expose fo demo
- /food/list need pagable request then response with paged result.(eg:{
  "page": 1,
  "size": 10
  })
- /food/listByApplicant will result with specific applicant(eg:{
  "applicant": "MOMO INNOVATION LLC"
  })
- /food/listByApplicantOrAddress will result with specific applicant or address(eg:{
  "address": "1 BUSH ST",
  "applicant": "MOMO INNOVATION LLC"
  })
- /user/login this api will grant a jwt token if login success(username:leo,password:leo123)
- /food/auth/list same as  /food/list but this api need Authorization ,use /user/login get token first then call api with Authorization header.
 eg:Authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzUwMjc2MTQsInVzZXJuYW1lIjoibGVvIn0.JcgERv_AjgCF0M1hi6oYLPPABIGjbP4KEHnsnYpcgE8
# Tradeoffs
With a limit time budget, I think the most import point to build a web api is:
- Unified response, global exception capture, api security, performance, traceability, simple and clear documentation
# Future improvement
- Separate models,service... into deferent modules not in a single application
- Use standard db like Mysql/PostgreSQL/SQL Server to deal with complex business
- Use redis as a centralized cache component to set up a three level cache management to improve cache abaility
- Add centralized log solution(Ali logs/ELK)
- Setup a Oauth server as a center author service to author our apis
- Setup apigateway to do the SSL termination,load balance,api Configure traffic limiting policy..
- Build application in a micro service way.

