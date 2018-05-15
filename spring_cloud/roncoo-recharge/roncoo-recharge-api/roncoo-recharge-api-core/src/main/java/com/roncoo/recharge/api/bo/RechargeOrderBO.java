/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.roncoo.recharge.api.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单查询-请求实体
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RechargeOrderBO extends BaseBO {

	private static final long serialVersionUID = 1L;

	private Long tradeNo;

	private Long serialNo;

}
