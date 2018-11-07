package com.ztessc.produce.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztessc.base.entity.QueryTree;
import com.ztessc.base.entity.Tree;
import com.ztessc.base.entity.User;
import com.ztessc.produce.common.base.dao.GenericDao;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.sys.dao.RoleAssociateTreeDao;
import com.ztessc.produce.sys.dao.TreeDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: TreeService.java
 * @Package com.ztessc.produce.sys.service
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */

@Service("treeService")
@Transactional(rollbackFor = { IllegalArgumentException.class })
public class TreeService extends GenericService<Tree, QueryTree> {
	@Autowired
	private TreeDao treeDao;
	@Autowired
	private RoleAssociateTreeDao roleAssociateTreeDao;

	@Override
	protected GenericDao<Tree, QueryTree> getDao() {
		return treeDao;
	}

	/**
	 * 功能描述：删除菜单的数据
	 * 
	 * @param entity
	 *            删除对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean delete(Tree entity) throws Exception {
		roleAssociateTreeDao.removeTreeByTreeId(entity);
		return super.delete(entity);
	}

	/**
	 * 功能描述：加载用户的菜单树的数据
	 * 
	 * @param user
	 * @return
	 */
	public List<Tree> loadUserTree(User user) {
		return treeDao.loadUserTree(user);
	}
}