DELIMITER $$
CREATE PROCEDURE insert_order_product_dummy_data()
BEGIN
  START TRANSACTION;

  INSERT INTO order_products (user_id, product_id, cart_id, order_id)
    VALUES (1, 1, 11, 1),
           (1, 1, 12, 2),
           (1, 2, 12, 2),
           (2, 1, 13, 3),
           (3, 1, 14, 4),
           (4, 1, 15, 5),
           (5, 1, 16, 6),
           (5, 1, 17, 7),
           (5, 2, 17, 7),
           (5, 1, 18, 8),
           (5, 2, 18, 8),
           (5, 3, 18, 8),
           (6, 1, 19, 9),
           (7, 1, 20, 10);

  COMMIT;
END $$
DELIMITER ;

CALL insert_order_product_dummy_data();

##DELETE FROM order_products;