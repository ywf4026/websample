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
import java.text.ParseException;
import java.util.Map;

@Controller
public class QueryReplaceController {
	private static final String LOCAL_PATH = "/Users/liufeng/";
	private static final String ONLINE_PATH = "/home/liufeng/dev/data/";
	@Autowired
	HttpServletRequest httpServletRequest;
	@RequestMapping({"/tradeorder", "/tradeorder/trade"})
	public ModelAndView tradeorder() {
		String debug = httpServletRequest.getParameter("debug");
		String path = ONLINE_PATH + "tradeorder";
		if("1".equals(debug)){
			path = LOCAL_PATH + "tradeorder";
		}

		String days = httpServletRequest.getParameter("days");
		String[][] rows = null;
		if(StringUtils.isEmpty(days)){
			days = "1";
		}
		Map<String, String[]> rowsMap = null;
		long lastDays = Long.parseLong(days);
		String[] daysPeriod = DateUtils.getLastDaysPeriod(lastDays);
		if(daysPeriod != null){
			for(String day : daysPeriod){
				String[][] newRows = ReadFileUtil.readFileByLines(path + day, TradeOrderInfoConstants.tradeAuthorMap);
				Map<String, String[]> newRowsMap = ConvertUtil.convertToRowsMap2(newRows);
				rowsMap = ConvertUtil.mergeRows(newRowsMap, rowsMap, 2);
			}
		}
		rows = ConvertUtil.convertToStringArr(rowsMap, 2);



		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("trade");
		modelAndView.addObject("rowsArray", rows);
		modelAndView.addObject("daysPeriod", daysPeriod);
		modelAndView.addObject("debug", debug);

		return modelAndView;
	}

	@RequestMapping({"/phpmethod","/tradeorder/phpmethod"})
	public ModelAndView phpmethod() throws ParseException {
		String debug = httpServletRequest.getParameter("debug");
		String path = ONLINE_PATH + "phpmethod";
		if("1".equals(debug)){
			path = LOCAL_PATH + "phpmethod";
		}

		String days = httpServletRequest.getParameter("days");
		String[][] rows = null;
		if(StringUtils.isEmpty(days)){
			days = "1";
		}
		Map<String, String[]> rowsMap = null;
		long lastDays = Long.parseLong(days);
		String[] daysPeriod = DateUtils.getLastDaysPeriod(lastDays);
		if(daysPeriod != null){
			for(String day : daysPeriod){
				String[][] newRows = ReadFileUtil.readFileByLines(path + day, TradeOrderInfoConstants.phpMethodMap);
				Map<String, String[]> newRowsMap = ConvertUtil.convertToRowsMap(newRows);
				rowsMap = ConvertUtil.mergeRows(newRowsMap, rowsMap, 1);
			}
		}
		rows = ConvertUtil.convertToStringArr(rowsMap, 1);


		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("phpmethod");
		modelAndView.addObject("rowsArray", rows);
		modelAndView.addObject("daysPeriod", daysPeriod);
		modelAndView.addObject("debug", debug);


		return modelAndView;
	}


	@RequestMapping({"/timeline","/tradeorder/timeline"})
	public ModelAndView timeline() {
		String debug = httpServletRequest.getParameter("debug");
		String path = ONLINE_PATH + "tradeaftersaletimeline";
		if("1".equals(debug)){
			path = LOCAL_PATH + "tradeaftersaletimeline";
		}

		String days = httpServletRequest.getParameter("days");
		String[][] rows = null;
		if(StringUtils.isEmpty(days)){
			days = "1";
		}
		Map<String, String[]> rowsMap = null;
		long lastDays = Long.parseLong(days);
		String[] daysPeriod = DateUtils.getLastDaysPeriod(lastDays);
		if(daysPeriod != null){
			for(String day : daysPeriod){
				String[][] newRows = ReadFileUtil.readFileByLines(path + day, TradeOrderInfoConstants.tradeAuthorMap);
				Map<String, String[]> newRowsMap = ConvertUtil.convertToRowsMap2(newRows);
				rowsMap = ConvertUtil.mergeRows(newRowsMap, rowsMap, 2);
			}
		}
		rows = ConvertUtil.convertToStringArr(rowsMap, 2);



		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tradeaftersaletimeline");
		modelAndView.addObject("rowsArray", rows);
		modelAndView.addObject("daysPeriod", daysPeriod);
		modelAndView.addObject("debug", debug);

		return modelAndView;
	}

	@RequestMapping({"/refund","/tradeorder/refund"})
	public ModelAndView refund() {
		String debug = httpServletRequest.getParameter("debug");
		String path = ONLINE_PATH + "traderefund";
		if("1".equals(debug)){
			path = LOCAL_PATH + "traderefund";
		}

		String days = httpServletRequest.getParameter("days");
		String[][] rows = null;
		if(StringUtils.isEmpty(days)){
			days = "1";
		}
		Map<String, String[]> rowsMap = null;
		long lastDays = Long.parseLong(days);
		String[] daysPeriod = DateUtils.getLastDaysPeriod(lastDays);
		if(daysPeriod != null){
			for(String day : daysPeriod){
				String[][] newRows = ReadFileUtil.readFileByLines(path + day, TradeOrderInfoConstants.tradeAuthorMap);
				Map<String, String[]> newRowsMap = ConvertUtil.convertToRowsMap2(newRows);
				rowsMap = ConvertUtil.mergeRows(newRowsMap, rowsMap, 2);
			}
		}
		rows = ConvertUtil.convertToStringArr(rowsMap, 2);



		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("traderefund");
		modelAndView.addObject("rowsArray", rows);
		modelAndView.addObject("daysPeriod", daysPeriod);
		modelAndView.addObject("debug", debug);

		return modelAndView;
	}
}