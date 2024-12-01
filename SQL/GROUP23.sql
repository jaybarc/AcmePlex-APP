-- Drop the database if it exists
DROP DATABASE IF EXISTS acmeplexdb;

-- Create the database if it doesn't exist
CREATE DATABASE acmeplexdb;

-- Use the newly created database
USE acmeplexdb;

-- Drop Movies table if it already exists
DROP TABLE IF EXISTS Seats;
DROP TABLE IF EXISTS Movies;

-- Create Movies table with additional fields
CREATE TABLE Movies (
    id INT AUTO_INCREMENT PRIMARY KEY,   -- Unique identifier for the movie
    name VARCHAR(255) NOT NULL,          -- Movie title
    genre VARCHAR(100),                  -- Genre of the movie
    duration INT,                        -- Duration of the movie in minutes
    synopsis TEXT                       -- Brief synopsis of the movie
);


-- Drop Seats table if it already exists

-- Create Seats table with movie_id
CREATE TABLE Seats (
    seat_id INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for each seat
    row_num INT NOT NULL,                     -- Row number (1 to 7)
    seat_number INT NOT NULL,                 -- Seat number in the row (1 to 8)
    status ENUM('available', 'occupied', 'booked') DEFAULT 'available', -- Seat status
    booking_id INT NULL,                      -- Optional: Links to a booking record
    movie_id INT NOT NULL,                    -- Movie ID referencing the movie being shown
    UNIQUE (row_num, seat_number, movie_id),   -- Ensure no duplicate seat for the same movie
    FOREIGN KEY (movie_id) REFERENCES Movies(id)  -- Foreign key to the Movies table
);






-- Insert sample movies
-- Insert sample data
INSERT INTO Movies (name, genre, duration, synopsis) VALUES
('Inception', 'Sci-Fi', 148, 'A thief who enters the dreams of others to steal secrets from their subconscious is given a chance to have his criminal record erased if he can successfully perform an inception.'),
('Interstellar', 'Sci-Fi', 169, 'A team of explorers must travel beyond this galaxy to ensure humanity’s survival as Earth is dying.'),
('The Dark Knight', 'Action', 152, 'Batman faces off against the Joker, a criminal mastermind who seeks to create chaos in Gotham City.'),
('Parasite', 'Drama', 132, 'A poor family becomes entangled with a wealthy family, leading to unexpected consequences.'),
('Avengers: Endgame', 'Action', 181, 'The Avengers must work together to undo the damage caused by Thanos in the previous battle.'),
('Spider-Man: No Way Home', 'Action', 148, 'Peter Parker seeks the help of Doctor Strange to undo the chaos caused by the revelation of his secret identity.'),
('Titanic', 'Romance', 195, 'A young couple falls in love aboard the ill-fated R.M.S. Titanic.'),
('The Matrix', 'Sci-Fi', 136, 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.'),
('The Shawshank Redemption', 'Drama', 142, 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.'),
('The Godfather', 'Crime', 175, 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.');

INSERT INTO Seats (row_num, seat_number, status, movie_id)
VALUES
-- Movie 1
(1, 1, 'available', 1), (1, 2, 'occupied', 1), (1, 3, 'available', 1), (1, 4, 'available', 1),
(1, 5, 'available', 1), (1, 6, 'available', 1), (1, 7, 'available', 1), (1, 8, 'available', 1),

(2, 1, 'available', 1), (2, 2, 'available', 1), (2, 3, 'occupied', 1), (2, 4, 'available', 1),
(2, 5, 'available', 1), (2, 6, 'available', 1), (2, 7, 'available', 1), (2, 8, 'available', 1),

(3, 1, 'available', 1), (3, 2, 'available', 1), (3, 3, 'available', 1), (3, 4, 'available', 1),
(3, 5, 'available', 1), (3, 6, 'occupied', 1), (3, 7, 'available', 1), (3, 8, 'available', 1),

-- Movie 2
(4, 1, 'available', 2), (4, 2, 'available', 2), (4, 3, 'available', 2), (4, 4, 'available', 2),
(4, 5, 'available', 2), (4, 6, 'available', 2), (4, 7, 'available', 2), (4, 8, 'available', 2),

(5, 1, 'available', 2), (5, 2, 'occupied', 2), (5, 3, 'available', 2), (5, 4, 'available', 2),
(5, 5, 'available', 2), (5, 6, 'available', 2), (5, 7, 'available', 2), (5, 8, 'available', 2),

(6, 1, 'available', 2), (6, 2, 'available', 2), (6, 3, 'available', 2), (6, 4, 'available', 2),
(6, 5, 'available', 2), (6, 6, 'available', 2), (6, 7, 'occupied', 2), (6, 8, 'available', 2),

-- Movie 3
(7, 1, 'available', 3), (7, 2, 'available', 3), (7, 3, 'available', 3), (7, 4, 'available', 3),
(7, 5, 'occupied', 3), (7, 6, 'available', 3), (7, 7, 'available', 3), (7, 8, 'available', 3),

-- Movie 4
(1, 1, 'available', 4), (1, 2, 'available', 4), (1, 3, 'occupied', 4), (1, 4, 'available', 4),
(1, 5, 'available', 4), (1, 6, 'available', 4), (1, 7, 'available', 4), (1, 8, 'available', 4),

(2, 1, 'available', 4), (2, 2, 'available', 4), (2, 3, 'available', 4), (2, 4, 'occupied', 4),
(2, 5, 'available', 4), (2, 6, 'available', 4), (2, 7, 'available', 4), (2, 8, 'available', 4),

(3, 1, 'available', 4), (3, 2, 'available', 4), (3, 3, 'available', 4), (3, 4, 'occupied', 4),
(3, 5, 'available', 4), (3, 6, 'available', 4), (3, 7, 'available', 4), (3, 8, 'available', 4),

-- Movie 5
(4, 1, 'available', 5), (4, 2, 'available', 5), (4, 3, 'available', 5), (4, 4, 'available', 5),
(4, 5, 'occupied', 5), (4, 6, 'available', 5), (4, 7, 'available', 5), (4, 8, 'available', 5),

(5, 1, 'available', 5), (5, 2, 'available', 5), (5, 3, 'occupied', 5), (5, 4, 'available', 5),
(5, 5, 'available', 5), (5, 6, 'available', 5), (5, 7, 'available', 5), (5, 8, 'available', 5),

(6, 1, 'available', 5), (6, 2, 'available', 5), (6, 3, 'available', 5), (6, 4, 'available', 5),
(6, 5, 'available', 5), (6, 6, 'available', 5), (6, 7, 'available', 5), (6, 8, 'occupied', 5),

-- Movie 6
(7, 1, 'available', 6), (7, 2, 'available', 6), (7, 3, 'available', 6), (7, 4, 'available', 6),
(7, 5, 'available', 6), (7, 6, 'occupied', 6), (7, 7, 'available', 6), (7, 8, 'available', 6),

-- Movie 7
(1, 1, 'available', 7), (1, 2, 'available', 7), (1, 3, 'available', 7), (1, 4, 'available', 7),
(1, 5, 'occupied', 7), (1, 6, 'available', 7), (1, 7, 'available', 7), (1, 8, 'available', 7),

(2, 1, 'available', 7), (2, 2, 'available', 7), (2, 3, 'available', 7), (2, 4, 'available', 7),
(2, 5, 'available', 7), (2, 6, 'occupied', 7), (2, 7, 'available', 7), (2, 8, 'available', 7),

(3, 1, 'available', 7), (3, 2, 'available', 7), (3, 3, 'occupied', 7), (3, 4, 'available', 7),
(3, 5, 'available', 7), (3, 6, 'available', 7), (3, 7, 'available', 7), (3, 8, 'available', 7),

-- Movie 8
(4, 1, 'available', 8), (4, 2, 'available', 8), (4, 3, 'available', 8), (4, 4, 'available', 8),
(4, 5, 'available', 8), (4, 6, 'available', 8), (4, 7, 'available', 8), (4, 8, 'available', 8),

(5, 1, 'available', 8), (5, 2, 'occupied', 8), (5, 3, 'available', 8), (5, 4, 'available', 8),
(5, 5, 'available', 8), (5, 6, 'available', 8), (5, 7, 'available', 8), (5, 8, 'available', 8),

(6, 1, 'available', 8), (6, 2, 'available', 8), (6, 3, 'available', 8), (6, 4, 'available', 8),
(6, 5, 'available', 8), (6, 6, 'occupied', 8), (6, 7, 'available', 8), (6, 8, 'available', 8),

-- Movie 9
(7, 1, 'available', 9), (7, 2, 'available', 9), (7, 3, 'available', 9), (7, 4, 'available', 9),
(7, 5, 'available', 9), (7, 6, 'available', 9), (7, 7, 'available', 9), (7, 8, 'occupied', 9);


-- Drop Users table if it already exists
DROP TABLE IF EXISTS Payments;
DROP TABLE IF EXISTS Users;

-- Create Users table
CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for the user
    userEmail VARCHAR(255) NOT NULL,        -- User email
    username VARCHAR(255) NOT NULL,         -- Username
    password VARCHAR(255) NOT NULL,         -- User password
    firstName VARCHAR(255) NOT NULL,        -- User's first name
    lastName VARCHAR(255) NOT NULL,         -- User's last name
    address VARCHAR(255),                   -- User's address (nullable)
    customerName VARCHAR(255),              -- Customer name (nullable)
    bankID VARCHAR(255),                    -- Bank ID (nullable)
    UNIQUE (userEmail),                     -- Ensure unique emails
    UNIQUE (username)                       -- Ensure unique usernames
);

-- Create Payments table with userID column
CREATE TABLE Payments (
    paymentID INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for the payment
    userID INT NOT NULL,                       -- User identifier (foreign key)
    amount FLOAT NOT NULL,                     -- Payment amount
    paymentDate DATE NOT NULL,                 -- Date of the payment
    customerName VARCHAR(255) NOT NULL,        -- Customer name
    bankID VARCHAR(255) NOT NULL,              -- Bank ID
    cardNumber VARCHAR(255) NOT NULL,          -- Card number
    FOREIGN KEY (userID) REFERENCES Users(UserID) -- Foreign key constraint
);

-- Insert sample users into Users table
INSERT INTO Users (userEmail, username, password, firstName, lastName, address, customerName, bankID) VALUES
('john.doe@example.com', 'johndoe', 'password123', 'John', 'Doe', '123 Main St', 'John Doe', 'BANK123'),
('jane.smith@example.com', 'janesmith', 'password456', 'Jane', 'Smith', '456 Elm St', 'Jane Smith', 'BANK456'),
('alice.johnson@example.com', 'alicej', 'password789', 'Alice', 'Johnson', '789 Oak St', 'Alice Johnson', 'BANK789'),
('bob.brown@example.com', 'bobbrown', 'password101', 'Bob', 'Brown', '101 Pine St', 'Bob Brown', 'BANK012'),
('charlie.davis@example.com', 'charlied', 'password202', 'Charlie', 'Davis', '202 Maple St', 'Charlie Davis', 'BANK345');

-- Insert sample payments into Payments table
-- Match userID with the appropriate UserID from the Users table
INSERT INTO Payments (userID, amount, paymentDate, customerName, bankID, cardNumber) VALUES
(1, 100.50, '2023-01-15', 'John Doe', 'BANK123', '1234-5678-9012-3456'),
(2, 250.75, '2023-02-20', 'Jane Smith', 'BANK456', '2345-6789-0123-4567'),
(3, 300.00, '2023-03-10', 'Alice Johnson', 'BANK789', '3456-7890-1234-5678'),
(4, 150.25, '2023-04-05', 'Bob Brown', 'BANK012', '4567-8901-2345-6789'),
(5, 200.00, '2023-05-18', 'Charlie Davis', 'BANK345', '5678-9012-3456-7890');
