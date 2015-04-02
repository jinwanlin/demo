package com.demo.service;

import java.util.List;

import com.demo.model.User;
import com.demo.service.base.IGeneralService;

public interface IUserService extends IGeneralService<User> {


	/**
	 * 根据账号查询user
	 * @param account
	 * @return
	 */
	public User getUserByTelephone(String telephone);
	
	public List<User> list(String name, int page, int size);
	
	public int count(String name);

}
