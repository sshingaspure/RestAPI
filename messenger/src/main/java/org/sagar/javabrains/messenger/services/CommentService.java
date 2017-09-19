package org.sagar.javabrains.messenger.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sagar.javabrains.messenger.model.Comment;
import org.sagar.javabrains.messenger.model.Message;

public class CommentService {

	private Map<Integer, Message> messages = new HashMap<Integer, Message>();

	public Comment getComment(int messageId, int commentId) {
		return messages.get(messageId).getComments().get(commentId);
	}

	public List<Comment> getAllComments(int messageId) {
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}

	public Comment addComment(int messageId,Comment comment){
		Message message=messages.get(messageId);
		message.getComments().put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(int messageId,int commentId, Comment comment){
		Message message=messages.get(messageId);
		comment.setId(commentId);
		return message.getComments().replace(commentId, comment);
	}
}
