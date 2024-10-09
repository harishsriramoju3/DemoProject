--TABLE TO STORE TABLE/OBJECT CONFIGURATION
CREATE TABLE IF NOT EXISTS objects (
    id UUID PRIMARY KEY,  -- Primary key index is automatically created
    object_name VARCHAR(255) NOT NULL,
    display_name VARCHAR(255),
    source_type VARCHAR(20),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_by UUID
);