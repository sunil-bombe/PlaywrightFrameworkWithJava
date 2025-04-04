# Use the correct Maven image with OpenJDK 17
FROM maven:3.8.6-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Install Node.js and Playwright dependencies
RUN apt-get update && apt-get install -y curl \
    && curl -fsSL https://deb.nodesource.com/setup_18.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g playwright

# Copy project files
COPY . .

# Install Maven dependencies
RUN mvn clean install -DskipTests

# Install Playwright Browsers
RUN npx playwright install --with-deps

# Command to execute tests
CMD ["mvn", "test"]
