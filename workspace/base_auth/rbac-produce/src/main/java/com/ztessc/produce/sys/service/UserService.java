package com.ztessc.produce.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztessc.base.common.Page;
import com.ztessc.base.entity.QueryUser;
import com.ztessc.base.entity.User;
import com.ztessc.base.entity.UserAssociateRole;
import com.ztessc.base.entity.UserRole;
import com.ztessc.produce.common.base.dao.GenericDao;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.common.util.user.UserInfo;
import com.ztessc.produce.sys.dao.UserAssociateRoleDao;
import com.ztessc.produce.sys.dao.UserDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserService.java
 * @Package com.ztessc.produce.sys.service
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@Service("userService")
@Transactional(rollbackFor = { IllegalArgumentException.class })
public class UserService extends GenericService<User, QueryUser> {
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserAssociateRoleDao userAssociateRoleDao;

	@Override
	protected GenericDao<User, QueryUser> getDao() {
		return userDao;
	}

	/**
	 * 分页查询组织架构底下的用户
	 * 
	 * @param queryUser
	 *            查询条件
	 */
	public Page findByGroupUserPage(QueryUser queryUser) {
		List<User> list = userDao.findGroupUserByPage(queryUser);
		int count = userDao.countGroupUser(queryUser);
		return new Page(list, count);
	}

	/**
	 * 功能描述：实现增加用户
	 * 
	 * @param entity
	 *            保存对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(User entity) throws Exception {
		entity.setAddress(entity.getProvince() + entity.getCity() + entity.getDistrict() + entity.getStreetAddress());
		entity.setPassword(UserInfo.encode(entity.getPassword(), "hyll"));
		entity.setState("1");
		entity.packagingRoles(entity.getRoleArray());
		List<UserRole> userRoleList = entity.getRoles();
		boolean success = userDao.save(entity) > 0;
		if (success) {
			if (userRoleList.size() > 0) {
				for (UserRole userRole : userRoleList) {
					userAssociateRoleDao.save(new UserAssociateRole(entity.getId(), userRole.getId()));
				}
			}
		}
		return success;
	}

	/**
	 * 功能描述：实现更新用户
	 * 
	 * @param entity
	 *            修改对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(User entity) throws Exception {
		entity.packagingRoles(entity.getRoleArray());
		entity.setAddress(entity.getProvince() + entity.getCity() + entity.getDistrict() + entity.getStreetAddress());
		userAssociateRoleDao.removeUserRole(entity);
		if (entity.getRoles().size() > 0) {
			for (UserRole userRole : entity.getRoles()) {
				userAssociateRoleDao.save(new UserAssociateRole(entity.getId(), userRole.getId()));
			}
		}
		return super.update(entity);
	}

	/**
	 * 功能描述：批量删除用户
	 * 
	 * @param entityList
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean removeBath(List<User> entityList) throws Exception {
		for (User user : entityList) {
			userAssociateRoleDao.removeUserRole(user);
		}
		return super.removeBath(entityList);
	}

	/**
	 * 功能描述：更新用户状态为可用或者不可用
	 * 
	 * @param user
	 * @return
	 */
	public boolean userControl(User user) {
		return userDao.userControl(user) > 0;
	}

	/**
	 * 功能描述：根据账号来获取用户信息
	 * 
	 * @param login
	 * @return
	 */
	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

}