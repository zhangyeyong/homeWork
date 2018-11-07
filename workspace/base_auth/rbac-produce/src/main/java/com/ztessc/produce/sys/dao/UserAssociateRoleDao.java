package com.ztessc.produce.sys.dao;

import com.ztessc.base.entity.QueryUserAssociateRole;
import com.ztessc.base.entity.User;
import com.ztessc.base.entity.UserAssociateRole;
import com.ztessc.produce.common.base.dao.GenericDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserAssociateRoleDao.java
 * @Package com.ztessc.produce.sys.dao
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public interface UserAssociateRoleDao extends GenericDao<UserAssociateRole, QueryUserAssociateRole> {

	/**
	 * 功能描述：根据用户的ID来删除用户的权限数据
	 * 
	 * @param user
	 * @return
	 */
	int removeUserRole(User user);
}