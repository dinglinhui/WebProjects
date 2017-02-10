package rml.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import rml.util.StringEscapeEditor;

@Controller
@RequestMapping("/baseController")
public class BaseController {

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		// prevent xss attack
		binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
	}

	@RequestMapping("/{folder}/{jspName}")
	public String redirectJsp(@PathVariable String folder, @PathVariable String jspName) {
		return "/" + folder + "/" + jspName;
	}
	
}
