DROP DATABASE IF EXISTS oasisdb; 

-- Create the database
CREATE DATABASE IF NOT EXISTS oasisdb;
USE oasisdb;

-- Create the person table
CREATE TABLE IF NOT EXISTS person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age INT,
    email VARCHAR(255)
);

-- Insert sample data into the person table
INSERT INTO person (name, age, email) VALUES
    ('John Doe', 25, 'john.doe@example.com'),
    ('Jane Smith', 30, 'jane.smith@example.com'),
    ('Michael Johnson', 45, 'michael.johnson@example.com'),
    ('Emily Davis', 28, 'emily.davis@example.com'),
    ('Robert Brown', 33, 'robert.brown@example.com'),
    ('Jennifer Wilson', 41, 'jennifer.wilson@example.com'),
    ('William Taylor', 22, 'william.taylor@example.com'),
    ('Jessica Anderson', 35, 'jessica.anderson@example.com'),
    ('David Martinez', 27, 'david.martinez@example.com'),
    ('Sarah Thompson', 29, 'sarah.thompson@example.com'),
    ('Daniel Garcia', 38, 'daniel.garcia@example.com'),
    ('Olivia Robinson', 31, 'olivia.robinson@example.com'),
    ('Matthew Clark', 36, 'matthew.clark@example.com'),
    ('Sophia Lewis', 24, 'sophia.lewis@example.com'),
    ('Andrew Lee', 32, 'andrew.lee@example.com');
