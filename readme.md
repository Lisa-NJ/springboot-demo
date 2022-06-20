1. Spring Initializer => empty spring boot + Spring Web, Lombok
2. @RestController, @GetMapping, @bean, CommandLineRunner
3. +dependency: spring-boot-starter-data-jpa, @Entity @Id @GeneratedValue => JPA Palette appears
4. +repositories / StudentRepository, controllers / StudentController, update application.properties
5. +mysql> create database flyway_migrations => set up database
6. +db / migration / V1__init.sql
7. +dependencies: org.flywaydb:flyway-core, mysql-connector-java
8. change into db / migration, +V2__data.sql