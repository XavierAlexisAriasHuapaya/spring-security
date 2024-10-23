# Spring Boot Project with Security and Audit

This project is a Spring Boot based application that includes security feature.

## Requirements

- Java 17
- MySQL

## Facility

1. **Clone the repository:**
   - SSH
      ```bash
      git clone git@github.com:XavierAlexisAriasHuapaya/spring-security.git
   - HTTPS
      ```bash
      git clone https://github.com/XavierAlexisAriasHuapaya/spring-security.git
2. **Configure and run the database with Docker (Windows)**
    ```bash
    version: '3.8'
    services:
      mysql:
        image:  mysql:latest
        ports:
          - 3307:3306
        environment:
          - MYSQL_ROOT_PASSWORD=root
          - MYSQL_DATABASE=dbsecurity
          - MYSQL_USER=usrsecurity
          - MYSQL_PASSWORD=lUNhxkydI9zN63WRd231
        volumes:
          - mysql_data:/var/lib/mysql
    volumes:
      mysql_data:

3. **Configure environment variables (application.yml)**
   ```bash
   spring:
     datasource:
       url: jdbc:mysql://localhost:3307/dbsecurity
       username: usrsecurity
       password: lUNhxkydI9zN63WRd231
4. **Compile and run the aplication**
   ```bash
   mvn clean install
   mvn spring-boot:run
5. **Compile the JAR for production**
   ```bash
   mvn clean package -DskipTests