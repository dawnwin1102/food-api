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
2. Use mvn build each project.
3. Start app with this command: java xx.jar
4. Go to Eureka endpoint:https://localhost:8081/doc.html Knife4j's UI will show as blow:
![image.png](https://leowebsite.blob.core.windows.net/images/eureka.png)
# Run project with docker
docker run xxx
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

