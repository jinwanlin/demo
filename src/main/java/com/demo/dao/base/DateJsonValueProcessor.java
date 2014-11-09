package com.demo.dao.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * JSON日期解析器
 * 
 * @author 
 * 
 */
public class DateJsonValueProcessor implements JsonValueProcessor {

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private DateFormat dateFormat;

    public DateJsonValueProcessor() {
        dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
    }

    /**
     * 构造方法.
     * 
     * @param datePattern
     *            日期格式
     */
    public DateJsonValueProcessor(String datePattern) {
        try {
            if (datePattern != null) {
                dateFormat = new SimpleDateFormat(datePattern);
            } else {
                dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
            }
        } catch (Exception ex) {
            dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        }
    }

    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        if (value != null) {
            return process(value);
        }
        return null;
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        if (value != null) {
            return process(value);
        }
        return null;
    }

    private Object process(Object value) {
        if (value != null) {
            return dateFormat.format((Date) value);
        }
        return null;
    }
}
