package com.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.model.LoginBean;
import com.mvc.util.DBConnection;

import java.sql.Connection;
import java.sql.Statement;

public class LoginDao {
public String authenticateUser(LoginBean loginbean) {
	String username = loginbean.getUsername();
	String password = loginbean.getPassword();
	Connection conn = null;
	Statement state = null;
	ResultSet rs = null;
	String userNameDB = "";
	 String passwordDB = "";
	conn = DBConnection.createConnection();
	try {
		state = conn.createStatement();
		rs = state.executeQuery("select * from users");
		
		while(rs.next()) {
			userNameDB = rs.getString("username");
			passwordDB = rs.getString("password");
			loginbean.setId(rs.getInt("idusers"));
			System.out.println(userNameDB);
			 if(username.equals(userNameDB) && password.equals(passwordDB))
			   {
			      return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
			   }
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Invalid user credentials";
}
}
