package com.dlh.galaxy.web.admin.tools;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.dlh.galaxy.web.admin.tools.DateConvertEditor;

/**
 * @author
 * @version
 */
public class SystemWebBinding implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {

		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

}
