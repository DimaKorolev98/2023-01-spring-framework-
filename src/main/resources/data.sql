insert into Authors (id, name)
values (1, 'Эрих Мария Ремарк');
insert into Authors (id, name)
values (2, 'Джон Р. Р. Толкин');
insert into Authors (id, name)
values (3, 'Роберт Мартин');
insert into Authors (id, name)
values (4, 'Александр Сергеевич Пушкин');
insert into Authors (id, name)
values (5, 'Лев Николаевич Толстой');
insert into Authors (id, name)
values (0, 'Михаил Афанасьевич Булгаков');

insert into Genres (id, name)
values (1, 'Роман');
insert into Genres (id, name)
values (2, 'Фантастика');
insert into Genres (id, name)
values (3, 'Поэма');
insert into Genres (id, name)
values (4, 'Компьютерные науки');

insert into Books (id, author_id, title, genre_id)
values (1, 1, 'Три товарища', 1);
insert into Books (id, author_id, title, genre_id)
values (2, 2, 'Властелин колец', 2);
insert into Books (id, author_id, title, genre_id)
values (3, 4, 'Руслан и Людмила', 3);
insert into Books (id, author_id, title, genre_id)
values (4, 3, 'Чистый код', 4);

insert into comments (id,text,book_id) values(1,'Хорошая книга',1);
insert into comments (id,text,book_id) values(2,'Очень понравилось',1);
insert into comments (id,text,book_id) values(3,'Можно и лучше',4);


INSERT INTO users(user_name, email, password, role)
VALUES ('user', 'user@mail.ru', '$2a$12$X8P20S1rPnxHzFvdm1xsw.0FbfBMno1LoSYh/0U4/a8QEQ6uy5F2C', 'ROLE_USER'),
       ('admin', 'admin@mail.ru', '$2a$12$GdPiy5ySkXbfL07lDlGV.uWOtXNooKqvWKCsQCpt4Y8I9.1m5FaIi', 'ROLE_ADMIN');
-- user, Пароль: superpas;
-- admin, Пароль: adminpas;