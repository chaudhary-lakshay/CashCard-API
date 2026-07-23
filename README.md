# Cash Card API Documentation

## Introduction
This project is part of the **'Building a REST API with Spring Boot'** course from Spring Academy. The purpose of this project is to build a RESTful API for managing cash cards, implementing CRUD operations using Spring Boot. This is my first Spring Boot project, and I aim to refine my skills while applying best practices in API development.

## Project Setup
### Technologies Used
- **Java 23.0.1**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Maven**
- **JUnit & Testcontainers**
- **Spring Security**
- **GitHub for version control**

### Running the Application
1. Clone the repository from GitHub:
   ```sh
   git clone https://github.com/lakshay1341/CashCard-API.git
   ```
2. Navigate to the project directory and run:
   ```sh
   mvn spring-boot:run
   ```
3. The application will start on `http://localhost:8080`.

## API Endpoints
### 1. Get All Cash Cards
- **Endpoint:** `GET /cashcards`
- **Description:** Retrieves all cash cards.
- **Response Example:**
  ```json
  [
    {
      "id": 1,
      "amount": 100.0,
      "owner": "lakshay"
    }
  ]
  ```

### 2. Get Cash Card by ID
- **Endpoint:** `GET /cashcards/{id}`
- **Description:** Retrieves a specific cash card by its ID.
- **Response Example:**
  ```json
  {
    "id": 1,
    "amount": 100.0,
    "owner": "lakshay"
  }
  ```

### 3. Create a Cash Card
- **Endpoint:** `POST /cashcards`
- **Description:** Creates a new cash card.
- **Request Example:**
  ```json
  {
    "amount": 200.0,
    "owner": "lakshay"
  }
  ```
- **Response Example:**
  ```json
  {
    "id": 2,
    "amount": 200.0,
    "owner": "lakshay"
  }
  ```

### 4. Update a Cash Card
- **Endpoint:** `PUT /cashcards/{id}`
- **Description:** Updates an existing cash card.
- **Request Example:**
  ```json
  {
    "amount": 250.0,
    "owner": "lakshay"
  }
  ```
- **Response Example:**
  ```json
  {
    "id": 1,
    "amount": 250.0,
    "owner": "lakshay"
  }
  ```

### 5. Delete a Cash Card
- **Endpoint:** `DELETE /cashcards/{id}`
- **Description:** Deletes a cash card by ID.
- **Response:** 204 No Content

## Spring Security Implementation
The project is secured using **Spring Security** with Basic Authentication. Only authenticated users can access the API.

### Authentication Flow:
1. User sends a request with `Basic Auth` header (`Authorization: Basic <Base64EncodedCredentials>`).
2. Spring Security intercepts the request and verifies credentials.
3. If authentication is successful, the request is processed.
4. If authentication fails, a `401 Unauthorized` response is returned.

## Testing with JUnit and Testcontainers
The project includes integration tests using JUnit and Testcontainers to validate API functionality. Tests ensure that all CRUD operations work correctly.

## Version Control with GitHub
This project is version-controlled using GitHub. The repository includes:
- Source code and configurations
- Test cases and integration tests
- Detailed documentation

## Architecture Diagram
```
+------------------+         +----------------+         +-----------------+
|  Client         | <-----> |  Spring Boot   | <-----> |  H2 Database    |
|  (Postman, UI)  |         |  Application   |         |  (In-memory DB) |
+------------------+         +----------------+         +-----------------+
```

## Authentication Flow Diagram
```
User Request ---> Spring Security Interceptor ---> Validate Credentials ---> Process API Request
                            |                     |
                            |                     ---> Failure (401 Unauthorized)
                            ---> Success
```

### Course Overview
The course covers fundamental concepts of Spring Boot, including:
- Setting up a Spring Boot application
- Creating RESTful APIs
- Implementing CRUD operations
- Using Spring Data JPA with H2 Database
- Writing integration tests with JUnit and Testcontainers
- Securing APIs using Spring Security with Basic Authentication
- Deploying the project and managing version control with GitHub

Through this project, I have learned and applied these concepts in a real-world scenario, gaining hands-on experience with REST API development using Spring Boot.


## Conclusion
This project provided hands-on experience with Spring Boot and REST API development, reinforcing my understanding of:
- RESTful API best practices
- Spring Data JPA
- Integration testing with Testcontainers
- H2 Database for lightweight persistence
- Securing APIs using Spring Security
- Managing code with GitHub

This documentation serves as a guide for understanding and using the Cash Card API effectively.


## Contributing

Issues here are **first come, first merged**. Assignment is not reservation: if an issue is assigned to someone and you open a working PR first, yours is the one that gets merged. Commenting "I'd like to work on this" is welcome and I'll assign it, but it does not hold the issue against a PR that arrives sooner. If you want an issue, the reliable way to get it is to open the PR.
