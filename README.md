# FanCode Users Todo Completion Test

This project automates the verification of todo completion rates for users in the FanCode city using Java, REST Assured, Cucumber, TestNG, Extent Reports, and Log4j.

## Prerequisites

## Prerequisites

- Java JDK 11 or higher
- Maven
- Docker (optional, for containerized execution)

## Setup

1. git clone https://github.com/CrazyPro1/fancodeautomation.git
2. Navigate to the project directory
3. Run `mvn clean install` to download dependencies

## Running the Tests

Execute the following command from the project root:

```
mvn test
```

## Project Structure

- `src/main/java`: Contains the main source code (API clients, utilities, POJOs, config)
- - `src/main/resources`: Contains config properties and log4j2 configuration
- `src/test/java`: Contains the test code (step definitions, test runner)
- `src/test/resources`: Contains feature files and test configuration

## Reporting

Extent Reports are generated after test execution. You can find the report in the `test-output` directory.

## Logging

Log4j is configured to log information to both console and file. Log files are generated in the `logs` directory.


