FROM ubuntu:latest
LABEL authors="sunilbombe"

ENTRYPOINT ["top", "-b"]

FROM maven:3.8.6-openjdk-21

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests
RUN npx playwright install

CMD ["mvn", "test"]
