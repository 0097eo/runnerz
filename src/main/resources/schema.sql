CREATE TABLE IF NOT EXISTS Run (
    id SERIAL PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(50) NOT NULL
);