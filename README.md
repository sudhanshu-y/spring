# spring
spring projects and learning

# 2024-05-13-Restful-API
![image](https://github.com/sudhanshu-y/spring/assets/117539682/a24413a2-0690-4ffc-8d71-feb4c9c5257f)
![image](https://github.com/sudhanshu-y/spring/assets/117539682/99ae8836-8dc1-4894-94d8-265ce9ab22af)

# 2024-05-13-Restful-API-ConfigurationProperties
![image](https://github.com/sudhanshu-y/spring/assets/117539682/66ff76c9-55e8-4172-bab4-88b490e2f2d3)

# 2024-05-17-Restful-API-Mappings
dependency: web, jpa, h2, devtools

User: id, name, birthDate
UserDaoService: User Operations - add, find, delete
UserController: Controller for all Restful APIs

@GetMapping("/users") - allUsers()
@GetMapping("/users/{id}") - getUser(@PathVariable int id)
@PostMapping("/users") - addUser(@RequestBody User user)

Bydefault on success - 200 HTTP response is received. 

But during creating user - 201 - Created HTTPS response should be returned. 
--> Change it by: ResponseEntity.created(null).build()

If unknown id of user is provided in URL --> Give 200 OK Status with no response - Blank Page
--> Ideally should throw Exception --> User Not Found & Status 404 

Get desired error response structure. 
ErrorStructureDetail --> Defines Error Structure
CustomeExceptionHandler extends ResponseEntityExceptionHandler --> Handle all or individual exception


Validating input from User:
name - should not be null
birthDate - should be in past

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>



# 2024-05-25-Rest-API-JPA-MySQL

docker run --detach --env MYSQL_ROOT_PASSWORD=password --env MYSQL_USER=username --env MYSQL_PASSWORD=password --env MYSQL_DATABASE=employeedb --name mysql --publish 3306:3306 mysql:8-oracle

Download MySQL Shell:
https://dev.mysql.com/downloads/shell/

Check Table Data in MySQL Shell.

# 2024-05-26-MS/config-server

Git Download:

	https://git-scm.com/downloads
 
	https://git-scm.com/download/win

git config --global user.email "email@.com"

git config --global user.name "username"

mkdir git-local-config-repo

cd git-local-config-repo/

git init

touch limit-service.properties & define minimum and maximum properties of limit-service

git add *

git commit -m "adding limit-service.properties to git"


provide limit-service.properties file path to application.properties of config-server ms. 

1) Limit-ms: LimitController --> REST API: getLimits() --> Get Employee Class property from class defination 
2) Limit-ms: LimitController --> Create Customized Configuration - @ConfigurationProperties("limits-service") & Read value from application.properties file.
3) MS Architecture: De-coupled way --> Store property configuration on git & config-server. Limit-ms to access properties through config client from config-server.
URL: http://localhost:8080/limits-from-property --> Property will be refered frim config-server git repositories.
Start config-server: http://localhost:8888/limit-service/default - limit-service is same as limit-service.properties (push this properties to git)
server.port=8888
spring.cloud.config.server.git.uri=file:/C:/Users/SUDHANSHU/Desktop/Spring/2024-05-26-MS/git-local-config-repo

Start Limit-ms: 
spring.config.import=optional:configserver:http://localhost:8888
spring.cloud.config.profile=prod --> Get properties from prod profile from git repository 


