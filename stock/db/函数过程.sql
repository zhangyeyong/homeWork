CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_update_rownum`()
BEGIN
	-- 定义需要接收游标数据的变量
	DECLARE v_code varchar(11);
	DECLARE v_tmp_code varchar(11) DEFAULT '000000';
	DECLARE v_tr_date int(11);
	DECLARE v_index int(11) DEFAULT 0;
	-- 定义遍历数据结束标志
	DECLARE done BOOLEAN DEFAULT 0;
	
	-- 定义游标
	DECLARE cur CURSOR FOR SELECT
		code,tr_date
	FROM lday order by code,tr_date asc;
	-- 将结束标志绑定到游标
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1;
	-- 打开游标
	OPEN cur;
		-- 关闭事务自动提交
		SET autocommit=0;
		-- 开始循环
		read_loop:LOOP
			-- 提取游标中的数据
			FETCH cur INTO v_code,v_tr_date;
			-- 声明何时结束循环
			IF done THEN
				LEAVE read_loop;
			END IF;
			IF v_tmp_code<>v_code THEN
				set v_tmp_code = v_code;
				set v_index = 0;
			END IF;
			-- 循环时的事件
			set v_index = v_index+1;
			update lday t set t.index = v_index where t.code=v_code and t.tr_date=v_tr_date;			
		END LOOP;
		commit;
		-- 关闭游标
	CLOSE cur;
END;

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_rate`()
BEGIN
	-- 定义需要接收游标数据的变量
	DECLARE v_code varchar(11);
	DECLARE v_index int(11);
	DECLARE v_rate decimal(30,2);
	-- 定义遍历数据结束标志
	DECLARE done BOOLEAN DEFAULT 0;
	
	-- 定义游标
	DECLARE cur CURSOR FOR select d1.code,d1.`index` , convert(100*(d1.`close`-d2.`close`)/d2.`close`,decimal(10,2)) as rate from lday d1 left join lday d2 on d1.code=d2.code and d1.`index` = d2.`index`+1;
	-- 将结束标志绑定到游标
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1;
	-- 打开游标
	OPEN cur;
		-- 关闭事务自动提交
		SET autocommit=0;
		-- 开始循环
		read_loop:LOOP
			-- 提取游标中的数据
			FETCH cur INTO v_code,v_index,v_rate;
			-- 声明何时结束循环
			IF done THEN
				LEAVE read_loop;
			END IF;
			
			-- 循环时的事件			
			update lday t set t.rate = v_rate where t.code=v_code and t.`index`=v_index;			
		END LOOP;
		commit;
		-- 关闭游标
	CLOSE cur;

END;
