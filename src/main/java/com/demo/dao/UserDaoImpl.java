package com.demo.dao;import java.sql.SQLException;import javax.annotation.Resource;import org.hibernate.HibernateException;import org.hibernate.Query;import org.hibernate.Session;import org.hibernate.SessionFactory;import org.springframework.orm.hibernate3.HibernateCallback;import org.springframework.stereotype.Repository;import com.demo.dao.base.AbstractBaseORMDao;import com.demo.model.User;@Repository("userDao")public class UserDaoImpl extends AbstractBaseORMDao<User, Long> implements IUserDao {	private static final long serialVersionUID = 2725175497706339564L;	@Resource(name = "sessionFactory")	public void setSuperSessionFactory(SessionFactory sessionFactory) {		super.setSessionFactory(sessionFactory);	}	@Override		public User getUserByTelephone(final String account) {		return getHibernateTemplate().execute(new HibernateCallback<User>() {			public User doInHibernate(Session session) throws HibernateException, SQLException {				Query query = session.createQuery("From User where telephone = :telephone");				query.setParameter("telephone", account);				return (User) query.uniqueResult();			}		});	}}