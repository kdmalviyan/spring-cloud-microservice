FROM maven:3.8-amazoncorretto-17

WORKDIR /order-service
COPY . .
#RUN mvn clean install

CMD mvn clean spring-boot:run -Dspring-boot.run.profiles=docker