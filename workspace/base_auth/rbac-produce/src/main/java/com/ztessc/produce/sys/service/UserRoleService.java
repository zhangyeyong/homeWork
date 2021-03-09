package com.ztessc.produce.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztessc.base.entity.QueryUserRole;
import com.ztessc.base.entity.RoleAssociateTree;
import com.ztessc.base.entity.Tree;
import com.ztessc.base.entity.UserRole;
import com.ztessc.produce.common.base.dao.GenericDao;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.sys.dao.RoleAssociateTreeDao;
import com.ztessc.produce.sys.dao.UserRoleDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserRoleService.java
 * @Package com.ztessc.produce.sys.service
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@Service("userRoleService")
@Transactional(rollbackFor = { IllegalArgumentException.class })
public class UserRoleService extends GenericService<UserRole, QueryUserRole> {
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RoleAssociateTreeDao roleAssociateTreeDao;

	@Override
	protected GenericDao<UserRole, QueryUserRole> getDao() {
		return userRoleDao;
	}

	/**
	 * 功能描述：获取权限菜单数据
	 * 
	 * @param entity
	 * @return
	 */
	public UserRole getUserRoleAssociate(UserRole entity) {
		return userRoleDao.getUserRoleAssociate(entity);
	}

	/**
	 * 功能描述：删除角色数据
	 * 
	 * @param entityList
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean removeBath(List<UserRole> entityList) throws Exception {
		for (UserRole userRole : entityList) {
			roleAssociateTreeDao.removeTreeByRoleId(userRole);
		}
		return super.removeBath(entityList);
	}

	/**
	 * 增加角色数据
	 * 
	 * @param entity
	 *            保存对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(UserRole entity) throws Exception {
		entity.packagingTrees(entity.getTreeArray());
		List<Tree> treeList = entity.getTreeList();
		boolean success = super.save(entity);
		for (Tree tree : treeList) {
			roleAssociateTreeDao.save(new RoleAssociateTree(entity.getId(), tree.getId()));
		}
		return success;
	}

	@Override
	public boolean update(UserRole entity) throws Exception {
		entity.packagingTrees(entity.getTreeArray());
		List<Tree> treeList = entity.getTreeList();
		roleAssociateTreeDao.removeTreeByRoleId(entity);
		for (Tree tree : treeList) {
			roleAssociateTreeDao.save(new RoleAssociateTree(entity.getId(), tree.getId()));
		}
		return super.update(entity);
	}
}