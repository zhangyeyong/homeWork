package com.ztessc.produce.sys.dao;

import com.ztessc.base.entity.QueryUserRole;
import com.ztessc.base.entity.UserRole;
import com.ztessc.produce.common.base.dao.GenericDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserRoleDao.java
 * @Package com.ztessc.produce.sys.dao
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public interface UserRoleDao extends GenericDao<UserRole, QueryUserRole> {

	/**
	 * 功能描述：获取权限菜单数据
	 * 
	 * @param entity
	 * @return
	 */
	UserRole getUserRoleAssociate(UserRole entity);

}