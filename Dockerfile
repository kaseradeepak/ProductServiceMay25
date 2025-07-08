FROM openjdk:24

COPY target/ProductServiceMay25-0.0.1-SNAPSHOT.jar productservice.jar

# java -jar productservice.jar

ENTRYPOINT ["java", "-jar", "productservice.jar"]

