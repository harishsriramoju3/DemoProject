-- Create tables
CREATE TABLE IF NOT EXISTS users (
    uid VARCHAR(36) NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--TABLE TO STORE TABLE/OBJECT CONFIGURATION
CREATE TABLE IF NOT EXISTS objects (
    id UUID PRIMARY KEY,  -- Primary key index is automatically created
    object_name VARCHAR(255) NOT NULL,
    display_name VARCHAR(255),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_by UUID
);

--TABLE TO STORE FIELD/COLUMN CONFIGURATION
CREATE TABLE IF NOT EXISTS fields (
    id UUID PRIMARY KEY,  -- Primary key index is automatically created
    object_id UUID NOT NULL,  -- No foreign key, but could add an index on this column later
    field_name VARCHAR(255) NOT NULL,
    display_name VARCHAR(255),
    description TEXT,
    field_type VARCHAR(50) NOT NULL,
    default_value VARCHAR(255),
    required BOOLEAN DEFAULT FALSE,
    length INT,
    scale INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_by UUID
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

