# Stage 1: Build the project
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
COPY testng.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the project and skip tests in this stage
RUN mvn clean package -DskipTests

# Stage 2: Run tests
FROM maven:3.8.4-openjdk-11

# Set the working directory
WORKDIR /app

# Copy the project files from the build stage
COPY --from=build /app /app

# Run the tests
CMD ["mvn", "test"]
