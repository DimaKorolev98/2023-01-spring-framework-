DROP TABLE IF EXISTS comments;
CREATE TABLE comments (
                          id      SERIAL PRIMARY KEY,
                          text    VARCHAR(1000),
                          book_id BIGINT
);

DROP TABLE IF EXISTS genres;
CREATE TABLE genres (
                        id   SERIAL PRIMARY KEY,
                        name VARCHAR(255) UNIQUE
);

DROP TABLE IF EXISTS authors;
CREATE TABLE authors (
                         id   SERIAL PRIMARY KEY,
                         name VARCHAR(255) UNIQUE
);

DROP TABLE IF EXISTS books;
CREATE TABLE books (
                       id         BIGINT PRIMARY KEY,
                       title      VARCHAR(255),
                       genre_id   BIGINT,
                       author_id  BIGINT
);

CREATE TABLE users (
                       id        BIGINT PRIMARY KEY,
                       user_name VARCHAR(255) NOT NULL,
                       email     VARCHAR(255),
                       password  VARCHAR(255) NOT NULL,
                       role      VARCHAR(255)
);

ALTER TABLE books ADD CONSTRAINT fk_bookGenre FOREIGN KEY (genre_id) REFERENCES genres (id);
ALTER TABLE books ADD CONSTRAINT fk_bookAuthor FOREIGN KEY (author_id) REFERENCES authors (id);
ALTER TABLE comments ADD CONSTRAINT fk_commentBook FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE;
