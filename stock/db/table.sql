drop table lday;
CREATE TABLE `lday` (
  `code` int(11) NOT NULL COMMENT '代码',
  `tr_date` int(11) NOT NULL COMMENT '日期，用整型如20200823',
  `open` decimal(30,2) DEFAULT NULL COMMENT '开盘价',
  `close` decimal(30,2) DEFAULT NULL COMMENT '收盘价',
  `high` decimal(30,2) DEFAULT NULL COMMENT '最高价',
  `low` decimal(30,2) DEFAULT NULL COMMENT '最低价',
  `volume` decimal(30,2) DEFAULT NULL COMMENT '成交量',
  `amt` decimal(30,2) DEFAULT NULL COMMENT '成交额',
  PRIMARY KEY (`code`,`tr_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `stock`.`lday` 
ADD COLUMN `index` int(255) NULL COMMENT '序号' AFTER ` amt`;

ALTER TABLE `stock`.`lday` 
ADD COLUMN `rate` decimal(30, 4) NULL COMMENT '涨幅' AFTER `amt`;