package com.demo.dao.base;

import java.util.List;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 存放分页查询结果的模型
 */
public class PageResult {

    @SuppressWarnings("rawtypes")
    private List items;

    private int total;

    @SuppressWarnings("rawtypes")
    public PageResult(List items, int total) {
        this.items = items;
        this.total = total;
    }

    @SuppressWarnings("rawtypes")
    public List getItems() {
        return items;
    }

    @SuppressWarnings("rawtypes")
    public void setItems(List items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public JSONObject toJson(String[] attributes) {
        JSONArray array = null;
        // if (attributes != null && attributes.length > 0) {
        // array = JSONArray.fromObject(items,
        // BeanAttrFilter.getConfig(attributes, null));
        // } else {
        // array = JSONArray.fromObject(items);
        // }
        if (items != null) {
            array = JSONArray.fromObject(items, BeanAttrFilter.getConfig(attributes, null));
        }
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("items", array);
        return json;
    }

    public JSONObject toJson(String[] attributes, String datePattern) {
        JSONArray array = null;
        if(items != null){
            array = JSONArray.fromObject(items, BeanAttrFilter.getConfig(attributes, datePattern));
        }
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("items", array);
        return json;
    }
}
