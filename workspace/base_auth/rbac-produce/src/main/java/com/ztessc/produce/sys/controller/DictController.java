package com.ztessc.produce.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.base.entity.Dict;
import com.ztessc.base.entity.QueryDict;
import com.ztessc.produce.common.base.constant.SystemStaticConst;
import com.ztessc.produce.common.base.controller.GenericController;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.sys.service.DictService;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: DictController.java
 * @Package com.ztessc.produce.sys.controller
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@RestController
@RequestMapping("/dict")
public class DictController extends GenericController<Dict, QueryDict> {

	@Autowired
	private DictService dictService;

	@Override
	protected GenericService getService() {
		return dictService;
	}

	/**
	 * 功能描述：将字典数据初始化到前端js中
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loadDict", method = RequestMethod.POST)
	public Map<String, Object> loadDict() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Dict> dictList = dictService.query(new QueryDict("1"));
		result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
		result.put("data", dictList);
		return result;
	}

}
