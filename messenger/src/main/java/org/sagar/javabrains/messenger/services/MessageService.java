package org.sagar.javabrains.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.sagar.javabrains.messenger.database.DatabaseObject;
import org.sagar.javabrains.messenger.model.Message;

public class MessageService {

	private Map<Integer, Message> messages = new DatabaseObject().getMessageMap();

	public MessageService() {
		messages.put(1, new Message(1, "Hello World", "Sagar"));
		messages.put(2, new Message(2, "Hellow java", "Sagar123"));

	}

	public List<Message> getAllMessage() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessageByYear(int year) {
		List<Message> list = new ArrayList<Message>();
		Calendar calendar = Calendar.getInstance();

		for (Message message : messages.values()) {
			calendar.setTime(message.getCreatedDate());
			if (calendar.get(Calendar.YEAR) == year) {
				list.add(message);
			}
		}
		return list;
	}

	public List<Message> getAllMessageStartSize(int start, int size) {
		List<Message> list = new ArrayList<Message>(messages.values());
		if (start+size>list.size()) {
			return list.subList(start-1, list.size()	);
		}
		
		return list.subList(start-1, start + size-1);
	}
	
	

	public Message getMessage(int id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		return messages.replace(message.getId(), message);
	}

	public Message removeMessage(int id) {
		return messages.remove(id);
	}
}
