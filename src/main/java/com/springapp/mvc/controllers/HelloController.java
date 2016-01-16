package com.springapp.mvc.controllers;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
	@Autowired
	HttpServletRequest httpServletRequest;

	@RequestMapping(value = "/hello.html")
	public ModelAndView hello() {
		String jsoncallback = httpServletRequest.getParameter("callback");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");

		if(StringUtils.isEmpty(jsoncallback)){
			modelAndView.addObject("message", "{\"domain\":\"message from 8081\"}");
		}else{
			modelAndView.addObject("message", jsoncallback + "({\"domain\":\"message from 8081\"})");

		}

		return modelAndView;
	}
}