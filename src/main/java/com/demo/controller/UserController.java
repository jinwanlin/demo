package com.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xjgz.com.tag.Pager;

import com.demo.model.User;
import com.demo.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model){
		return "user/index";
	}
	
	@RequestMapping(value = "list")
	public String index(Model model, HttpServletRequest request, @RequestParam(value="name", required=false) String name) throws ServletRequestBindingException {

		List<User> list = userService.list(name, getPageIndex(request, "user"), Pager.DEFAULT_PAGE_SIZE);
		int total = userService.count(name);
		
		model.addAttribute("list", list);
		model.addAttribute("total", total);
		return "user/list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) throws ServletRequestBindingException {
		User user = new User();
		model.addAttribute("user", user);
		return "user/add";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Model model, HttpServletRequest request, @RequestParam("telephone") String telephone, @RequestParam("name") String name) throws ServletRequestBindingException {
		
		User user = new User();
		user.setTelephone(telephone);
		user.setName(name);
		userService.create(user);
		model.addAttribute("user", user);
		
		
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") Long id) {
		User user = userService.getByPrimaryKey(id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model, @RequestParam("id") Long id, @RequestParam("telephone") String telephone, @RequestParam("name") String name) {

		User user = userService.getByPrimaryKey(id);
		user.setTelephone(telephone);
		user.setName(name);
		userService.create(user);
		model.addAttribute("user", user);
		
		return "redirect:/user/list";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable("id") Long id) {
		userService.deleteByPrimaryKey(id);
		model.addAttribute("id", id);
		return "redirect:/user/list";
	}
}
