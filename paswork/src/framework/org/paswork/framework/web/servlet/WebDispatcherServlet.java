package org.paswork.framework.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.paswork.framework.context.spring.SpringDispatcherContextHolder;
import org.springframework.web.servlet.DispatcherServlet;


@Deprecated
public class WebDispatcherServlet extends DispatcherServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SpringDispatcherContextHolder.initDispatcherContext(response);
		super.doService(request, response);
	}
}
