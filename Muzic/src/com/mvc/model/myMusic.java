package com.mvc.model;

public class myMusic {
private int id;
private String musicname;
private String author;
private String url;
private String content;
private String extendFile;
private int iduser;
public int getId() {
	return id;
}
public String getExtendFile() {
	return extendFile;
}
public void setExtendFile(String extendFile) {
	this.extendFile = extendFile;
}
public void setId(int id) {
	this.id = id;
}
public String getMusicname() {
	return musicname;
}
public void setMusicname(String musicname) {
	this.musicname = musicname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser = iduser;
}
public myMusic(int id, String musicname, String author, String url, String content,String extendFile, int iduser) {
	super();
	this.id = id;
	this.musicname = musicname;
	this.author = author;
	this.url = url;
	this.content = content;
	this.extendFile = extendFile;
	this.iduser = iduser;
}
public myMusic() {
	super();
}

}
