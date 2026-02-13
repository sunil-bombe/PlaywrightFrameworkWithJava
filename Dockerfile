# Use Playwright's official Docker image with Node.js and browsers pre-installed
FROM mcr.microsoft.com/playwright:v1.39.0-focal

# Set working directory
WORKDIR /app

# Install Maven and Java
RUN apt-get update && apt-get install -y maven openjdk-17-jdk

# Copy project files
COPY . .

# Install Maven dependencies
RUN mvn clean install -DskipTests

# Command to execute tests
CMD ["mvn", "test"]

