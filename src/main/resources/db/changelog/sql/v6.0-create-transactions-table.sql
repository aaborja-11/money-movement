CREATE TABLE mm.transactions (
    id UUID PRIMARY KEY,
    item_id UUID NOT NULL,
    CONSTRAINT fk_item
        FOREIGN KEY (item_id)
        REFERENCES items(id)
        ON DELETE CASCADE,
    purchased_amount DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    purchased_quantity DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    purchased_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    type VARCHAR(75) NOT NULL,
    created_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    created_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    updated_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
