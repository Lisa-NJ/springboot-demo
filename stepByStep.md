1. Spring Initializer => empty spring boot + Spring Web, Lombok
2. @RestController, @GetMapping, @bean, CommandLineRunner
3. +dependency: spring-boot-starter-data-jpa, @Entity @Id @GeneratedValue => JPA Palette appears
4. +repositories / StudentRepository, controllers / StudentController, update application.properties
5. +mysql> create database flyway_migrations => set up database
6. +db / migration / V1__init.sql
7. +dependencies: org.flywaydb:flyway-core, mysql-connector-java
8. change into db / migration, +V2__data.sql
9. rename application.properties -> application-mysql.properties, delete com.lisa.demo - mysql version
10. rename db / migration -> db / migration-mysql , +db / migration - V1~V4
11. +application.properties - postgres version, +dependencies: runtimeOnly 'org.postgresql:postgresql'
12. +com.lisa.demo - postgres version && code files,
    +dependencies: implementation 'org.springframework.boot:spring-boot-starter-security'
    +dependencies: implementation 'org.mapstruct:mapstruct:1.5.2.Final'
    +dependencies: annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.2.Final'
13. ./gradlew clean build -> demo-0.0.1-SNAPSHOT.jar, demo-0.0.1-SNAPSHOT-plain.jar 
14. java -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar
15. +Dockerfile, Dockerfile_Dev, docker-compose.yaml, +scripts/ folder