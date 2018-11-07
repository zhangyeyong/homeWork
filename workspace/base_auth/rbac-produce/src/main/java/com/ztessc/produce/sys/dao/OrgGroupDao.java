package com.ztessc.produce.sys.dao;

import com.ztessc.base.entity.OrgGroup;
import com.ztessc.base.entity.QueryOrgGroup;
import com.ztessc.produce.common.base.dao.GenericDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: OrgGroupDao.java
 * @Package com.ztessc.produce.sys.dao
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public interface OrgGroupDao extends GenericDao<OrgGroup, QueryOrgGroup> {

	/**
	 * 功能描述：根据父节点来查询最大的节点的值
	 * 
	 * @param parentNode
	 * @return
	 */
	String getMaxOrgGroup(String parentNode);

	/**
	 * 功能描述：根据菜单节点NODE来查询节点数据
	 * 
	 * @param node
	 * @return
	 */
	OrgGroup findByNode(String node);
}