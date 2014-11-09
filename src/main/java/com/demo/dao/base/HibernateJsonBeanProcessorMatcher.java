package com.demo.dao.base;

import java.util.Set;

import net.sf.json.processors.JsonBeanProcessorMatcher;

import org.hibernate.proxy.HibernateProxy;

/**
 * 过滤Hibernate延迟加载对象
 * 
 * @author 
 * 
 */
public class HibernateJsonBeanProcessorMatcher extends JsonBeanProcessorMatcher {
    public Object getMatch(Class target, Set set) {
        String name = target.getName();
        if (name.contains("_$$_javassist_")) {
            return HibernateProxy.class;
        }
        return DEFAULT.getMatch(target, set);
    }
}
