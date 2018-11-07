package com.ztessc.produce.sys.dao;


import com.ztessc.base.entity.QueryRoleAssociateTree;
import com.ztessc.base.entity.RoleAssociateTree;
import com.ztessc.base.entity.Tree;
import com.ztessc.base.entity.UserRole;
import com.ztessc.produce.common.base.dao.GenericDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * @Title:  RoleAssociateTreeDao.java   
 * @Package com.ztessc.produce.sys.dao   
 * @Description:  
 * @author: 张业勇     
 * @date:   2018年11月7日   
 * @version V1.0 
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public interface RoleAssociateTreeDao extends GenericDao<RoleAssociateTree, QueryRoleAssociateTree> {

    /**
     * 功能描述：根据菜单ID来删除关联的菜单数据
     * @param tree
     * @return
     */
    int removeTreeByTreeId(Tree tree);

    /**
     * 功能描述：根据角色ID来删除关联的菜单数据
     * @param userRole
     * @return
     */
    int removeTreeByRoleId(UserRole userRole);
	
}