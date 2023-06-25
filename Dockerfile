FROM gradle:7.6.1-jdk17-alpine AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle clean build

FROM openjdk:17-alpine
COPY --from=build /app/questio-services/build/libs/*.jar .
COPY --from=build /app/crawler-job/build/libs/*.jar .
COPY --from=build /app/summerizer-job/build/libs/*.jar .
ENV SPRINGBOOT_RUN_PROFILES=default
EXPOSE 8080
ENTRYPOINT ["java","-jar","questio-services-1.0.jar"]