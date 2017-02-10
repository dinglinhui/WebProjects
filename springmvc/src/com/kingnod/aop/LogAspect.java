package com.kingnod.aop;     
    
import java.util.Map;

import org.aspectj.lang.JoinPoint;     
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
    
/**    
 * 日志切面类    切面必须注解为 @Service @Aspect或者@Component @Aspect  或者@Aspect并且在springmvc-servlet.xml中加上<bean class=""/>注入
 * @author zhenghongwei    
 */ 
//@Component
@Service
@Aspect
public class LogAspect {     
    
    //任何通知方法都可以将第一个参数定义为 org.aspectj.lang.JoinPoint类型      
	@Before("execution(* com.kingnod.controller.LoginController.loginPost(..))")
    public void before(JoinPoint call) {     
        //获取目标对象对应的类名     
        String className = call.getTarget().getClass().getName();     
        //获取目标对象上正在执行的方法名     
        String methodName = call.getSignature().getName();     
        Object object[] = call.getArgs();
        //此处根据参数有几个就会有几个，即使是null,也会读取出为null
       /* for(Object ob :object){
        	System.out.println("参数"+(String)ob);
        }*/
      //  System.out.println("前置通知:" + className + "类的" + methodName + "方法开始了");     
    }     
      
    /**
     * 获取方法返回值
     * @param call
     * @param parame
     */
	@AfterReturning(returning="parame",pointcut="execution(* com.kingnod.controller.LoginController.loginPost(..))")
    public void afterReturn(JoinPoint call,Object parame) { 
    	ModelAndView mv = (ModelAndView)parame;
    	Map<String,Object> map = mv.getModel();
    	System.out.println("返回值"+map.get("userName"));
        System.out.println("后置通知:方法正常结束了");
    }     
         
   
}   