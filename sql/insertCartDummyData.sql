DELIMITER $$
CREATE PROCEDURE insert_cart_dummy_data()
BEGIN
  START TRANSACTION;

  INSERT INTO carts_table (user_id, quantity, total_price)
  VALUES (1, 1, 5000),
         (1, 2, 5000),
         (2, 1, 5000),
         (3, 1, 5000),
         (4, 1, 5000),
         (5, 1, 5000),
         (5, 2, 5000),
         (5, 3, 5000),
         (6, 1, 5000),
         (7, 1, 5000);

  COMMIT;
END $$
DELIMITER ;

CALL insert_cart_dummy_data();

##DELETE FROM carts_table;