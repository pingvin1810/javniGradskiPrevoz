# JAVNI GRADSKI PREVOZ

The application is accessible via localhost:8080
Java version: 11
PostgreSQL database

### Database setup

Run in psql command prompt:

```
\i 'path/to/project/demo/src/main/resources/db.sql'
```

### How to build
```
mvnw clean install 
```

### How to run
Open Command Prompt in the folder and run for profile -dev:


```
java -jar target\demo-0.0.1-SNAPSHOT.jar
```
Alternatively

```sh
mvnw spring-boot:run
```

Swagger available at:
http://localhost:8080swagger-ui/index.html
