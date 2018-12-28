package com.mvc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.FavoriteMusic;
import com.mvc.model.LoginBean;
import com.mvc.model.ResponseString;
import com.mvc.util.DBConnection;

public class FavoriteMusicService {
public List<FavoriteMusic> getAllLoveMusic(String username){
	List<FavoriteMusic> list = new ArrayList<>();
	Connection conn = null;
	ResultSet rs = null;
	conn = DBConnection.createConnection();
	FavoriteMusic music=null;
	try {
		PreparedStatement pstm = conn.prepareStatement("select * from favoritemusic inner join users on favoritemusic.idusers = users.idusers where username=?");
		pstm.setString(1, username);
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("idfavoritemusic");
			String title = rs.getString("title");
			String author = rs.getString("authorname");
			String url = rs.getString("avatar_url");
			int idtrack = rs.getInt("idTrack");
			int iduser = rs.getInt("idusers");
			music=new FavoriteMusic(id,title,author,url,iduser,idtrack);
			list.add(music);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
public Object postFavoriteMusic(FavoriteMusic fmusic) {
	Connection conn = null;
	ResultSet rs = null;
	conn = DBConnection.createConnection();
	try {
		
		PreparedStatement pstm = conn.prepareStatement("INSERT INTO `music`.`favoritemusic` (`title`, `authorname`, `avatar_url`, `idTrack`, `idusers`) VALUES (?, ?, ?, ?, ?)");
		pstm.setString(1, fmusic.getTitle());
		pstm.setString(2,fmusic.getAuthorname());
		pstm.setString(3,fmusic.getAvatar_url());
		pstm.setInt(4,fmusic.getIdTrack());//?
		pstm.setInt(5,fmusic.getIduser());//?
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
public Object delFavoriteMusic(int id) {
	Connection conn = null;
	ResultSet rs = null;
	conn = DBConnection.createConnection();
	try {
		
		PreparedStatement pstm = conn.prepareStatement("Delete from favoritemusic where idfavoritemusic =?");
		pstm.setInt(1, id);
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
