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

import org.sagar.javabrains.messenger.model.Comment;
import org.sagar.javabrains.messenger.services.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	static private CommentService commentService=new CommentService();
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") int messageId ,@PathParam("commentId") int commentId){
		return commentService.getComment(messageId, commentId);
	}
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") int messageId){
		return commentService.getAllComments(messageId);
	}	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment addComment(@PathParam("messageId") int messageId, Comment comment){
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("commentId") int commentId, @PathParam("messageId") int messageId, Comment comment){
		return commentService.updateComment(messageId, commentId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("commentId") int commentId, @PathParam("messageId") int messageId){
		return commentService.removeComment(messageId, commentId);
	}
	
	
}
