# UserServiceJan25

UserServiceJan25 is a production-ready Java Spring Boot microservice for user management, authentication, and authorization. It provides RESTful APIs for user registration, login, logout, and token validation, and is designed to be integrated as part of a larger backend system.

## Features
- User registration and authentication
- Secure password storage with BCrypt
- Token-based authentication (with DB persistence)
- Role-based user model
- OAuth2 Authorization Server support (Spring Security)
- Extensible and modular service/repository structure
- Production-ready configuration and logging

## Technology Stack
- Java 17
- Spring Boot 3.4+
- Spring Data JPA (Hibernate)
- Spring Security & OAuth2 Authorization Server
- MySQL (default, configurable)
- Lombok
- Maven

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL (or compatible database)

### Setup
1. **Clone the repository:**
   ```bash
   git clone <repo-url>
   cd UserServiceJan25
   ```
2. **Configure the database:**
    - Update `src/main/resources/application.properties` with your DB credentials:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/userservicejan25
      spring.datasource.username=userservicejan25user
      spring.datasource.password=<your-password>
      ```
3. **Build the project:**
   ```bash
   mvn clean install
   ```
4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   The service will start on port `9000` by default.

## API Endpoints

### User APIs
| Method | Endpoint                | Description                |
|--------|-------------------------|----------------------------|
| POST   | `/users/signup`         | Register a new user        |
| POST   | `/users/login`          | Login and get auth token   |
| GET    | `/users/logout`         | Logout (invalidate token)  |
| GET    | `/users/validate/{tokenValue}` | Validate token and get user info |

#### Example Request/Response
- **Signup:**
  ```json
  POST /users/signup
  {
    "email": "user@example.com",
    "password": "password123",
    "name": "John Doe"
  }
  ```
- **Login:**
  ```json
  POST /users/login
  {
    "email": "user@example.com",
    "password": "password123"
  }
  Response: { "tokenValue": "...", "expiryDate": "..." }
  ```
- **Logout:**
  ```json
  GET /users/logout
  {
    "tokenValue": "..."
  }
  ```
- **Validate Token:**
  ```
  GET /users/validate/{tokenValue}
  Response: { "name": "John Doe", "email": "user@example.com", ... }
  ```

## Configuration
- All configuration is managed via `src/main/resources/application.properties`.
- Key properties:
    - `server.port`: Service port (default: 9000)
    - `spring.datasource.*`: Database connection
    - `spring.security.*`: Security and OAuth2 settings

## Project Structure
- `controllers/`    — REST API controllers
- `services/`       — Business logic and user management
- `models/`         — JPA entities (User, Token, Role)
- `dtos/`           — Data transfer objects for API
- `repositories/`   — Spring Data JPA repositories
- `exceptions/`     — Custom exception classes
- `securityconfigs/`/`security/` — Security and OAuth2 configuration

## Running Tests
- Unit and integration tests are in `src/test/java/`
- Run all tests:
  ```bash
  mvn test
  ```

## Contribution Guidelines
- Fork the repository and create a feature branch
- Write clear, concise commit messages
- Ensure all tests pass before submitting a PR
- Follow Java and Spring best practices

## License
This project is for educational and demonstration purposes. Please add a license if used in production.

## Contact
For questions or support, please contact the maintainer or open an issue. 