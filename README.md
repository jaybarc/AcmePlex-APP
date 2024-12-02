# AcmePlex Application

---
AcmePlex is a movie booking application built with Java, Spring Boot, and MySQL. The application allows users to register, view movies, book seats, and make payments.

## Technologies Used

- Java (Must be JDK version 21 or above (21 recommended))
- Spring Boot
- MySQL
- Maven (If you are using VScode, download Maven extension)
- JavaScript

## Project Structure

---
### Frontend
- `src/main/resources/static`: Contains the static resources (HTML, CSS, JavaScript) for the frontend.
- `src/main/resources/templates`: Contains the Thymeleaf templates for rendering the frontend.
---
### Backend
- `src/main/java/com/example/AcmePlex/backend/Control`: Contains the controllers for handling web requests.
- `src/main/java/com/example/AcmePlex/backend/Database`: Contains the Data Access Objects (DAOs) for database interactions.
- `src/main/java/com/example/AcmePlex/backend/Entity`: Contains the entity classes representing the database tables.

---
## Database Setup

1. Create the database and tables by running the following SQL script in the SQL directory in project root
2. Update the database connection details in `src/main/java/com/example/AcmePlex/backend/Database/DatabaseConnection.java`

---

## Running the Application
1. Clone the repository.
2. cd to the directory where `pom.xml` is located.
3. Run `mvn clean install` to build the project.
4. Run `mvn spring-boot:run` to start the application.
5. If both of the above fail, try running `AcmePlexApplication` file
6. Open your browser and go to `http://localhost:8080`.

---

