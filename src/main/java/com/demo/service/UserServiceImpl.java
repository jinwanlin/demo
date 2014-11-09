package com.demo.service;

import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Named;

import com.demo.dao.IUserDao;
import com.demo.dao.base.IGeneralORMDao;
import com.demo.model.User;
import com.demo.service.base.AbstractBaseService;

@Named("userService")
public class UserServiceImpl extends AbstractBaseService<User> implements IUserService {

	private static final long serialVersionUID = 2127822065371631043L;

	@Override
	@Resource(name = "userDao")
	public void setGeneralDao(IGeneralORMDao<User, Long> userDao) {
		super.setGeneralDao(userDao);
	}

	/**
	 * 用生成的account到数据库中查一下，看是否已被占用。
	 * 
	 * @return
	 */
	private String generateAccount() {
		IUserDao dao = (IUserDao) this.getGeneralDao();

		String account = "";
		while (true) {
			account = random();
			User user = dao.getUserByTelephone(account);
			if (user == null) {
				break;
			}
		}
		return account;
	}

	/**
	 * 生成用户唯一账号，类似QQ号。（暂时使用主键ID）
	 * 
	 * @return
	 */
	private String random() {
		Random r = new Random();
		int t = r.nextInt(10000) + 1;

		return t + "";
	}

	/**
	 * 根据账号查询user
	 * 
	 * @param account
	 * @return
	 */
	public User getUserByTelephone(String telephone) {
		IUserDao dao = (IUserDao) this.getGeneralDao();
		return dao.getUserByTelephone(telephone);
	}


}
