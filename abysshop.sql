CREATE TABLE `users_table`
(
    `user_id`  VARCHAR(255) NOT NULL,
    `username` VARCHAR(30) NULL,
    `nickname` VARCHAR(30) NULL,
    `password` VARCHAR(50) NULL,
    `usertype` ENUM(user, admin) NULL,
    `points`   INT NULL
);

CREATE TABLE `products_table`
(
    `product_id`  VARCHAR(255) NOT NULL,
    `productname` VARCHAR(255) NULL,
    `price`       INT NULL,
    `description` VARCHAR(255) NULL,
    `image`       BLOB NULL,
    `type`        ENUM(product, point) NULL
);

CREATE TABLE `carts_table`
(
    `cart_id`     VARCHAR(255) NOT NULL,
    `quantity`    INT NULL,
    `total_price` INT NULL
);

CREATE TABLE `orders_table`
(
    `order_id`   VARCHAR(255) NOT NULL,
    `user_id`    VARCHAR(255) NOT NULL,
    `date`       DATE NULL,
    `totalPrice` INT NULL,
    `state`      VARCHAR(30) NULL,
    `type`       ENUM(product, point) NULL
);

CREATE TABLE `order_products`
(
    `user_id`    VARCHAR(255) NOT NULL,
    `product_id` VARCHAR(255) NOT NULL,
    `cart_id`    VARCHAR(255) NOT NULL
);

ALTER TABLE `users_table`
    ADD CONSTRAINT `PK_USERS_TABLE` PRIMARY KEY (
                                                 `user_id`
        );

ALTER TABLE `products_table`
    ADD CONSTRAINT `PK_PRODUCTS_TABLE` PRIMARY KEY (
                                                    `product_id`
        );

ALTER TABLE `carts_table`
    ADD CONSTRAINT `PK_CARTS_TABLE` PRIMARY KEY (
                                                 `cart_id`
        );

ALTER TABLE `orders_table`
    ADD CONSTRAINT `PK_ORDERS_TABLE` PRIMARY KEY (
                                                  `order_id`,
                                                  `user_id`
        );

ALTER TABLE `order_products`
    ADD CONSTRAINT `PK_ORDER_PRODUCTS` PRIMARY KEY (
                                                    `user_id`,
                                                    `product_id`,
                                                    `cart_id`
        );

ALTER TABLE `orders_table`
    ADD CONSTRAINT `FK_users_table_TO_orders_table_1` FOREIGN KEY (
                                                                   `user_id`
        )
        REFERENCES `users_table` (
                                  `user_id`
            );

ALTER TABLE `order_products`
    ADD CONSTRAINT `FK_users_table_TO_order_products_1` FOREIGN KEY (
                                                                     `user_id`
        )
        REFERENCES `users_table` (
                                  `user_id`
            );

ALTER TABLE `order_products`
    ADD CONSTRAINT `FK_products_table_TO_order_products_1` FOREIGN KEY (
                                                                        `product_id`
        )
        REFERENCES `products_table` (
                                     `product_id`
            );

ALTER TABLE `order_products`
    ADD CONSTRAINT `FK_carts_table_TO_order_products_1` FOREIGN KEY (
                                                                     `cart_id`
        )
        REFERENCES `carts_table` (
                                  `cart_id`
            );

