package com.dlh.web.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dlh.web.model.FormatModel;

@Controller
@RequestMapping(value = "/format")
public class FormatController {

	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	public String test(Model model) throws NoSuchFieldException,
			SecurityException {
		if (!model.containsAttribute("contentModel")) {

			FormatModel formatModel = new FormatModel();

			formatModel.setMoney(12345.678);
			formatModel.setDate(new Date());

			model.addAttribute("contentModel", formatModel);
		}
		return "formattest";
	}

}
