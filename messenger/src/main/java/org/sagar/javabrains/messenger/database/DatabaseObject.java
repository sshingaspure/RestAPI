package org.sagar.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.sagar.javabrains.messenger.model.Message;
import org.sagar.javabrains.messenger.model.Profile;

public class DatabaseObject {

	private static Map<Integer, Message> messages=new HashMap<Integer,Message>();
	
	private static Map<String, Profile> profiles=new HashMap<String,Profile>();
	
	public Map<Integer, Message> getMessageMap() {
		return messages;
	}
	
	public Map<String, Profile> getAllProfiles(){
		return profiles;
	}
	
}
