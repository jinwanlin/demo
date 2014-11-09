package com.demo.service;

import javax.inject.Named;

import com.demo.model.User;
import com.demo.service.base.IGeneralService;

public interface IUserService extends IGeneralService<User> {


	/**
	 * 根据账号查询user
	 * @param account
	 * @return
	 */
	public User getUserByTelephone(String telephone);
}
