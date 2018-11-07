package com.ztessc.produce.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztessc.base.entity.Dict;
import com.ztessc.base.entity.QueryDict;
import com.ztessc.produce.common.base.dao.GenericDao;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.sys.dao.DictDao;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: DictService.java
 * @Package com.ztessc.produce.sys.service
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@Service("dictService")
@Transactional(rollbackFor = { IllegalArgumentException.class })
public class DictService extends GenericService<Dict, QueryDict> {
	@Autowired
	private DictDao dictDao;

	@Override
	protected GenericDao<Dict, QueryDict> getDao() {
		return dictDao;
	}
}