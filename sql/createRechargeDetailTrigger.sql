DELIMITER //

CREATE TRIGGER insert_detail_after_recharge_insert
  AFTER INSERT ON point_recharge_table
  FOR EACH ROW
BEGIN
  INSERT INTO point_recharge_detail_table (recharge_id, user_id, bank, account_number, deposit_confirmed_time)
  VALUES (NEW.recharge_id, NEW.user_id, '', '', NULL);
END //

DELIMITER ;