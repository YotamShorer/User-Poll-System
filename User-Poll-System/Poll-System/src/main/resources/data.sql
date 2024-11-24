CREATE TABLE question (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    first_answer VARCHAR(255) NOT NULL,
    second_answer VARCHAR(255) NOT NULL,
    third_answer VARCHAR(255) NOT NULL,
    fourth_answer VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO question (title, first_answer, second_answer, third_answer, fourth_answer)
VALUES
('What is the capital of France?', 'Paris', 'Berlin', 'Rome', 'Madrid'),
('Which planet is known as the Red Planet?', 'Earth', 'Venus', 'Mars', 'Jupiter'),
('What is the largest ocean on Earth?', 'Atlantic', 'Indian', 'Arctic', 'Pacific'),
('Which programming language is known as the language of the web?', 'Python', 'JavaScript', 'C++', 'Ruby'),
('Who wrote the play "Romeo and Juliet"?', 'Shakespeare', 'Hemingway', 'Austen', 'Dickens'),
('What is the smallest unit of life?', 'Cell', 'Atom', 'Molecule', 'Organ'),
('What is the chemical symbol for water?', 'H2O', 'CO2', 'O2', 'NaCl'),
('Which continent is known as the birthplace of humanity?', 'Africa', 'Asia', 'Europe', 'South America'),
('What is the hardest natural substance on Earth?', 'Diamond', 'Gold', 'Iron', 'Granite'),
('Who painted the Mona Lisa?', 'Da Vinci', 'Van Gogh', 'Picasso', 'Michelangelo');

CREATE TABLE answer(
id int NOT NULL AUTO_INCREMENT,
answer_number int NOT NULL,
question_id int NOT NULL,
user_id int NOT NULL,
PRIMARY KEY (id)
);