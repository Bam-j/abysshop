CREATE TABLE `users_table`
(
  `user_id`  INT PRIMARY KEY        NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50)            NOT NULL,
  `nickname` VARCHAR(50)            NOT NULL,
  `password` VARCHAR(255)           NOT NULL,
  `usertype` ENUM ('user', 'admin') NOT NULL DEFAULT 'user',
  `points`   INT                    NULL     DEFAULT 0
);

CREATE TABLE `products_table`
(
  `product_id`  INT PRIMARY KEY           NOT NULL AUTO_INCREMENT,
  `productname` VARCHAR(255)              NOT NULL,
  `price`       INT                       NOT NULL,
  `description` VARCHAR(255)              NULL,
  `image`       BLOB                      NULL,
  `type`        ENUM ('product', 'point') NOT NULL
);

CREATE TABLE `carts_table`
(
  `cart_id`     INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `quantity`    INT             NULL,
  `total_price` INT             NULL
);

CREATE TABLE `orders_table`
(
  `order_id`   INT                       NOT NULL,
  `user_id`    INT                       NOT NULL,
  `date`       DATE                      NOT NULL,
  `totalPrice` INT                       NOT NULL,
  `state`      VARCHAR(60)               NOT NULL,
  `type`       ENUM ('product', 'point') NOT NULL
);

CREATE TABLE `order_products`
(
  `user_id`    INT NOT NULL,
  `product_id` INT NOT NULL,
  `cart_id`    INT NOT NULL
);

ALTER TABLE `orders_table`
  ADD CONSTRAINT `PK_ORDERS_TABLE` PRIMARY KEY (`order_id`, `user_id`);

ALTER TABLE `order_products`
  ADD CONSTRAINT `PK_ORDER_PRODUCTS` PRIMARY KEY (`user_id`, `product_id`, `cart_id`);

ALTER TABLE `orders_table`
  ADD CONSTRAINT `FK_users_table_TO_orders_table_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`);

ALTER TABLE `order_products`
  ADD CONSTRAINT `FK_users_table_TO_order_products_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`);

ALTER TABLE `order_products`
  ADD CONSTRAINT `FK_products_table_TO_order_products_1` FOREIGN KEY (`product_id`) REFERENCES `products_table` (`product_id`);

ALTER TABLE `order_products`
  ADD CONSTRAINT `FK_carts_table_TO_order_products_1` FOREIGN KEY (`cart_id`) REFERENCES `carts_table` (`cart_id`);

