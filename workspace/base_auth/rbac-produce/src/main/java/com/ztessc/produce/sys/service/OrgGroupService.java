package com.ztessc.produce.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztessc.base.entity.OrgGroup;
import com.ztessc.base.entity.QueryOrgGroup;
import com.ztessc.produce.common.base.dao.GenericDao;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.sys.dao.OrgGroupDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: OrgGroupService.java
 * @Package com.ztessc.produce.sys.service
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@Service("orgGroupService")
@Transactional(rollbackFor = { IllegalArgumentException.class })
public class OrgGroupService extends GenericService<OrgGroup, QueryOrgGroup> {
	@Autowired
	private OrgGroupDao orgGroupDao;

	@Override
	protected GenericDao<OrgGroup, QueryOrgGroup> getDao() {
		return orgGroupDao;
	}

	/**
	 * 功能描述：根据父节点来查询最大的节点的值
	 * 
	 * @param parentNode
	 * @return
	 */
	public String getMaxOrgGroup(String parentNode) {
		return orgGroupDao.getMaxOrgGroup(parentNode);
	}

	/**
	 * 功能描述：根据菜单节点NODE来查询节点数据
	 * 
	 * @param node
	 * @return
	 */
	public OrgGroup findByNode(String node) {
		return orgGroupDao.findByNode(node);
	}
}