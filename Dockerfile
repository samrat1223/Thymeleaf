FROM openjdk:16-alpine
ADD target/SpringBoot-Thymeleaf_crud-0.0.1-SNAPSHOT.jar SpringBoot-Thymeleaf_crud-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","SpringBoot-Thymeleaf_crud-0.0.1-SNAPSHOT.jar"]