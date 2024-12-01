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

