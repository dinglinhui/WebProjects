package com.kingnod.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kingnod.entity.Classes;
import com.kingnod.entity.JcnUser;
import com.kingnod.redis.RedisService;
import com.kingnod.service.JcnUserService;
import com.kingnod.tool.SqlDao;
/**
 * 用户登陆控制
 * @author zhenghongwei
 */
@Controller("loginController")
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	//@Resource(name="accountService")
	//private AccountService accountService;
	
	@Value("#{clientInfo['mapKey']}")
	//@Value("#{clientInfo.mapKey}")
	private String mapKey;
	
	//@Resource(name="UserService")
	@Autowired
	private JcnUserService jcnUserService;
	
	@Autowired
	private SqlDao sqlDao;
	
	@Autowired 
	private RedisService redisService;
	
	public static Set<String> set = new HashSet<String>(); 
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv){
		Subject s=SecurityUtils.getSubject();
		if(s.isRemembered()||s.isAuthenticated()) {
        	//return "redirect:main";
			mv.setViewName("redirect:chat/index");
        }
		mv.setViewName("/view/login");
		return mv;
	}
	
	 @RequestMapping(value="login",method=RequestMethod.POST)
	    public ModelAndView checkLogin(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,ModelAndView mv){
		 logger.info("*****登录参数*****"+userName);   
		 mv.addObject(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM,userName);
	     mv.setViewName("/chat/index");
	     return mv;
	    }
	/**
	 * 登录校验
	 * @param userName 用户名
	 * @param password 密码
	 * @return 重新进入登录页面
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ModelAndView loginPost(@RequestParam(value="userName",required=false) String userName,
			@RequestParam(value="password",required=false) String password,@RequestParam("file") MultipartFile file,
			HttpSession httpSession){
		//accountService.save(userName, password);
		ModelAndView mv = new ModelAndView();
		System.out.println("附件名称"+file.getOriginalFilename());
		JcnUser user = new JcnUser();
		user.setName(userName);
		user.setPassword(password);
		httpSession.setAttribute("user", user);
		httpSession.setAttribute("userName", userName);
		httpSession.setAttribute("password", password);
		mv.addObject("userName",userName);
		mv.addObject("password",password);
		mv.setViewName("view/login");
		System.out.println("执行方法体");
		return mv;
	}
	/**
	 * 返回地图key
	 * @return
	 */
	@ModelAttribute(value="mapkey")
	public String getMapkey(){
		return mapKey;
	}
	@RequestMapping(value="all/{id}")
	@ResponseBody
	public List<JcnUser> allUser(@PathVariable(value="id") Long id){
		
		List<JcnUser> all = jcnUserService.findAllUser(id);
		for(JcnUser user:all){
			System.out.println("**"+user.getName()+"****"+user.getPassword());
		}
		return all;
	}
	
	@RequestMapping(value="save")
	@ResponseBody
	public JcnUser save(){
		JcnUser us = new JcnUser();
		us.setPassword("qqq"+(int)(Math.random()*100));
		us.setName("dongdong"+(int)(Math.random()*1000));
		us.setCreateDate(new Date());
		us.setLastUpdateDate(new Date());
		return	jcnUserService.save(us);
	}
	/**
	 * 使用sring 分页查询 (标准查询)
	 * @param pageNo
	 * @param pageSize
	 * @param user
	 * @return
	 */
	@RequestMapping(value="page",method=RequestMethod.POST)
	@ResponseBody
	public List<JcnUser> page(@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize,@RequestBody final JcnUser user){
		List<JcnUser> list = new ArrayList<JcnUser>();
		list.add(user);
		System.out.println("********"+user.getId()+"*****"+user.getCreateDate()+"****");
		List<Sort.Order> sort = new ArrayList<Sort.Order>();
		Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
		sort.add(order);
		 PageRequest page  = new PageRequest(pageNo,pageSize,new Sort(sort));
		 Specification<JcnUser> sp = new Specification<JcnUser>() {
			@Override
			public Predicate toPredicate(Root<JcnUser> root,CriteriaQuery<?> cq, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				predicates.add(cb.le(root.<Long>get("id"),user.getId()));
				predicates.add(cb.lessThanOrEqualTo(root.<Date>get("createDate"),user.getCreateDate()));
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		
		Page<JcnUser> rs = jcnUserService.pageUser(sp,page);
		return rs.getContent();
	}
	/**
	 * 使用标准查询Criteria
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value="sql",method=RequestMethod.GET)
	@ResponseBody
	public List<JcnUser> findByCriteria(@RequestParam(value="endDate",required=false)Date endDate){
		List<JcnUser> list = new ArrayList<JcnUser>();
		List<Object[]> obs = sqlDao.findAll("SELECT a.id,a.create_date,a.last_update_date,a.user_name,a.password from user a ORDER BY a.id asc");
		if(obs!=null && !obs.isEmpty()){
			for(Object[] ob:obs){
				JcnUser user = new JcnUser();
				user.setId(ob[0]!=null?Long.parseLong(ob[0].toString()):null);
				try {
					user.setCreateDate(ob[1]!=null?DateFormat.getDateInstance().parse(ob[1].toString()):null);
					user.setLastUpdateDate(ob[2]!=null?DateFormat.getDateInstance().parse(ob[2].toString()):null);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setName(ob[3]!=null?ob[3].toString():null);
				user.setPassword(ob[4]!=null?ob[4].toString():null);
				list.add(user);
			}
		}
		return list;
	}
	@RequestMapping(value="one/{id}")
	@ResponseBody
	public JcnUser findOne(@PathVariable(value="id") Long id,@RequestParam(value="categroy",required=true) String categroy){
		if("in".equals(categroy)){
			return jcnUserService.findOne(id);
		}else{
			return jcnUserService.updateOne(id);
		}
	}
	@RequestMapping(value="redis/{id}")
	@ResponseBody
	public List<Long> redisSave(@PathVariable(value="id") Long id){
		System.out.println("start");
		List<Long> list= redisService.putUserId(id);
		System.out.println("end");
		return list;
	}
	@RequestMapping(value="redis")
	@ResponseBody
	public List<String> redisByKey(@RequestParam(value="key",required=true) String key){
		System.out.println("start");
		List<String> list= redisService.findByKey(key);
		System.out.println("end");
		return list;
	}
	@RequestMapping(value="val")
	@ResponseBody
	public Map<Object, Object> redisValByKey(@RequestParam(value="key",required=true) String key){
		System.out.println("start");
			return redisService.findValue(key);
	//	System.out.println("end");
//		return user;
	}
	@RequestMapping(value="save/classes")
	@ResponseBody
	public Classes oneToManySave(){
		return jcnUserService.saveClasses();
	//	System.out.println("end");
//		return user;
	}
	@RequestMapping(value="save/classes/{id}")
	@ResponseBody
	public Classes findOneClasses(@PathVariable(value="id")Long id){
		ModelAndView mv = new ModelAndView();
		//Map<String,Object> map = new HashMap<String,Object>();
		Classes c = jcnUserService.findOneClasses(id);
		//List<User> list = c.getList();
		//System.out.println("*******"+list.size());
		//userService.de(id);
		System.out.println(c.getCode()+c.getName()+"****");
		//map.put("c", c);
		mv.addObject("c",c);
		//mv.setViewName("view/show");
		//System.out.println("*********"+c.getList().size());
		return c;
	}
	@RequestMapping(value="ss",method=RequestMethod.GET)
	public ModelAndView se(HttpSession session){
		ModelAndView mv = new ModelAndView();
		String val = (String)session.getAttribute("ps");
		if(val==null){
			System.out.println("*****kongkong****"+(new Date()).toString());
			session.setAttribute("ps","我是session值");
			session.setMaxInactiveInterval(10);
		}else{
			//System.out.println("**不是空**"+val+"****"+(new Date()).toString());
		}
		if(set.size()==2){
			System.out.println("set**********长度"+set.size());
		}
		for(String str:set){
			System.out.println("********set**值*"+str);
		}
		mv.setViewName("view/show");
		return mv;
	}
}
