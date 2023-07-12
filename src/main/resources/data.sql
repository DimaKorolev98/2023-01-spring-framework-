insert into engine_shop.producers (id, name)
values (1, 'Boeing');
insert into engine_shop.producers (id, name)
values (2, 'Rolls-Royce');

insert into engine_shop.items (id, name, producer_id, price, info)
values (1, 'Boeing 777', 1, 25000.00, '3000 HP');
insert into engine_shop.items (id, name, producer_id, price, info)
values (2, 'Rolls_Royce_001', 2, 35000.00, '3000 HP');

INSERT INTO customer(id, user_name, email, password, role)
VALUES (1, 'user', 'user@mail.ru', '$2a$12$X8P20S1rPnxHzFvdm1xsw.0FbfBMno1LoSYh/0U4/a8QEQ6uy5F2C', 'ROLE_USER'),
       (2, 'admin', 'admin@mail.ru', '$2a$12$GdPiy5ySkXbfL07lDlGV.uWOtXNooKqvWKCsQCpt4Y8I9.1m5FaIi', 'ROLE_ADMIN');
-- user, Пароль: superpas;
-- admin, Пароль: adminpas;