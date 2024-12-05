# AcmePlex Application
---
AcmePlex is a movie booking application utilizing HTML, CSS and Javascript for the frontend website and Java and MySQL for backend and database interaction. SpringBoot was used to connect Java to the frontend pages.

## Contributors
- [David Nguyen](https://github.com/DavidNg32)
- [Jerome Barcelona](https://github.com/jaybarc)
- [Alyan Qureshi](https://github.com/AlyanQureshi)
- [Jaival Patel](https://github.com/jaivalp22)
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
## Preview
### Homepage
![image](https://github.com/user-attachments/assets/59c810af-6d50-43de-a10b-6a17c2188746)

### Seat Viewing And Booking
![image](https://github.com/user-attachments/assets/79852292-f06e-4c2b-a179-37d921307964)

### Payment For Your Ticket
![image](https://github.com/user-attachments/assets/d98a699b-6821-4d04-843f-234b902b0010)





