package com.demo.dao;import java.sql.SQLException;import java.util.List;import javax.annotation.Resource;import org.apache.commons.lang.StringUtils;import org.hibernate.HibernateException;import org.hibernate.Query;import org.hibernate.Session;import org.hibernate.SessionFactory;import org.springframework.orm.hibernate3.HibernateCallback;import org.springframework.stereotype.Repository;import com.demo.dao.base.AbstractBaseORMDao;import com.demo.model.User;@Repository("userDao")public class UserDaoImpl extends AbstractBaseORMDao<User, Long> implements IUserDao {	private static final long serialVersionUID = 2725175497706339564L;	@Resource(name = "sessionFactory")	public void setSuperSessionFactory(SessionFactory sessionFactory) {		super.setSessionFactory(sessionFactory);	}	@Override	public User getUserByTelephone(final String account) {		return getHibernateTemplate().execute(new HibernateCallback<User>() {			public User doInHibernate(Session session) throws HibernateException, SQLException {				Query query = session.createQuery("From User where telephone = :telephone");				query.setParameter("telephone", account);				return (User) query.uniqueResult();			}		});	}	@Override	public List<User> list(final String name, final int page, final int size) {		return getHibernateTemplate().execute(new HibernateCallback<List<User>>() {			@SuppressWarnings("unchecked")			public List<User> doInHibernate(Session session) throws HibernateException, SQLException {				StringBuffer sb = new StringBuffer("from User as t where 1=1");				if (StringUtils.isNotBlank(name)) {					sb.append(" and name like :name");				}				sb.append(" order by id desc");				Query query = session.createQuery(sb.toString());				if (StringUtils.isNotBlank(name)) {					query.setParameter("name", '%' + name + '%');				}				query.setFirstResult((page - 1) * size);				query.setMaxResults(size);				return (List<User>) query.list();			}		});	}	@Override	public int count(final String name) {		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {			public Integer doInHibernate(Session session) throws HibernateException, SQLException {				StringBuffer sb = new StringBuffer("select count(*) from User where 1=1");				if (StringUtils.isNotBlank(name)) {					sb.append(" and name like :name");				}				Query query = session.createQuery(sb.toString());				if (StringUtils.isNotBlank(name)) {					query.setParameter("name", '%' + name + '%');				}				Long total = (Long) query.uniqueResult();				return Integer.parseInt(total.toString());			}		});	}}