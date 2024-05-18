FROM amazoncorretto:17-alpine-jdk

EXPOSE 9090

ADD target/*.jar app.jar

ENTRYPOINT [ "java", "-jar" , "./app.jar" ]