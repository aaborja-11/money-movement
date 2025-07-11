CREATE TABLE mm.items (
    id UUID PRIMARY KEY,
    business_id UUID NOT NULL,
    CONSTRAINT fk_business
        FOREIGN KEY (business_id)
        REFERENCES business(id)
        ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    unit_measurement VARCHAR(25) NOT NULL,
    cost_price DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    selling_price DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    active BOOLEAN NOT NULL DEFAULT FALSE,
    type VARCHAR(50) NOT NULL,
    created_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    created_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    updated_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version BIGINT NOT NULL DEFAULT 0
);
