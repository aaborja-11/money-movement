CREATE TABLE mm.accounts (
    id UUID PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    created_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
