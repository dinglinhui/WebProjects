package com.dinglinhui.crystalstudio.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dinglinhui.crystalstudio.service.AutoCompleteService;

@Controller
public class AutoPromotController {
	
	//private static final Logger logger = LoggerFactory.getLogger(AutoCompleteController.class);
	@Autowired
	private AutoCompleteService autoCompleteService;
	
	public AutoPromotController() {}

	@RequestMapping(value = "/autopromot", method = RequestMethod.POST)
	/*@ResponseBody*/
	public String auto(HttpServletRequest request) {
		
		String word = (String) request.getParameter("wordtext");
		try {
			word=java.net.URLDecoder.decode(word,"UTF-8");
			//word = new String(word.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<String> list = this.autoCompleteService.auto(word);
		request.setAttribute("words", list);
		return "pubViews/autopromot";
	}
}