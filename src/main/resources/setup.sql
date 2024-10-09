-- setup.sql

-- Create a new database
CREATE DATABASE prepview;

-- Connect to the new database
\c prepview;

-- Create tables
CREATE TABLE users (
    uid UUID NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
