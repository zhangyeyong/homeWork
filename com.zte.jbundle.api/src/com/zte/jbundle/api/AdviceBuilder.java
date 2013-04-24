package com.zte.jbundle.api;


/**
 * AOP拦截规则构造器
 * 
 * @author PanJun
 * 
 */
public interface AdviceBuilder {

    /**
     * 搭建切片作用的目标类的名称规则
     * 
     * @return
     */
    public Advice[] advices();

    /**
     * ClassName过滤表达式，*号为匹配全部
     * 
     * @return
     */
    public String ruleExpr();

}
