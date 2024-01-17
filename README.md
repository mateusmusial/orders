## About Project

On this project, I built a simple REST API with a domain model of an ordering application just to develop my skills with the Java Spring Boot framework.

This is a simple project developed just for tests, it does not have an authentication method and it should not used in production.

Some of technologies used:

* Java 17
* Maven
* Spring Boot Framework 3.2
* JPA/Hibernate
* H2 (in-memory relational database)

![Intellij IDEA](https://raw.githubusercontent.com/mateusmusial/assets/main/orders/Screenshot%202024-01-16%20at%2021.52.21.png)

## Domain Model

![Domain Model](https://raw.githubusercontent.com/mateusmusial/assets/main/orders/Screenshot%20at%20Jan%2016%2022-23-03.png)

## Endpoints

| Endpoint | Data |
| ------- | ------- |
| `GET /users` | All users |
| `GET /users/{id}`| User by id |
| `POST /users` | Create a new user |
| `DELETE /users/{id}` | Delete user by id |
| `PUT /users/{id}` | Edit a user |
| `GET /orders/{id}` | Order by id |
| `GET /categories` | All product categories  |
| `GET /categories/{id}` | Categories by id |
| `GET /products` | All products |
| `GET /products/{id}` | Products by id |

Request body template for `POST /users` and `PUT /users/{id}`:

```json
{
  "name": "Bob Brown",
  "email": "bob@gmail.com",
  "phone": "977557755"
}
```

## Run Project

Requirements:

* [Java 17](https://www.oracle.com/java/technologies/downloads/) or later
* [Maven 3.5+](https://maven.apache.org/download.cgi)

Clone repository:

```bash
git clone https://github.com/mateusmusial/orders.git
```

Linux/MacOS:

```bash
./mvnw spring-boot:run
```

Windows:

```prompt
.\mvnw.cmd spring-boot:run
```
