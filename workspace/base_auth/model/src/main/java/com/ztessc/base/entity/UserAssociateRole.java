package com.ztessc.base.entity;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserAssociateRole.java
 * @Package com.ztessc.base.entity
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月9日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public class UserAssociateRole {
	private int userId;
	private long roleId;

	public UserAssociateRole() {
		super();
	}

	public UserAssociateRole(int userId, long roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
