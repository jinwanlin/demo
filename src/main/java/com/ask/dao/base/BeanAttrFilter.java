package com.ask.dao.base;

import java.util.Date;


import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

/**
 * TODO class purpose description
 * 
 * @author 
 * 
 */
public class BeanAttrFilter {

    /**
     * 去掉不需要过滤的数据
     * 
     * @param attributes
     * @return
     */
    public static JsonConfig getConfig(String[] attributes, String datePattern) {
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor(datePattern));
        config.registerJsonBeanProcessor(org.hibernate.proxy.HibernateProxy.class, new HibernateJsonBeanProcessor());
        config.setJsonBeanProcessorMatcher(new HibernateJsonBeanProcessorMatcher());
        if (attributes != null && attributes.length > 0) {
            config.setExcludes(attributes);
        }
        return config;
    }
}
