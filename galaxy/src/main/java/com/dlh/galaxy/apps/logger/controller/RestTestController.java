package com.dlh.galaxy.apps.logger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlh.galaxy.apps.logger.domain.DataLog;
import com.dlh.galaxy.apps.logger.service.LoggerDataService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/rest")
@Scope("request")
public class RestTestController {

	@Autowired
	private Environment env;

	@Autowired
	LoggerDataService logservice;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String greeting() {
		DataLog dl = new DataLog();
		dl.setLogString("Hello World!");
		dl.setVersion("2");
		dl.setPerson("dinglinhui@hotmail.com");
		logservice.saveLogData(dl);

		return "hi";
	}

	@RequestMapping(value = "/savelog", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody DataLog savelog(@RequestBody DataLog dl) {

		try {
			logservice.saveLogData(dl);
			Gson gson = new Gson();
			String json = gson.toJson(dl);
			System.out.println(json);
			return dl;
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/getUserLog", method = RequestMethod.POST)
	public @ResponseBody String showLog(@RequestBody String person) {

		try {
			List<DataLog> dl = logservice.getLogData(person);
			Gson gson = new Gson();
			String json = gson.toJson(dl);
			System.out.println(json);
			return json;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public @ResponseBody String getAllUsers() {
		try {
			ArrayList<String> s = (ArrayList<String>) logservice.getAllUsers();
			Gson gson = new Gson();
			String json = gson.toJson(s);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

}
