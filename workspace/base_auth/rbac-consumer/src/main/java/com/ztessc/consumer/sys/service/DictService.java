package com.ztessc.consumer.sys.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ztessc.base.entity.Dict;
import com.ztessc.base.entity.QueryDict;
import com.ztessc.consumer.common.base.service.GenericService;
import com.ztessc.consumer.common.config.FullLogConfiguration;

@FeignClient(value="RBAC-PRODUCE",configuration = FullLogConfiguration.class,path = "/dict")
public interface DictService extends GenericService<Dict,QueryDict> {

    /**
     * 功能描述：将字典数据初始化到前端js中
     * @return
     */
    @RequestMapping(value = "/loadDict",method = RequestMethod.POST)
    Map<String,Object> loadDict();



}
