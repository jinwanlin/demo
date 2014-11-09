package com.demo.model;


/**
 * 用户
 * @author jinwanlin
 *
 */
@SuppressWarnings("serial")
public class User extends AbstractBaseModel {

	
	/** 账号（类似qq号）  */
	private String telephone;

	private String name;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
