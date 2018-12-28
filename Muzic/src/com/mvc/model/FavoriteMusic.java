package com.mvc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FavoriteMusic {
private int id;
private String title;
private String authorname;
private String avatar_url;
private int iduser;
private int idTrack;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public String getAuthorname() {
	return authorname;
}
public void setAuthorname(String authorname) {
	this.authorname = authorname;
}
public String getAvatar_url() {
	return avatar_url;
}
public void setAvatar_url(String avatar_url) {
	this.avatar_url = avatar_url;
}

public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser = iduser;
}
public int getIdTrack() {
	return idTrack;
}
public void setIdTrack(int idTrack) {
	this.idTrack = idTrack;
}
public FavoriteMusic(int id, String title, String authorname, String image_url, int iduser, int idTrack) {
	super();
	this.id = id;
	this.title = title;
	this.authorname = authorname;
	this.avatar_url = image_url;
	this.iduser = iduser;
	this.idTrack = idTrack;
}
public FavoriteMusic() {
	super();
}


}
