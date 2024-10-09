
--TABLE TO STORE FIELD/COLUMN CONFIGURATION
CREATE TABLE IF NOT EXISTS fields (
    id UUID PRIMARY KEY,  -- Primary key index is automatically created
    object_id UUID NOT NULL,  -- No foreign key, but could add an index on this column later
    field_name VARCHAR(255) NOT NULL,
    display_name VARCHAR(255),
    source_type VARCHAR(20),
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

CREATE TABLE template (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT
);


CREATE TABLE section (
    id UUID PRIMARY KEY,
    template_id UUID REFERENCES template(id),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    config JSONB,
    section_type VARCHAR(50)
);

