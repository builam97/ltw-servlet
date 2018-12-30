package com.mvc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.FavoriteMusic;
import com.mvc.model.myMusic;
import com.mvc.util.DBConnection;

public class MyMusicService {
	public List<myMusic> getAllMyMusic(String username){
		List<myMusic> list = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		conn = DBConnection.createConnection();
		myMusic music=null;
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from mymusic inner join users on mymusic.iduser = users.idusers where username=?");
			pstm.setString(1, username);
			rs=pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idmusic");
				String musicname = rs.getString("musicname");
				String author = rs.getString("author");
				String url = rs.getString("url");
				String content = rs.getString("content");
				String extendfile = rs.getString("extendfile");
				int iduser = rs.getInt("iduser");
				music=new myMusic(id,musicname,author,url,content,extendfile,iduser);
				list.add(music);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
