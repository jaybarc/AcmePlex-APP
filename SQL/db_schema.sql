-- Drop Movies table if it already exists
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
DROP TABLE IF EXISTS Seats;

-- Create Seats table
CREATE TABLE Seats (
    seat_id INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for each seat
    row_num INT NOT NULL,                     -- Row number (1 to 7)
    seat_number INT NOT NULL,                 -- Seat number in the row (1 to 8)
    status ENUM('available', 'occupied', 'booked') DEFAULT 'available', -- Seat status
    booking_id INT NULL,                      -- Optional: Links to a booking record
    UNIQUE (row_num, seat_number)             -- Ensure no duplicate seat in the same row
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

-- Insert sample seats
INSERT INTO Seats (row_num, seat_number, status)
VALUES
(1, 1, 'available'), (1, 2, 'available'), (1, 3, 'available'), (1, 4, 'available'),
(1, 5, 'available'), (1, 6, 'available'), (1, 7, 'available'), (1, 8, 'available'),

(2, 1, 'available'), (2, 2, 'available'), (2, 3, 'available'), (2, 4, 'available'),
(2, 5, 'available'), (2, 6, 'available'), (2, 7, 'available'), (2, 8, 'available'),

(3, 1, 'available'), (3, 2, 'available'), (3, 3, 'available'), (3, 4, 'available'),
(3, 5, 'available'), (3, 6, 'available'), (3, 7, 'available'), (3, 8, 'available'),

(4, 1, 'available'), (4, 2, 'available'), (4, 3, 'available'), (4, 4, 'available'),
(4, 5, 'available'), (4, 6, 'available'), (4, 7, 'available'), (4, 8, 'available'),

(5, 1, 'available'), (5, 2, 'available'), (5, 3, 'available'), (5, 4, 'available'),
(5, 5, 'available'), (5, 6, 'available'), (5, 7, 'available'), (5, 8, 'available'),

(6, 1, 'available'), (6, 2, 'available'), (6, 3, 'available'), (6, 4, 'available'),
(6, 5, 'available'), (6, 6, 'available'), (6, 7, 'available'), (6, 8, 'available'),

(7, 1, 'available'), (7, 2, 'available'), (7, 3, 'available'), (7, 4, 'available'),
(7, 5, 'available'), (7, 6, 'available'), (7, 7, 'available'), (7, 8, 'available');


DROP TABLE IF EXISTS Payments;

-- Create Payments table with userID column
CREATE TABLE Payments (
                          paymentID INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for the payment
                          userID INT NOT NULL,                       -- User identifier
                          amount FLOAT NOT NULL,                     -- Payment amount
                          paymentDate DATE NOT NULL,                 -- Date of the payment
                          customerName VARCHAR(255) NOT NULL,        -- Customer name
                          bankID VARCHAR(255) NOT NULL,              -- Bank ID
                          cardNumber VARCHAR(255) NOT NULL,          -- Card number
                          FOREIGN KEY (userID) REFERENCES Users(UserID) -- Foreign key constraint
);

-- Insert sample payments
INSERT INTO Payments (userID, amount, paymentDate, customerName, bankID, cardNumber) VALUES
 (1, 100.50, '2023-01-15', 'John Doe', 'BANK123', '1234-5678-9012-3456'),
 (2, 250.75, '2023-02-20', 'Jane Smith', 'BANK456', '2345-6789-0123-4567'),
 (3, 300.00, '2023-03-10', 'Alice Johnson', 'BANK789', '3456-7890-1234-5678'),
 (4, 150.25, '2023-04-05', 'Bob Brown', 'BANK012', '4567-8901-2345-6789'),
 (5, 200.00, '2023-05-18', 'Charlie Davis', 'BANK345', '5678-9012-3456-7890')


-- Drop Users table if it already exists
DROP TABLE IF EXISTS Users;

-- Create Users table
CREATE TABLE Users (
                       UserID INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for the user
                       userEmail VARCHAR(255) NOT NULL,        -- User email
                       username VARCHAR(255) NOT NULL,         -- Username
                       password VARCHAR(255) NOT NULL,         -- User password
                       firstName VARCHAR(255) NOT NULL,        -- User's first name
                       lastName VARCHAR(255) NOT NULL,         -- User's last name
                       address VARCHAR(255),                    -- User's address
                       bankID VARCHAR(255)                      -- Bank ID
);

-- Insert sample users
INSERT INTO Users (userEmail, username, password, firstName, lastName, address, bankID) VALUES
('john.doe@example.com', 'johndoe', 'password123', 'John', 'Doe', '123 Main St', 'BANK123'),
('jane.smith@example.com', 'janesmith', 'password456', 'Jane', 'Smith', '456 Elm St', 'BANK456'),
('alice.johnson@example.com', 'alicej', 'password789', 'Alice', 'Johnson', '789 Oak St', 'BANK789'),
('bob.brown@example.com', 'bobbrown', 'password101', 'Bob', 'Brown', '101 Pine St', 'BANK012'),
('charlie.davis@example.com', 'charlied', 'password202', 'Charlie', 'Davis', '202 Maple St', 'BANK345');