package com.syx.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo {

	@Test
	public void run(){
		UserService us = new UserServiceImpl();
		us.sayHello();
	}
	
	@Test
	public void run2(){
		//创建工厂
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取对象
		UserService us = (UserService) ac.getBean("userService");
		
		//调用方法
		//us.sayHello();
		System.out.println(us);
	}

}
