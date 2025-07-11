CREATE TABLE mm.inventory (
    id UUID PRIMARY KEY,
    item_id UUID NOT NULL,
    CONSTRAINT fk_item
        FOREIGN KEY (item_id)
        REFERENCES items(id)
        ON DELETE CASCADE,
    opening_stock DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    remaining_stock DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    opening_timestamp TIMESTAMP,
    closing_timestamp TIMESTAMP,
    created_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    created_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    updated_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
