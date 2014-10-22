package com.ask.service;

import javax.inject.Named;

import com.ask.model.User;
import com.ask.service.base.IGeneralService;

public interface IUserService extends IGeneralService<User> {


	/**
	 * 根据账号查询user
	 * @param account
	 * @return
	 */
	public User getUserByTelephone(String telephone);
}
