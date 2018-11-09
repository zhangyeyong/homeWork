package com.ztessc.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserRole.java
 * @Package com.ztessc.base.entity
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月9日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public class UserRole implements Serializable {

	private static final long serialVersionUID = -7314462528191718525L;

	private long id;
	private String name;
	private String roleName;
	private List<Tree> treeList;
	private String treeArray;

	public List<Tree> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<Tree> treeList) {
		this.treeList = treeList;
	}

	public String getTreeArray() {
		return treeArray;
	}

	public void setTreeArray(String treeArray) {
		this.treeArray = treeArray;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public void packagingTrees(String treeArray) {
		Tree tree = null;
		List<Tree> trees = new ArrayList<>();
		for (String id : treeArray.split(",")) {
			if (!id.isEmpty()) {
				tree = new Tree(Long.parseLong(id));
				trees.add(tree);
			}
		}
		this.setTreeList(trees);
	}
}
