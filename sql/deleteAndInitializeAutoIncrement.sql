DELETE FROM order_products;
DELETE FROM carts_table;
DELETE FROM orders_table;
DELETE FROM products_table;
DELETE FROM users_table;

ALTER TABLE order_products AUTO_INCREMENT = 1;
ALTER TABLE carts_table AUTO_INCREMENT = 1;
ALTER TABLE orders_table AUTO_INCREMENT = 1;
ALTER TABLE products_table AUTO_INCREMENT = 1;
ALTER TABLE users_table AUTO_INCREMENT = 1;