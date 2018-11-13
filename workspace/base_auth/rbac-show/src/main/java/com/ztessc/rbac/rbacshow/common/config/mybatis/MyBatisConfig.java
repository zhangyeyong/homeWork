package com.ztessc.rbac.rbacshow.common.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@MapperScan({"com.ztessc.rbac.rbacshow.*.dao","com.ztessc.rbac.rbacshow.*.mapper"})
@MapperScan("com.ztessc.rbac.rbacshow.*.dao")
public class MyBatisConfig {

}
