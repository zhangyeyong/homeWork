package com.ztessc.base.entity;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: RoleAssociateTree.java
 * @Package com.ztessc.base.entity
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月9日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public class RoleAssociateTree {

	public RoleAssociateTree() {
		super();
	}

	public RoleAssociateTree(long roleId, long treeId) {
		this.roleId = roleId;
		this.treeId = treeId;
	}

	private long roleId;
	private long treeId;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getTreeId() {
		return treeId;
	}

	public void setTreeId(long treeId) {
		this.treeId = treeId;
	}

}
