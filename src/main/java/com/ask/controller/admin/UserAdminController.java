package com.ask.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ask.model.User;
import com.ask.service.IUserService;


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
