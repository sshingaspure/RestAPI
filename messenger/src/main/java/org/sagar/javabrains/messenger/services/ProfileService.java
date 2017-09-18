package org.sagar.javabrains.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sagar.javabrains.messenger.database.DatabaseObject;
import org.sagar.javabrains.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = new DatabaseObject().getAllProfiles();
	
	public ProfileService() {
		profiles.put("sagar", new Profile(1,"sagar","Sagar","Hingsapure"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		return profiles.replace(profile.getProfileName(), profile);
	}
	
	public Profile deleieProfile(String profileName){
		return profiles.remove(profileName);
	}
}
