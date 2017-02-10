package com.kingnod.pushlet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;
import com.kingnod.entity.Chat;
import com.kingnod.service.ChatService;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

@Component
public class PushletService extends HttpServlet{
	
	//@Autowired
	//private TaskDao taskDao;
	@Autowired
	private ChatService chatService;
	{
		WebApplicationContext	applicationContext = ContextLoaderListener.getCurrentWebApplicationContext();
		//手动注入dao或者Service
		//taskDao =(TaskDao)applicationContext.getBean("taskDao");
		chatService =(ChatService)applicationContext.getBean("chatService");
	}
	
	/*public  String findAllTask() throws UnsupportedEncodingException{
		List<Task> rs = new ArrayList<Task>();
		List<Task> list= taskDao.findAll();
		if(list!=null && !list.isEmpty()){
			for(Task task :list){
				task.setUser(null);
				rs.add(task);
			}
		}
		Gson gson = new Gson();
		String message = gson.toJson(rs);
		return URLEncoder.encode(message, "UTF-8");
	}*/
	/**
	 * 获取所有未读的信息（具体信息的过滤在页面上实现）
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public  String findNotReadChat() throws UnsupportedEncodingException{
		final List<Chat> list= chatService.findNotReadChat();
		new Thread(new Runnable() {
			@Override
			public void run() {
			 	try {
			 		chatService.setReadFlag(list);
				} catch (Exception e) {
					
				}
			}
		}).start();
		Gson gson = new Gson();
		String message = gson.toJson(list);
		return URLEncoder.encode(message, "UTF-8");
	}
	
	/**
	 * 使用Pushlet实现消息推送
	 */
	public static class  Pushlet extends EventPullSource{

		@Override
		protected long getSleepTime() {
			return 1000;
		}
		
		@Override
		protected Event pullEvent() {
			String message = "";
			try {
				message = (new PushletService()).findNotReadChat();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Event event = Event.createDataEvent("/zheng/hongwei");
            event.setField("mes",message);
            event.setField("time", Calendar.getInstance().getTime().getTime());
            return event;
		}
	}
	
	@Override
    public void init(ServletConfig config) throws ServletException{
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());
    }
}
