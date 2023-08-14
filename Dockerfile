FROM openjdk:17-alpine
COPY /build/libs/common-masters-service-0.0.1.jar usr/src/common-masters-service-0.0.1.jar
EXPOSE 8183
CMD ["java","-jar","/usr/src/common-masters-service-0.0.1.jar"]
