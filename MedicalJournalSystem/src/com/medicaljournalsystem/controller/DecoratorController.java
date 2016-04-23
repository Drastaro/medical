package com.medicaljournalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DecoratorController {

	@RequestMapping(value = "/decorators/{decorator}", method = RequestMethod.GET)
	public String pages(@PathVariable(value = "decorator") String decorator) {
		return "decorators/" + decorator;
	}

	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String errorPage() {

		return "pages/500";

	}
}
