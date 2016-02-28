package com.springapp.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebSQLController {
	@Autowired
	HttpServletRequest httpServletRequest;

	@RequestMapping(value = "/websql.html")
	public ModelAndView hello() {
		int loc = httpServletRequest.getRequestURL().indexOf("localhost");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("websql");
		modelAndView.addObject("message", "Hello World!");

		return modelAndView;
	}
}