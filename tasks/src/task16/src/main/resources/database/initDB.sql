CREATE TABLE IF Not EXISTS author (
    id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL;
    middle_name VARCHAR(255) NOT NULL,
    birth_date VARCHAR(255) NOT NULL
);

CREATE SEQUENCE authors_sequence start 1 increment 1;

CREATE TABLE IF NOT EXISTS book (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    creation_date(255) NOT NULL,
    author_id INTEGER
);

CREATE SEQUENCE books_sequence start 1 increment 1;