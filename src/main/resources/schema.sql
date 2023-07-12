DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS producers;
DROP TABLE IF EXISTS customer;

CREATE TABLE producers (
                           id   INT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(255)
);

CREATE TABLE items (
                       id           INT PRIMARY KEY AUTO_INCREMENT,
                       name         VARCHAR(255),
                       producer_id  INT,
                       price        FLOAT,
                       info         VARCHAR(1000),
                       CONSTRAINT fk_producer
                           FOREIGN KEY (producer_id) REFERENCES producers (id)
);

CREATE TABLE customer (
                          id        INT PRIMARY KEY AUTO_INCREMENT,
                          user_name VARCHAR(255),
                          email     VARCHAR(255),
                          password  VARCHAR(255),
                          role      VARCHAR(255)
);

CREATE TABLE orders (
                        id               INT PRIMARY KEY AUTO_INCREMENT,
                        customer_id      INT,
                        order_date       DATE,
                        payment_type     VARCHAR(255),
                        delivery_type    VARCHAR(255),
                        delivery_address VARCHAR(255),
                        comment         VARCHAR(255),
                        status          VARCHAR(255),
                        status_date     DATE,
                        CONSTRAINT fk_customer
                            FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE order_items (
                             id        INT PRIMARY KEY AUTO_INCREMENT,
                             item_id   INT,
                             price     FLOAT,
                             count     INT,
                             order_id  INT,
                             CONSTRAINT fk_item
                                 FOREIGN KEY (item_id) REFERENCES items (id) ,
                             CONSTRAINT fk_order
                                 FOREIGN KEY (order_id) REFERENCES orders (id)
);