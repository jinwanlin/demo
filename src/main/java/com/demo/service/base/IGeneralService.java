
package com.demo.service.base;

import java.util.List;


public interface IGeneralService<T> {

    /**
     * 创建实体
     * 
     * @param entity
     */
    public void create(T entity);

    /**
     * 保存或者更新实体
     * 
     * @param entity
     */
    public void saveOrUpdate(T entity);

    /**
     * 更新实体
     * 
     * @param entity
     */
    public void update(T entity);

    /**
     * 删除实体
     * 
     * @param entity
     */
    public void delete(T entity);

    /**
     * 根据主键查询实体对象
     * 
     * @param pk
     * @return
     */
    public T getByPrimaryKey(Long pk);

    /**
     * 根据实体删除实体
     * 
     * @param pk
     */
    public void deleteByPrimaryKey(Long pk);
    
    public List<T> findAll();
}
