CREATE TABLE `users_table`
(
  `user_id`   INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username`  VARCHAR(50)              NOT NULL,
  `nickname`  VARCHAR(50)              NOT NULL,
  `password`  VARCHAR(255)             NOT NULL,
  `user_type` ENUM ('user', 'admin')   NOT NULL DEFAULT 'user',
  `points`    INT UNSIGNED             NOT NULL DEFAULT 0
);

CREATE TABLE `products_table`
(
  `product_id`   INT UNSIGNED PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(255)              NOT NULL,
  `price`        INT UNSIGNED              NOT NULL,
  `description`  VARCHAR(255)              NULL,
  `image`        BLOB                      NULL,
  `product_type` ENUM ('product', 'point') NOT NULL
);

CREATE TABLE `carts_table`
(
  `cart_id`     INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `user_id`     INT UNSIGNED             NOT NULL,
  `quantity`    INT UNSIGNED             NOT NULL DEFAULT 0,
  `total_price` INT UNSIGNED             NOT NULL DEFAULT 0
);

CREATE TABLE `orders_table`
(
  `order_id`    INT UNSIGNED PRIMARY KEY                          NOT NULL AUTO_INCREMENT,
  `user_id`     INT UNSIGNED                                      NOT NULL,
  `product_id`  INT UNSIGNED                                      NOT NULL,
  `order_date`  DATE                                              NOT NULL,
  `total_price` INT UNSIGNED                                      NOT NULL,
  `order_state` ENUM ('pending_payment', 'shipping', 'completed') NOT NULL DEFAULT 'pending_payment'
);

CREATE TABLE `order_products`
(
  `user_id`    INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `cart_id`    INT UNSIGNED NOT NULL
);

ALTER TABLE `carts_table`
  ADD CONSTRAINT `FK_users_table_TO_carts_table_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`);

ALTER TABLE `orders_table`
  ADD CONSTRAINT `FK_users_table_TO_orders_table_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`);

ALTER TABLE `orders_table`
  ADD CONSTRAINT `FK_products_table_TO_orders_table_1` FOREIGN KEY (`product_id`) REFERENCES `products_table` (`product_id`);

ALTER TABLE `order_products`
  ADD CONSTRAINT `FK_users_table_TO_order_products_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`);

ALTER TABLE `order_products`
  ADD CONSTRAINT `FK_products_table_TO_order_products_1` FOREIGN KEY (`product_id`) REFERENCES `products_table` (`product_id`);

ALTER TABLE `order_products`
  ADD CONSTRAINT `FK_carts_table_TO_order_products_1` FOREIGN KEY (`cart_id`) REFERENCES `carts_table` (`cart_id`);

