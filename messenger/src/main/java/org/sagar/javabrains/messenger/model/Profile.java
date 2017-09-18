package org.sagar.javabrains.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	private int id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date createdDate;

	public Profile() {
		this.createdDate=new Date();
	}

	public Profile(int id, String profileName, String firstName, String lastName) {
		super();
		this.id = id;
		this.profileName=profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
}
