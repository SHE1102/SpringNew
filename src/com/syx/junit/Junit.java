package com.syx.junit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.syx.ioc.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Junit {

	@Resource(name="userService")
	private UserService us;
	@Test
	public void run(){
		//System.out.println("junit");
		us.sayHello();
	}
}
