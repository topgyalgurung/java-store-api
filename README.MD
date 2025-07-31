# Spring Boot E-Commerce REST API

A real-world, production-ready backend built with Spring Boot for an e-commerce platform. This project focuses on scalable architecture, secure API development, and deployment-ready practices.

## 🚀 Goal

Build and deploy a full-featured e-commerce backend from scratch using Spring Boot, with proper structure, security, and integration best practices.

## 🛠️ Tech Stack

* **Backend**: Spring Boot, Spring MVC, Spring Security, Spring Data JPA
* **Database**: MySQL
* **Build Tool**: Maven
* **Payment**: Stripe API
* **Template Engine** (optional SSR): Thymeleaf
* **Object Mapping**: MapStruct
* **Tools**: Postman, Lombok

## ✅ Features

* User registration, login, and authentication
* Role-based authorization
* CRUD operations for users and products
* Dynamic routing and query param handling
* DTOs for secure, structured API responses
* JSON serialization control with Jackson
* API versioning support
* Payment processing via Stripe
* Deployment ready configuration

## 📂 Project Structure

```
├── controllers
├── dtos
├── entities
├── mappers
├── repositories
├── resources
│   ├── templates
│   └── application.yml
└── ...
```

## 📄 Notable Topics Covered

### Spring MVC & REST API

* Controller setup (`@RestController`, `@GetMapping`, `@PostMapping`)
* JSON responses using POJOs
* Exception handling with `ResponseEntity`

### Template Rendering

* Thymeleaf integration for SSR
* Model-driven data injection into views

### DTO & Entity Mapping

* Using DTOs to avoid exposing sensitive data
* MapStruct for compile-time safe DTO mapping

### Secure API with Spring Security

* Authentication and token-based authorization
* Role-based access control (RBAC)

### Advanced Request Handling

* Path variables, query parameters, and request headers
* Extract and validate request bodies for POST/PUT requests

### Payments

* Stripe integration for checkout and orders

### Deployment

* Environment config via `application.yml`
* MySQL setup and credentials

## 🧪 Testing

Use Postman to test live endpoints. Example:

```bash
GET /users
GET /users/1
GET /user?sort=name
POST /users
GET /products
GET /products?categoryId=1
PUT /users/1 
  - body: {name: "Topgyal", email:"topgyal@gmail.com"}
PUT /users/100
  - 404 Not Found
DELETE /users/1
- success: 204 No Content
DELETE /users/100
- fail: 404 Not Found
```
> **⚠️ NOTE:** The current implementation uses plain text passwords for development purposes only. This will be replaced with secure password hashing in future updates as the project progresses.
## Shortcuts for Intellij
- Cmd + R - to run app
- Cmd + Shift + O - to search files 
- Cmd + N - Add Dependency 
- etc

<!-- Use headers for auth:

```
x-auth-token: your_token_here
``` -->

## 🧱 Setup Instructions

1. **Clone and run locally**

```bash
git clone https://github.com/topgyalgurung/java-store-api.git
cd java-store-api
./mvnw spring-boot:run
```

2. **Configure MySQL DB**
   Update `application.yml`:

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ecommerce
    username: root
    password: your_mysqldb_password
```

3. **Lombok and MapStruct setup**
   Make sure your IDE supports annotation processors.

<!-- ## 📸 Demo & Screenshots

Coming soon — postman collections & demo video.

## 🤝 Contributions

Contributions are welcome. Please open issues or submit a PR.

## 📜 License

MIT -->

<!-- ## 📬 Contact

Topgyal Gurung
[LinkedIn](https://www.linkedin.com/in/topgyalgurung)
[Portfolio](https://topgyalgurung.me)
Email: [topgyal.gurung@gmail.com](mailto:topgyalgurung1@gmail.com) -->
