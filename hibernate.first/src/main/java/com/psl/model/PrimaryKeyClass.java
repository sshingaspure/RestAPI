package com.psl.model;

import java.io.Serializable;

import javax.persistence.Column;


public class PrimaryKeyClass implements Serializable{
	//private static final long serialVersionUID = 1840766674582512L;
	
	private int id;
	@Column(name="user_name")
	private String username;
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
	
	
}
