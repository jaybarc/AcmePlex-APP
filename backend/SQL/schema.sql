-- Drop Movies table if it already exists
DROP TABLE IF EXISTS Movies;

-- Create Movies table with additional fields
CREATE TABLE Movies (
    id INT AUTO_INCREMENT PRIMARY KEY,   -- Unique identifier for the movie
    name VARCHAR(255) NOT NULL,          -- Movie title
    genre VARCHAR(100),                  -- Genre of the movie
    duration INT,                        -- Duration of the movie in minutes
    synopsis TEXT,                       -- Brief synopsis of the movie
    price DECIMAL(5, 2) NOT NULL         -- Ticket price for the movie
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
