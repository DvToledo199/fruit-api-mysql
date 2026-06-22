# Fruit API - MySQL

REST API developed with Spring Boot for managing fruit suppliers and their products.

This project was created following the user stories and acceptance criteria defined in the assignment. It applies a layered architecture using Controllers, Services, Repositories, DTOs, validation, exception handling, Docker and MySQL.

---

## Technologies

- Java 21
- Spring Boot 3
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Docker
- Docker Compose
- JUnit 5
- Mockito

---

## Project Architecture

The application follows a layered architecture:

- Controller layer: handles HTTP requests and responses.
- Service layer: contains business logic.
- Repository layer: manages database access using Spring Data JPA.
- DTO layer: handles request and response objects.
- Exception layer: centralizes error management.

DTOs are used to avoid exposing entities directly through the API.

---

## User Stories Implemented

### 1. Register a Supplier

The system allows creating suppliers with:

- Name
- Country

Rules:

- Supplier names must be unique.
- Supplier names cannot be empty.
- Successful creation returns HTTP 201 Created.

---

### 2. Add a Fruit Associated with a Supplier

The system allows creating fruits linked to an existing supplier.

Rules:

- A valid supplier ID is required.
- Fruits cannot be created without a supplier.
- If the supplier does not exist, HTTP 404 Not Found is returned.
- Successful creation returns HTTP 201 Created.

---

### 3. Filter Fruits by Supplier

The system allows retrieving all fruits belonging to a specific supplier.

Rules:

- Search by supplier ID.
- Existing supplier returns HTTP 200 OK.
- Non-existing supplier returns HTTP 404 Not Found.

---

### 4. Update a Supplier

The system allows updating supplier information.

Rules:

- Supplier must exist.
- Name cannot be empty.
- Duplicate supplier names are not allowed.
- Successful update returns HTTP 200 OK.

---

### 5. Delete a Supplier

The system allows deleting suppliers.

Rules:

- Supplier must exist.
- Suppliers with associated fruits cannot be deleted.
- Successful deletion returns HTTP 204 No Content.
- Non-existing supplier returns HTTP 404 Not Found.

---

## Validation

The application uses Jakarta Validation.

Implemented validations:

### Supplier

- Name: @NotBlank
- Country: @NotBlank

### Fruit

- Name: @NotBlank
- Weight: @Positive
- Supplier ID: @NotNull

Invalid requests return HTTP 400 Bad Request.

---

## Exception Handling

A GlobalExceptionHandler has been implemented to centralize error management.

Handled exceptions:

- ProviderNotFoundException
- ProviderAlreadyExistsException
- ProviderHasFruitsException
- MethodArgumentNotValidException

Returned HTTP codes:

- 400 Bad Request
- 404 Not Found

---

## Main Endpoints

### Suppliers

Create supplier:

POST /providers

Update supplier:

PUT /providers/{id}

Delete supplier:

DELETE /providers/{id}

### Fruits

Create fruit:

POST /fruits

Get fruits by supplier:

GET /fruits/provider/{providerId}

---

## Example Requests

### Create Supplier

{
  "name": "Mercadona",
  "country": "Spain"
}

### Create Fruit

{
  "name": "Apple",
  "weightInKilos": 5,
  "providerId": 1
}

---

## Testing

The project includes:

- Spring Boot context test.
- Unit tests with Mockito.

Tested business scenarios include:

- Creating suppliers.
- Duplicate supplier validation.
- Updating suppliers.
- Supplier existence validation.
- Deleting suppliers with associated fruits.
- Successful supplier deletion.

---

## Docker Support

The project includes:

- Dockerfile
- Docker Compose configuration

Database connection is configured through environment variables.

### Run with Docker

Build and start all services:

mvn clean package

docker compose up --build

The API will be available at:

http://localhost:8080

---

## Local Execution

Compile the project:

mvn clean package

Run the application:

mvn spring-boot:run

---

## Author

David
