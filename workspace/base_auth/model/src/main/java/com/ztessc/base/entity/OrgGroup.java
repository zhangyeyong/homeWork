package com.ztessc.base.entity;


/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * @Title:  OrgGroup.java   
 * @Package com.ztessc.base.entity   
 * @Description:  
 * @author: 张业勇     
 * @date:   2018年11月9日   
 * @version V1.0 
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public class OrgGroup {
	private long groupId;
	private long existingNum;
	private String groupCode;
	private String name;
	private String node;
	private long num;
	private String parentNode;
	// 父部门信息
	private OrgGroup orgGroup;

	public OrgGroup getOrgGroup() {
		return orgGroup;
	}

	public void setOrgGroup(OrgGroup orgGroup) {
		this.orgGroup = orgGroup;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getExistingNum() {
		return existingNum;
	}

	public void setExistingNum(long existingNum) {
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

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getParentNode() {
		return parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

}
