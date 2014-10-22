
package com.ask.service.base;

import java.io.Serializable;

import com.ask.dao.base.IGeneralJdbcDao;
import com.ask.dao.base.IGeneralORMDao;
import com.ask.model.AbstractBaseModel;



public class AbstractBaseService<T extends AbstractBaseModel> implements Serializable, IGeneralService<T> {

    /**
     * 
     */
    private static final long serialVersionUID = -137460265474032597L;

    // assisate with hiberanteTemplate
    private IGeneralORMDao<T, Long> generalDao;

    // assisate with jdbcTemplate
    private IGeneralJdbcDao jdbcDao;

    /**
     * 创建实体
     * 
     * @param entity
     */
    public void create(T entity) {
        generalDao.create(entity);
    }

    /**
     * 保存或者更新实体
     * 
     * @param entity
     */
    public void saveOrUpdate(T entity) {
        generalDao.saveOrUpdate(entity);
    }

    /**
     * 更新实体
     * 
     * @param entity
     */
    public void update(T entity) {
        generalDao.update(entity);
    }

    /**
     * 删除实体
     * 
     * @param entity
     */
    public void delete(T entity) {
        generalDao.delete(entity);
    }

    /**
     * 根据主键查询实体对象
     * 
     * @param pk
     * @return
     */
    public T getByPrimaryKey(Long id) {
        return generalDao.getByPrimaryKey(id);
    }

    /**
     * 根据实体删除实体
     * 
     * @param pk
     */
    public void deleteByPrimaryKey(Long id) {
        generalDao.deleteByPrimaryKey(id);
    }

    public IGeneralORMDao<T, Long> getGeneralDao() {
        return generalDao;
    }

    public void setGeneralDao(IGeneralORMDao<T, Long> generalDao) {
        this.generalDao = generalDao;
    }

    public IGeneralJdbcDao getJdbcDao() {
        return jdbcDao;
    }

    public void setJdbcDao(IGeneralJdbcDao jdbcDao) {
        this.jdbcDao = jdbcDao;
    }

}
