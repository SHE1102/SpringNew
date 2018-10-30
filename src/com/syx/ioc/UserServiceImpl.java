package com.syx.ioc;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="userService")
public class UserServiceImpl implements UserService{
	@Value(value="she")
    private String name;
    public void setName(String name){
    	this.name = name;
    }
    
    //@Autowired
    //@Qualifier(value="userDao")
    @Resource(name="userDao")
    private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("initialize....");
	}

	public void sayHello(){
		System.out.println("Hello spring " + name);
	}

	@Override
	public String toString() {
		return "UserServiceImpl [name=" + name + ", userDao=" + userDao + "]";
	}
   

}
