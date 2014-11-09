package com.demo.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.User;
import com.demo.service.IUserService;


/**
 * 菜单管理
 * 
 * @author jinwanlin
 *
 */
@Controller
@RequestMapping("/admin/user")
public class UserAdminController {

	@Resource(name = "userService")
	private IUserService userService;

	/**
	 * 菜单列表
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String index(Model model, @RequestParam("telephone") String telephone) throws ServletRequestBindingException {
		
		User user = new User();
		user.setTelephone(telephone);
		userService.saveOrUpdate(user);
		
		User user2 = userService.getUserByTelephone(telephone);
		System.out.println(user2.getTelephone());

		
		System.out.println("-----");
		return "menu/index";
	}

}
