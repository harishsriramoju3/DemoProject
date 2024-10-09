-- Create tables
CREATE TABLE IF NOT EXISTS users (
    uid VARCHAR(36) NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE IF NOT EXISTS template (
    id UUID PRIMARY KEY,  -- Primary key index is automatically created
    title VARCHAR(255) NOT NULL,
    description TEXT
);


CREATE table IF NOT EXISTS section_config (
    id UUID PRIMARY KEY,  -- Primary key index is automatically created
    template_id UUID NOT NULL,  -- Reference to template (but no foreign key)
    title VARCHAR(255) NOT NULL,
    description TEXT,
    config JSONB
);