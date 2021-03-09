package com.ztessc.produce.common.util.user;


import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.codec.Hex;

import com.ztessc.base.entity.Tree;
import com.ztessc.base.entity.User;
import com.ztessc.produce.common.util.node.NodeUtil;
import com.ztessc.produce.sys.service.TreeService;
/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * @Title:  UserInfo.java   
 * @Package com.ztessc.produce.common.util.user   
 * @Description:  
 * @author: 张业勇     
 * @date:   2018年11月7日   
 * @version V1.0 
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
public class UserInfo {


    /**
     * 功能描述：实现对密码进行加盐值得MD5加密
     * @param password
     * @return
     */
    public static String encode(String password,String salt){
        password = password + "{"+salt +"}";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(password.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 功能描述：加载菜单节点的数据
     * @return
     */
    public static List<Tree> loadUserTree(TreeService treeService, User user){
        Map<Long,Tree> treeMap = new HashMap<Long,Tree>();
        for(Tree tree:treeService.loadUserTree(user)){
            treeMap.put(tree.getId(),tree);
        }
        List<Tree> treeList = NodeUtil.getChildNodes(new ArrayList<Tree>(treeMap.values()),0l);
        return treeList;
    }



}
