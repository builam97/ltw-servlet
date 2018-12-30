package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.model.myMusic;
import com.mvc.util.DBConnection;

public class myMusicDao {
public String addMusic(myMusic music) {
	Connection conn = null;
	conn = DBConnection.createConnection();
	try {
		PreparedStatement pstm = conn.prepareStatement("INSERT INTO mymusic (`musicname`, `author`, `url`, `content`,`extendfile`, `iduser`) VALUES (?, ?, ?, ?, ?, ?)");
		pstm.setString(1, music.getMusicname());
		pstm.setString(2, music.getAuthor());
		pstm.setString(3, music.getUrl());
		pstm.setString(4, music.getContent());
		pstm.setString(5, music.getExtendFile());
		pstm.setInt(6, music.getIduser());
		pstm.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return e.getMessage();
	}
	return "Success";
}
}
