FROM openjdk:17-oracle
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.username=${BOT_USERNAME}", "-Dbot.token=${BOT_TOKEN}", "-jar","/app.jar"]