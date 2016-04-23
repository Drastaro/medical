package com.medicaljournalsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.medicaljournalsystem.dao.UserDAO;
import com.medicaljournalsystem.pojo.Users;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;

	/**
	 * User realted mappings
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {

		return new ModelAndView("admin/loginpage");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Authentication authentication) {
		return authentication.getName();
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public ModelAndView createUser() {

		return new ModelAndView("admin/registrationForm", "command", new Users());

	}

	@RequestMapping("/users/delete/{id}")
	public String removeMedicalJournal(@PathVariable("id") int id) {

		userDao.delete(id);
		return "redirect:/users/list";
	}

	@RequestMapping(value = "/users/submituser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("command") Users user, BindingResult result, ModelMap model) {
		userDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/users/list");
	}

	@RequestMapping(value = "/users/list", method = RequestMethod.GET)
	public ModelAndView listUsers() {

		List<Users> listUsers = userDao.list();
		ModelMap model = new ModelMap();
		model.put("users", listUsers);

		return new ModelAndView("admin/userdata", "modele", model);
	}

}
