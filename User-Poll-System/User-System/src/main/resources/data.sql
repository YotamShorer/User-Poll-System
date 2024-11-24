CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    age INT DEFAULT 0 NOT NULL,
    address VARCHAR(255),
    joining_date DATE DEFAULT CURRENT_DATE NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (first_name, last_name, email, age, address, joining_date)
VALUES
('Alice', 'Johnson', 'alice.johnson@example.com', 28, '123 Oak Lane', '2024-10-01'),
('Bob', 'Williams', 'bob.williams@example.com', 35, '456 Pine Street', '2024-09-15'),
('Charlie', 'Brown', 'charlie.brown@example.com', 22, '789 Maple Avenue', '2024-08-20'),
('Diana', 'Garcia', 'diana.garcia@example.com', 31, '321 Birch Blvd', '2024-07-10'),
('Ethan', 'Martinez', 'ethan.martinez@example.com', 29, '654 Spruce Court', '2024-06-05'),
('Fiona', 'Davis', 'fiona.davis@example.com', 24, '987 Cedar Road', '2024-05-25'),
('George', 'Miller', 'george.miller@example.com', 27, '159 Willow Lane', '2024-04-18'),
('Hannah', 'Moore', 'hannah.moore@example.com', 32, '753 Elm Drive', '2024-03-30'),
('Isaac', 'Taylor', 'isaac.taylor@example.com', 26, '852 Cherry Circle', '2024-02-14'),
('Julia', 'Anderson', 'julia.anderson@example.com', 30, '951 Poplar Terrace', '2024-01-05');
