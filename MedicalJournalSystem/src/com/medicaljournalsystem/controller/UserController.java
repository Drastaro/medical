package com.medicaljournalsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
import com.medicaljournalsystem.pojo.User;

@Controller
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

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

	@Secured("ROLE_PUBLISHER")
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Authentication authentication) {
		return authentication.getName();
	}

	@Secured("ROLE_PUBLISHER")
	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public ModelAndView createUser() {

		return new ModelAndView("admin/registrationForm", "command", new User());
	}

	@Secured("ROLE_PUBLISHER")
	@RequestMapping(value = "/users/submituser", method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute("command") User user, BindingResult result, ModelMap model) {
		logger.debug("UserController/users/submituser called!");
		if (result.hasErrors()) {

			return new ModelAndView("admin/registrationForm");
		}
		userDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/users/list");
	}

	@Secured("ROLE_PUBLISHER")
	@RequestMapping("/users/delete/{id}")
	public String removeMedicalJournal(@PathVariable("id") int id) {

		userDao.delete(id);
		return "redirect:/users/list";
	}

	@Secured("ROLE_PUBLISHER")
	@RequestMapping(value = "/users/list", method = RequestMethod.GET)
	public ModelAndView listUsers() {

		List<User> listUsers = userDao.list();
		ModelMap model = new ModelMap();
		model.put("users", listUsers);

		return new ModelAndView("admin/userdata", "modele", model);
	}

}
