CREATE TABLE mm.sales (
    id UUID PRIMARY KEY,
    item_id UUID NOT NULL,
    CONSTRAINT fk_item
        FOREIGN KEY (item_id)
        REFERENCES items(id)
        ON DELETE CASCADE,
    income DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    expense DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    loss DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    profit DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    opening_timestamp TIMESTAMP,
    closing_timestamp TIMESTAMP,
    created_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    created_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) NOT NULL DEFAULT 'mm',
    updated_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version BIGINT NOT NULL DEFAULT 0
);
