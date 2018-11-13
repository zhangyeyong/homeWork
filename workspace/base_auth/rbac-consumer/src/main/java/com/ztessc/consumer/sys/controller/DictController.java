package com.ztessc.consumer.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.base.entity.Dict;
import com.ztessc.base.entity.QueryDict;
import com.ztessc.consumer.common.base.controller.GenericController;
import com.ztessc.consumer.common.base.service.GenericService;
import com.ztessc.consumer.sys.service.DictService;


@RestController
@RequestMapping("/dict")
public class DictController  extends GenericController<Dict,QueryDict> {

    @Autowired
    private DictService dictService;

    @Override
    protected GenericService<Dict, QueryDict> getService() {
        return dictService;
    }

    /**
     * 功能描述：将字典数据初始化到前端js中
     * @return
     */
    @RequestMapping(value = "/loadDict",method = RequestMethod.POST)
    public Map<String,Object> loadDict(){
        return dictService.loadDict();
    }
}
