package com.ztessc.base.entity;

import com.ztessc.base.common.QueryBase;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: QueryOrgGroup.java
 * @Package com.ztessc.base.entity
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月9日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public class QueryOrgGroup extends QueryBase {
	private Long existingNum;
	private String groupCode;
	private String name;
	private String node;
	private Long num;
	private String parentNode;

	public Long getExistingNum() {
		return existingNum;
	}

	public void setExistingNum(Long existingNum) {
		this.existingNum = existingNum;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getParentNode() {
		return parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

}
