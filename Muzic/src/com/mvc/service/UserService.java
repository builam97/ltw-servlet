package com.mvc.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.LoginBean;
import com.mvc.model.ResponseString;
import com.mvc.util.DBConnection;
public class UserService {
	public List<LoginBean> getAllUser(){
		List<LoginBean> list=new ArrayList<>();
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		String userNameDB = "";
		 String passwordDB = "";
		 int id;
		conn = DBConnection.createConnection();
		try {
			state = conn.createStatement();
			rs = state.executeQuery("select * from users");
			
			while(rs.next()) {
				id= rs.getInt("idusers");
				userNameDB = rs.getString("username");
				passwordDB = rs.getString("password");
				System.out.println(userNameDB);
				LoginBean user=new LoginBean(id,userNameDB,passwordDB);
				list.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public LoginBean getUser(int id) {
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		String userNameDB = "";
		 String passwordDB = "";
		conn = DBConnection.createConnection();
		LoginBean user=null;
		try {
			state = conn.createStatement();
			PreparedStatement pstm = conn.prepareStatement("select * from users where idusers=?");
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userNameDB = rs.getString("username");
				passwordDB = rs.getString("password");
				user=new LoginBean(id,userNameDB,passwordDB);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		}
	public Object postUser(LoginBean userBean) {
		Connection conn = null;
		ResultSet rs = null;
		conn = DBConnection.createConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO users (`username`, `password`) VALUES (?,?)");
			pstm.setString(1, userBean.getUsername());
			pstm.setString(2,userBean.getPassword());
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (e instanceof SQLIntegrityConstraintViolationException) {
		        return new ResponseString("Tài khoản đã có");
		    } else {
		        e.printStackTrace();
		    }
		}
		return new ResponseString("Success");
		}
	
}
