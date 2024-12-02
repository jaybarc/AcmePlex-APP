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
(1, 1, 'available', 1), (1, 2, 'available', 1), (1, 3, 'available', 1), (1, 4, 'available', 1), (1, 5, 'available', 1), (1, 6, 'available', 1), (1, 7, 'available', 1), (1, 8, 'available', 1),
(2, 1, 'available', 1), (2, 2, 'available', 1), (2, 3, 'available', 1), (2, 4, 'available', 1), (2, 5, 'available', 1), (2, 6, 'available', 1), (2, 7, 'available', 1), (2, 8, 'available', 1),
(3, 1, 'available', 1), (3, 2, 'available', 1), (3, 3, 'available', 1), (3, 4, 'available', 1), (3, 5, 'available', 1), (3, 6, 'available', 1), (3, 7, 'available', 1), (3, 8, 'available', 1),
(4, 1, 'available', 1), (4, 2, 'available', 1), (4, 3, 'available', 1), (4, 4, 'available', 1), (4, 5, 'available', 1), (4, 6, 'available', 1), (4, 7, 'available', 1), (4, 8, 'available', 1),
(5, 1, 'available', 1), (5, 2, 'available', 1), (5, 3, 'available', 1), (5, 4, 'available', 1), (5, 5, 'available', 1), (5, 6, 'available', 1), (5, 7, 'available', 1), (5, 8, 'available', 1),
(6, 1, 'available', 1), (6, 2, 'occupied', 1), (6, 3, 'occupied', 1), (6, 4, 'available', 1), (6, 5, 'available', 1), (6, 6, 'available', 1), (6, 7, 'available', 1), (6, 8, 'available', 1),
(7, 1, 'available', 1), (7, 2, 'available', 1), (7, 3, 'occupied', 1), (7, 4, 'occupied', 1), (7, 5, 'available', 1), (7, 6, 'available', 1), (7, 7, 'available', 1), (7, 8, 'available', 1),

-- Movie 2
(1, 1, 'occupied', 2), (1, 2, 'occupied', 2), (1, 3, 'occupied', 2), (1, 4, 'available', 2), (1, 5, 'available', 2), (1, 6, 'available', 2), (1, 7, 'available', 2), (1, 8, 'available', 2),
(2, 1, 'available', 2), (2, 2, 'available', 2), (2, 3, 'available', 2), (2, 4, 'occupied', 2), (2, 5, 'occupied', 2), (2, 6, 'occupied', 2), (2, 7, 'available', 2), (2, 8, 'available', 2),
(3, 1, 'available', 2), (3, 2, 'available', 2), (3, 3, 'available', 2), (3, 4, 'available', 2), (3, 5, 'available', 2), (3, 6, 'available', 2), (3, 7, 'available', 2), (3, 8, 'available', 2),
(4, 1, 'available', 2), (4, 2, 'available', 2), (4, 3, 'available', 2), (4, 4, 'available', 2), (4, 5, 'available', 2), (4, 6, 'available', 2), (4, 7, 'occupied', 2), (4, 8, 'occupied', 2),
(5, 1, 'available', 2), (5, 2, 'available', 2), (5, 3, 'available', 2), (5, 4, 'available', 2), (5, 5, 'available', 2), (5, 6, 'available', 2), (5, 7, 'available', 2), (5, 8, 'available', 2),
(6, 1, 'available', 2), (6, 2, 'available', 2), (6, 3, 'available', 2), (6, 4, 'available', 2), (6, 5, 'available', 2), (6, 6, 'available', 2), (6, 7, 'available', 2), (6, 8, 'available', 2),
(7, 1, 'available', 2), (7, 2, 'available', 2), (7, 3, 'available', 2), (7, 4, 'available', 2), (7, 5, 'available', 2), (7, 6, 'available', 2), (7, 7, 'available', 2), (7, 8, 'available', 2),

-- Movie 3
(1, 1, 'available', 3), (1, 2, 'occupied', 3), (1, 3, 'occupied', 3), (1, 4, 'occupied', 3), (1, 5, 'occupied', 3), (1, 6, 'occupied', 3), (1, 7, 'occupied', 3), (1, 8, 'occupied', 3),
(2, 1, 'occupied', 3), (2, 2, 'available', 3), (2, 3, 'available', 3), (2, 4, 'available', 3), (2, 5, 'available', 3), (2, 6, 'available', 3), (2, 7, 'available', 3), (2, 8, 'available', 3),
(3, 1, 'available', 3), (3, 2, 'available', 3), (3, 3, 'available', 3), (3, 4, 'available', 3), (3, 5, 'available', 3), (3, 6, 'available', 3), (3, 7, 'available', 3), (3, 8, 'available', 3),
(4, 1, 'available', 3), (4, 2, 'available', 3), (4, 3, 'available', 3), (4, 4, 'available', 3), (4, 5, 'available', 3), (4, 6, 'available', 3), (4, 7, 'available', 3), (4, 8, 'available', 3),
(5, 1, 'available', 3), (5, 2, 'available', 3), (5, 3, 'available', 3), (5, 4, 'available', 3), (5, 5, 'available', 3), (5, 6, 'available', 3), (5, 7, 'available', 3), (5, 8, 'available', 3),
(6, 1, 'available', 3), (6, 2, 'available', 3), (6, 3, 'available', 3), (6, 4, 'available', 3), (6, 5, 'available', 3), (6, 6, 'available', 3), (6, 7, 'available', 3), (6, 8, 'available', 3),
(7, 1, 'available', 3), (7, 2, 'available', 3), (7, 3, 'available', 3), (7, 4, 'available', 3), (7, 5, 'available', 3), (7, 6, 'available', 3), (7, 7, 'available', 3), (7, 8, 'available', 3),

-- Movie 4
(1, 1, 'available', 4), (1, 2, 'available', 4), (1, 3, 'available', 4), (1, 4, 'available', 4), (1, 5, 'available', 4), (1, 6, 'available', 4), (1, 7, 'available', 4), (1, 8, 'available', 4),
(2, 1, 'available', 4), (2, 2, 'available', 4), (2, 3, 'available', 4), (2, 4, 'available', 4), (2, 5, 'available', 4), (2, 6, 'available', 4), (2, 7, 'available', 4), (2, 8, 'available', 4),
(3, 1, 'available', 4), (3, 2, 'available', 4), (3, 3, 'available', 4), (3, 4, 'available', 4), (3, 5, 'available', 4), (3, 6, 'available', 4), (3, 7, 'available', 4), (3, 8, 'available', 4),
(4, 1, 'available', 4), (4, 2, 'available', 4), (4, 3, 'available', 4), (4, 4, 'available', 4), (4, 5, 'available', 4), (4, 6, 'available', 4), (4, 7, 'available', 4), (4, 8, 'available', 4),
(5, 1, 'available', 4), (5, 2, 'available', 4), (5, 3, 'available', 4), (5, 4, 'available', 4), (5, 5, 'available', 4), (5, 6, 'available', 4), (5, 7, 'available', 4), (5, 8, 'available', 4),
(6, 1, 'available', 4), (6, 2, 'available', 4), (6, 3, 'available', 4), (6, 4, 'available', 4), (6, 5, 'available', 4), (6, 6, 'available', 4), (6, 7, 'available', 4), (6, 8, 'available', 4),
(7, 1, 'available', 4), (7, 2, 'available', 4), (7, 3, 'available', 4), (7, 4, 'available', 4), (7, 5, 'available', 4), (7, 6, 'available', 4), (7, 7, 'available', 4), (7, 8, 'available', 4),

-- Movie 5
(1, 1, 'available', 5), (1, 2, 'available', 5), (1, 3, 'available', 5), (1, 4, 'available', 5), (1, 5, 'available', 5), (1, 6, 'available', 5), (1, 7, 'available', 5), (1, 8, 'available', 5),
(2, 1, 'available', 5), (2, 2, 'available', 5), (2, 3, 'available', 5), (2, 4, 'available', 5), (2, 5, 'available', 5), (2, 6, 'available', 5), (2, 7, 'available', 5), (2, 8, 'available', 5),
(3, 1, 'available', 5), (3, 2, 'available', 5), (3, 3, 'available', 5), (3, 4, 'available', 5), (3, 5, 'available', 5), (3, 6, 'available', 5), (3, 7, 'available', 5), (3, 8, 'available', 5),
(4, 1, 'available', 5), (4, 2, 'available', 5), (4, 3, 'available', 5), (4, 4, 'available', 5), (4, 5, 'available', 5), (4, 6, 'available', 5), (4, 7, 'available', 5), (4, 8, 'available', 5),
(5, 1, 'available', 5), (5, 2, 'available', 5), (5, 3, 'available', 5), (5, 4, 'available', 5), (5, 5, 'available', 5), (5, 6, 'available', 5), (5, 7, 'available', 5), (5, 8, 'available', 5),
(6, 1, 'available', 5), (6, 2, 'available', 5), (6, 3, 'available', 5), (6, 4, 'available', 5), (6, 5, 'available', 5), (6, 6, 'available', 5), (6, 7, 'available', 5), (6, 8, 'available', 5),
(7, 1, 'available', 5), (7, 2, 'available', 5), (7, 3, 'available', 5), (7, 4, 'available', 5), (7, 5, 'available', 5), (7, 6, 'available', 5), (7, 7, 'available', 5), (7, 8, 'available', 5),

-- Movie 6
(1, 1, 'available', 6), (1, 2, 'available', 6), (1, 3, 'available', 6), (1, 4, 'available', 6), (1, 5, 'available', 6), (1, 6, 'available', 6), (1, 7, 'available', 6), (1, 8, 'available', 6),
(2, 1, 'available', 6), (2, 2, 'available', 6), (2, 3, 'available', 6), (2, 4, 'available', 6), (2, 5, 'available', 6), (2, 6, 'available', 6), (2, 7, 'available', 6), (2, 8, 'available', 6),
(3, 1, 'available', 6), (3, 2, 'available', 6), (3, 3, 'available', 6), (3, 4, 'available', 6), (3, 5, 'available', 6), (3, 6, 'available', 6), (3, 7, 'available', 6), (3, 8, 'available', 6),
(4, 1, 'available', 6), (4, 2, 'available', 6), (4, 3, 'available', 6), (4, 4, 'available', 6), (4, 5, 'available', 6), (4, 6, 'available', 6), (4, 7, 'available', 6), (4, 8, 'available', 6),
(5, 1, 'available', 6), (5, 2, 'available', 6), (5, 3, 'available', 6), (5, 4, 'available', 6), (5, 5, 'available', 6), (5, 6, 'available', 6), (5, 7, 'available', 6), (5, 8, 'available', 6),
(6, 1, 'available', 6), (6, 2, 'available', 6), (6, 3, 'available', 6), (6, 4, 'available', 6), (6, 5, 'available', 6), (6, 6, 'available', 6), (6, 7, 'available', 6), (6, 8, 'available', 6),
(7, 1, 'available', 6), (7, 2, 'available', 6), (7, 3, 'available', 6), (7, 4, 'available', 6), (7, 5, 'available', 6), (7, 6, 'available', 6), (7, 7, 'available', 6), (7, 8, 'available', 6),

-- Movie 7
(1, 1, 'available', 7), (1, 2, 'available', 7), (1, 3, 'available', 7), (1, 4, 'available', 7), (1, 5, 'available', 7), (1, 6, 'available', 7), (1, 7, 'available', 7), (1, 8, 'available', 7),
(2, 1, 'available', 7), (2, 2, 'available', 7), (2, 3, 'available', 7), (2, 4, 'available', 7), (2, 5, 'available', 7), (2, 6, 'available', 7), (2, 7, 'available', 7), (2, 8, 'available', 7),
(3, 1, 'available', 7), (3, 2, 'available', 7), (3, 3, 'available', 7), (3, 4, 'available', 7), (3, 5, 'available', 7), (3, 6, 'available', 7), (3, 7, 'available', 7), (3, 8, 'available', 7),
(4, 1, 'available', 7), (4, 2, 'available', 7), (4, 3, 'available', 7), (4, 4, 'available', 7), (4, 5, 'available', 7), (4, 6, 'available', 7), (4, 7, 'available', 7), (4, 8, 'available', 7),
(5, 1, 'available', 7), (5, 2, 'available', 7), (5, 3, 'available', 7), (5, 4, 'available', 7), (5, 5, 'available', 7), (5, 6, 'available', 7), (5, 7, 'available', 7), (5, 8, 'available', 7),
(6, 1, 'available', 7), (6, 2, 'available', 7), (6, 3, 'available', 7), (6, 4, 'available', 7), (6, 5, 'available', 7), (6, 6, 'available', 7), (6, 7, 'available', 7), (6, 8, 'available', 7),
(7, 1, 'available', 7), (7, 2, 'available', 7), (7, 3, 'available', 7), (7, 4, 'available', 7), (7, 5, 'available', 7), (7, 6, 'available', 7), (7, 7, 'available', 7), (7, 8, 'available', 7),

-- Movie 8
(1, 1, 'available', 8), (1, 2, 'available', 8), (1, 3, 'available', 8), (1, 4, 'available', 8), (1, 5, 'available', 8), (1, 6, 'available', 8), (1, 7, 'available', 8), (1, 8, 'available', 8),
(2, 1, 'available', 8), (2, 2, 'available', 8), (2, 3, 'available', 8), (2, 4, 'available', 8), (2, 5, 'available', 8), (2, 6, 'available', 8), (2, 7, 'available', 8), (2, 8, 'available', 8),
(3, 1, 'available', 8), (3, 2, 'available', 8), (3, 3, 'available', 8), (3, 4, 'available', 8), (3, 5, 'available', 8), (3, 6, 'available', 8), (3, 7, 'available', 8), (3, 8, 'available', 8),
(4, 1, 'available', 8), (4, 2, 'available', 8), (4, 3, 'available', 8), (4, 4, 'available', 8), (4, 5, 'available', 8), (4, 6, 'available', 8), (4, 7, 'available', 8), (4, 8, 'available', 8),
(5, 1, 'available', 8), (5, 2, 'available', 8), (5, 3, 'available', 8), (5, 4, 'available', 8), (5, 5, 'available', 8), (5, 6, 'available', 8), (5, 7, 'available', 8), (5, 8, 'available', 8),
(6, 1, 'available', 8), (6, 2, 'available', 8), (6, 3, 'available', 8), (6, 4, 'available', 8), (6, 5, 'available', 8), (6, 6, 'available', 8), (6, 7, 'available', 8), (6, 8, 'available', 8),
(7, 1, 'available', 8), (7, 2, 'available', 8), (7, 3, 'available', 8), (7, 4, 'available', 8), (7, 5, 'available', 8), (7, 6, 'available', 8), (7, 7, 'available', 8), (7, 8, 'available', 8),

-- Movie 9
(1, 1, 'available', 9), (1, 2, 'available', 9), (1, 3, 'available', 9), (1, 4, 'available', 9), (1, 5, 'available', 9), (1, 6, 'available', 9), (1, 7, 'available', 9), (1, 8, 'available', 9),
(2, 1, 'available', 9), (2, 2, 'available', 9), (2, 3, 'available', 9), (2, 4, 'available', 9), (2, 5, 'available', 9), (2, 6, 'available', 9), (2, 7, 'available', 9), (2, 8, 'available', 9),
(3, 1, 'available', 9), (3, 2, 'available', 9), (3, 3, 'available', 9), (3, 4, 'available', 9), (3, 5, 'available', 9), (3, 6, 'available', 9), (3, 7, 'available', 9), (3, 8, 'available', 9),
(4, 1, 'available', 9), (4, 2, 'available', 9), (4, 3, 'available', 9), (4, 4, 'available', 9), (4, 5, 'available', 9), (4, 6, 'available', 9), (4, 7, 'available', 9), (4, 8, 'available', 9),
(5, 1, 'available', 9), (5, 2, 'available', 9), (5, 3, 'available', 9), (5, 4, 'available', 9), (5, 5, 'available', 9), (5, 6, 'available', 9), (5, 7, 'available', 9), (5, 8, 'available', 9),
(6, 1, 'available', 9), (6, 2, 'available', 9), (6, 3, 'available', 9), (6, 4, 'available', 9), (6, 5, 'available', 9), (6, 6, 'available', 9), (6, 7, 'available', 9), (6, 8, 'available', 9),
(7, 1, 'available', 9), (7, 2, 'available', 9), (7, 3, 'available', 9), (7, 4, 'available', 9), (7, 5, 'available', 9), (7, 6, 'available', 9), (7, 7, 'available', 9), (7, 8, 'available', 9),

-- Movie 10
(1, 1, 'available', 10), (1, 2, 'available', 10), (1, 3, 'available', 10), (1, 4, 'available', 10), (1, 5, 'available', 10), (1, 6, 'available', 10), (1, 7, 'available', 10), (1, 8, 'available', 10),
(2, 1, 'available', 10), (2, 2, 'available', 10), (2, 3, 'available', 10), (2, 4, 'available', 10), (2, 5, 'available', 10), (2, 6, 'available', 10), (2, 7, 'available', 10), (2, 8, 'available', 10),
(3, 1, 'available', 10), (3, 2, 'available', 10), (3, 3, 'available', 10), (3, 4, 'available', 10), (3, 5, 'available', 10), (3, 6, 'available', 10), (3, 7, 'available', 10), (3, 8, 'available', 10),
(4, 1, 'available', 10), (4, 2, 'available', 10), (4, 3, 'available', 10), (4, 4, 'available', 10), (4, 5, 'available', 10), (4, 6, 'available', 10), (4, 7, 'available', 10), (4, 8, 'available', 10),
(5, 1, 'available', 10), (5, 2, 'available', 10), (5, 3, 'available', 10), (5, 4, 'available', 10), (5, 5, 'available', 10), (5, 6, 'available', 10), (5, 7, 'available', 10), (5, 8, 'available', 10),
(6, 1, 'available', 10), (6, 2, 'available', 10), (6, 3, 'available', 10), (6, 4, 'available', 10), (6, 5, 'available', 10), (6, 6, 'available', 10), (6, 7, 'available', 10), (6, 8, 'available', 10),
(7, 1, 'available', 10), (7, 2, 'available', 10), (7, 3, 'available', 10), (7, 4, 'available', 10), (7, 5, 'available', 10), (7, 6, 'available', 10), (7, 7, 'available', 10), (7, 8, 'available', 10);

DROP TABLE IF EXISTS Showtimes;
-- Create Showtimes table
CREATE TABLE Showtimes (
                           showtime_id INT AUTO_INCREMENT PRIMARY KEY,
                           movie_id INT NOT NULL,
                           showtime TIMESTAMP NOT NULL,
                           FOREIGN KEY (movie_id) REFERENCES Movies(id)
);

DROP TABLE IF EXISTS Rooms;
-- Create Rooms table
CREATE TABLE Rooms (
                       room_id INT AUTO_INCREMENT PRIMARY KEY,
                       room_number INT NOT NULL
);

DROP TABLE IF EXISTS Tickets;
CREATE TABLE Tickets (
                         ticketId INT PRIMARY KEY AUTO_INCREMENT,
                         seatId INT NOT NULL,
                         movieId INT NOT NULL,
                         showtimeId INT NOT NULL,
                         roomId INT NOT NULL,
                         FOREIGN KEY (seatId) REFERENCES Seats(seat_id),
                         FOREIGN KEY (movieId) REFERENCES Movies(id),
                         FOREIGN KEY (showtimeId) REFERENCES Showtimes(showtime_id),
                         FOREIGN KEY (roomId) REFERENCES Rooms(room_id)
);



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
    registrationDate DATE,         -- Date of registration
    bankBalance DECIMAL(10, 2)     -- User's bank balance
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

INSERT INTO Users (userEmail, username, password, firstName, lastName, registrationDate, bankBalance)
VALUES 
('john.doe@example.com', 'johndoe', 'password123', 'John', 'Doe', '2023-10-01', 1000.00),
('jane.smith@example.com', 'janesmith', 'password456', 'Jane', 'Smith', '2023-10-02', 1500.50),
('alice.johnson@example.com', 'alicejohnson', 'password789', 'Alice', 'Johnson', '2023-10-03', 2000.75),
('bob.brown@example.com', 'bobbrown', 'password321', 'Bob', 'Brown', '2023-10-04', 1200.00),
('carol.white@example.com', 'carolwhite', 'password654', 'Carol', 'White', '2023-10-05', 1800.25);

-- Insert sample payments into Payments table
-- Match userID with the appropriate UserID from the Users table
INSERT INTO Payments (userID, amount, paymentDate, customerName, bankID, cardNumber) VALUES
(1, 100.50, '2023-01-15', 'John Doe', 'BANK123', '1234-5678-9012-3456'),
(2, 250.75, '2023-02-20', 'Jane Smith', 'BANK456', '2345-6789-0123-4567'),
(3, 300.00, '2023-03-10', 'Alice Johnson', 'BANK789', '3456-7890-1234-5678'),
(4, 150.25, '2023-04-05', 'Bob Brown', 'BANK012', '4567-8901-2345-6789'),
(5, 200.00, '2023-05-18', 'Charlie Davis', 'BANK345', '5678-9012-3456-7890');