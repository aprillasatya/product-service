FROM openjdk:15.0-jdk
ARG JAR_FILE=target/product-service-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]