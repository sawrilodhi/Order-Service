FROM openjdk:8
EXPOSE 9095
ADD target/order-service-0.0.1.jar order-service-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/order-service-0.0.1.jar"] 