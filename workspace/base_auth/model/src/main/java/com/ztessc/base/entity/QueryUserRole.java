package com.ztessc.base.entity;

import com.ztessc.base.common.QueryBase;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: QueryUserRole.java
 * @Package com.ztessc.base.entity
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月9日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public class QueryUserRole extends QueryBase {
	private String name;
	private String roleName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
