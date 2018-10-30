package com.syx.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="userDao")
public class UserDao {
	@Value(value="ooo")
    private String name;
	@Value(value="789")
    private String password;

	//public UserDao(String name, String password) {
	//	this.name = name;
	//	this.password = password;
	//}

	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserDao [name=" + name + ", password=" + password + "]";
	}
}
