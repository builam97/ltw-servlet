package com.mvc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginBean {
private String username;
private String password;
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public LoginBean(int id,String username, String password) {
	super();
	this.username = username;
	this.password = password;
	this.id=id;
}
public LoginBean() {
	super();
}

}
