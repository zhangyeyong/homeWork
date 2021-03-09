package com.ztessc.produce.common.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ztessc.produce.*.dao")
public class MyBatisConfig {

}
