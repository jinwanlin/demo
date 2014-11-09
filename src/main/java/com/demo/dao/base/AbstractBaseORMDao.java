package com.demo.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.AbstractBaseModel;


/**
 * TODO class purpose description
 * 
 * @author 
 * @version 1.0 Revise History:
 * 
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AbstractBaseORMDao<T extends AbstractBaseModel, PK extends Serializable> extends HibernateDaoSupport implements Serializable, IGeneralORMDao<T, PK> {

    /**
     * 
     */
    private static final long serialVersionUID = -6467478237512628712L;

    private Log log = LogFactory.getLog(getClass());

    protected Class<T> entityClass;

    protected Class<PK> pkClass;

    @SuppressWarnings("unchecked")
    public AbstractBaseORMDao() {
        super();
        this.entityClass = getSuperClassGenricType(getClass(), 0);
        this.pkClass = getSuperClassGenricType(getClass(), 1);
    }

    /**
     * get current bond entity class
     * 
     * @return
     */
    public Class<T> getEntityClass() {
        return entityClass;
    }

    /**
     * 
     * @return
     */
    public Class<PK> getPkClass() {
        return pkClass;
    }

    /**
     * 
     * @param pkClass
     */
    public void setPkClass(Class<PK> pkClass) {
        this.pkClass = pkClass;
    }

    /**
     * 
     * @param entityClass
     */
    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * get current dao parameterize entity type
     * 
     * @param clazz
     *            dao class
     * @param index
     *            parameterize parameter index
     * @return
     */
    @SuppressWarnings("unchecked")
    public Class getSuperClassGenricType(final Class clazz, final int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class) params[index];
    }

    /**
     * 创建实体
     * 
     * @param entity
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(final T entity) {
    	entity.setCreateTime(new Date());
    	entity.setUpdateTime(new Date());
        getHibernateTemplate().save(entity);
    }

    /**
     * 删除实体
     * 
     * @param entity
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final T entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * 根据主键删除实体
     * 
     * @param pk
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteByPrimaryKey(Serializable pk) {
        T entity = this.getByPrimaryKey(pk);
        if (entity != null) {
            delete(entity);
        }
    }

    /**
     * 根据主键查询实体对象
     * 
     * @param pk
     * @return
     */
    public T getByPrimaryKey(Serializable pk) {
        return (T) getHibernateTemplate().get(getEntityClass(), pk);
    }

    /**
     * 保存或者更新实体
     * 
     * @param entity
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(final T entity) {
    	if(entity.getId()==null){
        	entity.setCreateTime(new Date());
    	}
    	entity.setUpdateTime(new Date());
        getHibernateTemplate().saveOrUpdate(entity);

    }

    /**
     * 更新实体
     * 
     * @param entity
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(final T entity) {
    	entity.setUpdateTime(new Date());
        getHibernateTemplate().update(entity);
    }

    /**
     * 获取全部实体
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getHibernateTemplate().find("from " + entityClass.getName());
    }

    /**
     * 通过命名Query查询记录
     * 
     * @param namedQuery
     *            Query名称
     * @return
     */
    @SuppressWarnings("unchecked")
    public List findByNamedQuery(String namedQuery) {
        return getHibernateTemplate().findByNamedQuery(namedQuery);
    }

    /**
     * 通过命名Query查询记录
     * 
     * @param query
     *            Query 名称
     * @param parameter
     *            一个参数
     * @return
     */
    @SuppressWarnings("unchecked")
    public List findByNamedQuery(final String query, final Object parameter) {
        return getHibernateTemplate().findByNamedQuery(query, parameter);
    }

    /**
     * 通过命名Query查询记录
     * 
     * @param query
     *            Query名称
     * @param parameters
     *            多个参数
     * @return
     */
    @SuppressWarnings("unchecked")
    public List findByNamedQuery(final String query, final Object[] parameters) {
        return getHibernateTemplate().findByNamedQuery(query, parameters);
    }

    /**
     * 通过自定义HQL 查询
     * 
     * @param query
     * @return
     */
    @SuppressWarnings("unchecked")
    public List find(final String query) {
        return getHibernateTemplate().find(query);
    }

    /**
     * 通过自定义HQL查询
     * 
     * @param query
     *            自定义HQL
     * @param parameter
     *            参数值
     * @return
     */
    @SuppressWarnings("unchecked")
    public List find(final String query, final Object parameter) {
        return getHibernateTemplate().find(query, parameter);
    }

    /**
     * 通过自定义HQL查询
     * 
     * @param query
     *            自定义HQL
     * @param parameter
     *            参数值
     * @return
     */
    @SuppressWarnings("unchecked")
    public List find(final String query, final Object[] parameter) {
        return getHibernateTemplate().find(query, parameter);
    }

    /**
     * 条件查询总数
     * 
     * @param detachedCriteria
     * @return
     */
    public int countByCriteria(final DetachedCriteria detachedCriteria) {
        Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
            public Long doInHibernate(Session session) throws HibernateException {
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                criteria.setProjection(Projections.rowCount());
                return (Long) criteria.uniqueResult();
            }
        });
        return count.intValue();
    }

    /**
     * 条件查询
     * 
     * @param detachedCriteria条件
     * @param pageIndex
     *            索引起始页
     * @param pageSize
     *            每页显示个数
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> listByCriteria(final DetachedCriteria detachedCriteria, final int pageIndex, final int pageSize) {
        return (List) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                criteria.setFirstResult((pageIndex - 1) * pageSize);
                criteria.setMaxResults(pageSize);
                return criteria.list();
            }
        });
    }

    /**
     * 条件查询
     * 
     * @param detachedCriteria条件
     * @param pageIndex
     *            索引起始页
     * @param pageSize
     *            每页显示个数
     * @return
     */
    @SuppressWarnings("unchecked")
    public PageResult getPageByCriteria(final DetachedCriteria detachedCriteria, final int pageIndex, final int pageSize) {
        return (PageResult) getHibernateTemplate().execute(new HibernateCallback<PageResult>() {
            public PageResult doInHibernate(Session session) throws HibernateException {
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                int total = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
                List list = null;
                if (total > 0) {
                    criteria.setProjection(null);
                    criteria.setFirstResult((pageIndex - 1) * pageSize);
                    criteria.setMaxResults(pageSize);
                    list = criteria.list();
                } else {
                    list = Collections.EMPTY_LIST;
                }
                return new PageResult(list, total);
            }
        });
    }

    /**
     * 条件查询
     * 
     * @param detachedCriteria条件
     * @param pageIndex
     *            索引起始页
     * @param pageSize
     *            每页显示个数
     * @return
     */
    @SuppressWarnings("unchecked")
    public List listByCriteria(final DetachedCriteria detachedCriteria) {
        return (List) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                return criteria.list();
            }
        });
    }

    public Log getLog() {
        return log;
    }

}
