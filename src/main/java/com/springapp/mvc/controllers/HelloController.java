package com.springapp.mvc.controllers;

import com.springapp.mvc.constants.TradeOrderInfoConstants;
import com.springapp.mvc.utils.ConvertUtil;
import com.springapp.mvc.utils.DateUtils;
import com.springapp.mvc.utils.ReadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HelloController {
	@Autowired
	HttpServletRequest httpServletRequest;

	@RequestMapping(value = "/hello.html")
	public ModelAndView hello() {
		int loc = httpServletRequest.getRequestURL().indexOf("localhost");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("debug", loc != -1 ? "1" : "0");

		return modelAndView;
	}
}