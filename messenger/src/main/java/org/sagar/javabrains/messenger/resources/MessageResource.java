package org.sagar.javabrains.messenger.resources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.sagar.javabrains.messenger.model.Message;
import org.sagar.javabrains.messenger.model.beans.MessageFilterBean;
import org.sagar.javabrains.messenger.services.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	static MessageService messageSrivce = new MessageService();

	@GET
	public List<Message> getMessagges(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageSrivce.getAllMessageByYear(filterBean.getYear());
		}
		if (filterBean.getStart() > 0 && filterBean.getSize() > 0) {
			return messageSrivce.getAllMessageStartSize(filterBean.getStart(), filterBean.getSize());
		}
		return messageSrivce.getAllMessage();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") int id) {
		// TODO Auto-generated method stub
		return messageSrivce.getMessage(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage(Message message) {
		return messageSrivce.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") int id, Message message) {
		message.setId(id);
		return messageSrivce.updateMessage(message);

	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") int id) {
		messageSrivce.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}/comments/")
	public CommentResource getComment(){
		return new CommentResource();
	}
	
	@GET
	@Path("/{messageId}/comments")
	public CommentResource getAllComments(){
		return new CommentResource();
	}
	
	@POST
	@Path("/{messageId}/comments")
	public CommentResource addComment(){
		return new CommentResource();
	}
	
	@PUT
	@Path("/{messageId}/comments")
	public CommentResource updateComment(){
		return new CommentResource();
	}
	
	
	@DELETE
	@Path("/{messageId}/comments")
	public CommentResource deleteComment(){
		return new CommentResource();
	}
	
}
