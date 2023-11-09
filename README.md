# E-commerce User Module

This is a Maven project for the User Module in an e-commerce website. The module is responsible for authenticating and authorizing users.

## Project Information

- **Group ID:** com.jobhacker
- **Artifact ID:** ecommerce
- **Version:** 0.0.1-SNAPSHOT
- **Name:** UserModule
- **Description:** This module is responsible for authenticating and authorizing users on the e-commerce website.

## Dependencies

- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Web
- MySQL Connector
- Lombok
- MapStruct
- Lombok MapStruct Binding
- Spring Boot Starter Validation
- Springdoc OpenAPI Starter WebMvc UI

### Development Dependencies

- Spring Boot Starter Test
- Spring Security Test

# Project Structure

## Package: com.jobhacker.user

### 1. Configuration
   - **Security Configuration**
     - `SecurityConfiguration`: Configuration for security settings.
     - `PasswordConfiguration`: Configuration for password encoding.

### 2. Controller
   - `UserController`: Handles HTTP requests related to user operations.

### 3. Service
   - **Implementations**
     - `UserService`: Implementation of `UserService`.
     - `UserDetailsServiceImpl`: Implementation of `UserDetailsService`.

### 4. Data Transfer Objects (DTO)
   - `UserDTO`: Data Transfer Object for user-related information.

### 5. Entity
   - `User`: Entity representing user details.
   - `Role`: Entity representing user roles.

### 6. Exceptions
   - Custom exceptions for the User Module.

### 7. Mapper
   - `UserMapper`: Mapper for mapping between entities and DTOs.

### 8. Repository
   - `UserRepository`: Repository for database operations related to users.

### 9. Validations
   - Validation classes for user inputs and data.

### 10. Main Application Class
   - `UserModuleApplication`: Main class to bootstrap the User Module application.
# API URLs
https://app.swaggerhub.com/apis-docs/BASELKHAMES000/user-module/v1
