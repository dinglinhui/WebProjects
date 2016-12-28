package org.paswork.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MessageTest {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new FileSystemXmlApplicationContext(
				"/src/resource/org/paswork/resource/spring/spring-base.xml");

		String str = ctx.getMessage("atsview.header.topnav.about", null, null);
		System.out.println(str);
	}

}
