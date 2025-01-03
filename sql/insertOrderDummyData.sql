DELIMITER $$
CREATE PROCEDURE insert_order_dummy_data()
BEGIN
  START TRANSACTION;

  INSERT INTO orders_table (user_id, order_date, total_price, order_state)
  VALUES (1, CURRENT_DATE, 5000, 'pending_payment'),
         (1, CURRENT_DATE, 5000, 'pending_payment'),
         (2, CURRENT_DATE, 5000, 'pending_payment'),
         (3, CURRENT_DATE, 5000, 'pending_payment'),
         (4, CURRENT_DATE, 5000, 'pending_payment'),
         (5, CURRENT_DATE, 5000, 'pending_payment'),
         (5, CURRENT_DATE, 5000, 'pending_payment'),
         (5, CURRENT_DATE, 5000, 'pending_payment'),
         (6, CURRENT_DATE, 5000, 'pending_payment'),
         (7, CURRENT_DATE, 5000, 'pending_payment');

  COMMIT;
END $$
DELIMITER ;

CALL insert_order_dummy_data();
