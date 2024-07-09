Here is the translated documentation for your project:

# Feature Toggle Project

## Description
Demo project for Spring Boot with feature toggle functionality using FF4J.

## Table of Contents
1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Installation](#installation)
4. [Configuration](#configuration)
5. [Project Structure](#project-structure)
6. [Usage](#usage)
7. [Contribution](#contribution)
8. [License](#license)
9. [Contact](#contact)

## Introduction
This project demonstrates how to set up a feature toggle system using Spring Boot and FF4J.

## Prerequisites
- Java 17
- Maven 3.6.3+
- Docker and Docker Compose

## Installation
Steps to set up the development environment:

```bash
# Clone the repository
git clone https://github.com/your-username/featuretoggle.git

# Navigate to the project directory
cd featuretoggle

# Build the project
mvn clean install
```

## Configuration
### Properties File
Configure the `application.properties` file with database credentials and other necessary settings:

```properties
server.address=127.0.0.1
server.port=8888

spring.application.name=featuretoggle

spring.security.user.name=<YOUR_USERNAME>
spring.security.user.password=<YOUR_PASSWORD>
spring.security.user.roles=ADMIN

spring.datasource.url=jdbc:mysql://localhost:3306/featuretoggle?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=<YOUR_USERNAME>
spring.datasource.password=<YOUR_PASSWORD>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Docker Compose
Start the MySQL container using Docker Compose:

```bash
# Start MySQL with Docker Compose
docker-compose up -d
```

## Project Structure
Description of the project directory structure and important files:

```
featuretoggle/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── company/
│   │   │           └── featuretoggle/
│   │   │               ├── configuration/
│   │   │               ├── controller/
│   │   │               ├── service/
│   │   │               └── FeatureToggleApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── java/
│           └── com/
│               └── company/
│                   └── featuretoggle/
└── pom.xml
```

## Usage
Instructions to run the project:

```bash
# Run the project
mvn spring-boot:run
```

Available endpoints and request examples:

### GET /api/features/check/{grantedClient}/{featureName}
Checks if a feature is enabled for a specific client.

```bash
curl -X GET http://localhost:8888/api/features/check/{grantedClient}/{featureName}
```

## Contribution
Guide to contribute to the project:

1. Fork the project
2. Create a branch for your feature (`git checkout -b feature/feature-name`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/feature-name`)
5. Open a Pull Request

## License
This project is licensed under the MIT License.

## Contact
For questions and support, contact:
- Email: [rafael.deroncio@hotmail.com](mailto:rafael.deroncio@hotmail.com)
- LinkedIn: [Rafael Deroncio](https://linkedin.com/in/rafael-deroncio)
```

This documentation provides a simplified overview of the project, including configuration, structure, and usage. Adapt as necessary to better reflect the details and specifics of your project.
