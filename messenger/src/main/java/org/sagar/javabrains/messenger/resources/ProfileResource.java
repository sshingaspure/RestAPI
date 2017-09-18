package org.sagar.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sagar.javabrains.messenger.model.Profile;
import org.sagar.javabrains.messenger.services.ProfileService;

@Path("/profiles")
public class ProfileResource {

	static ProfileService profileService=new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName")String profileName){
		return profileService.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")String profileName,Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile deleteProfile(@PathParam("profileName") String profileName){
		return profileService.deleieProfile(profileName);
	}
}
