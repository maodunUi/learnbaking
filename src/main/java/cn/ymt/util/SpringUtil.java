package cn.ymt.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	
	public static ApplicationContext context ;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
	}
	
	public static ApplicationContext getContext(){
		return context ;
	}
}
