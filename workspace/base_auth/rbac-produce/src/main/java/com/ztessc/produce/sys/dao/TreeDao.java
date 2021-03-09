package com.ztessc.produce.sys.dao;

import java.util.List;

import com.ztessc.base.entity.QueryTree;
import com.ztessc.base.entity.Tree;
import com.ztessc.base.entity.User;
import com.ztessc.produce.common.base.dao.GenericDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: TreeDao.java
 * @Package com.ztessc.produce.sys.dao
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public interface TreeDao extends GenericDao<Tree, QueryTree> {

	/**
	 * 功能描述：加载用户的菜单树的数据
	 * 
	 * @param user
	 * @return
	 */
	List<Tree> loadUserTree(User user);
}