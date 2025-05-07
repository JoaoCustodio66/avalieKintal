CREATE TABLE feedbacks (
    id SERIAL PRIMARY KEY,
    food_rating DOUBLE PRECISION NOT NULL,
    service_rating DOUBLE PRECISION NOT NULL,
    experience_rating DOUBLE PRECISION NOT NULL,
    comments TEXT,
    customer_name VARCHAR(100) not null,
    table_number INT,
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users(
	id serial PRIMARY KEY,
	name VARCHAR(90) NOT NULL,
	phone VARCHAR(20) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	status boolean DEFAULT TRUE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
