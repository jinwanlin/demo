package com.demo.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * TODO class purpose description
 * 
 * @author 
 * @version 1.0 Revise History:
 * 
 */
public interface IGeneralORMDao<T, PK extends Serializable> {

    /**
     * 创建实体
     * 
     * @param entity
     */
    public void create(final T entity);

    /**
     * 删除实体
     * 
     * @param entity
     */
    public void delete(final T entity);

    /**
     * 根据主键删除实体
     * 
     * @param pk
     */
    public void deleteByPrimaryKey(Serializable pk);

    /**
     * 根据主键查询实体对象
     * 
     * @param pk
     * @return
     */
    public T getByPrimaryKey(Serializable pk);

    /**
     * 保存或者更新实体
     * 
     * @param entity
     */
    public void saveOrUpdate(final T entity);

    /**
     * 更新实体
     * 
     * @param entity
     */
    public void update(final T entity);

    public List<T> findAll();
}
