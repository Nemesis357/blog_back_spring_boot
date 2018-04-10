package com.nenadniko.service;

import java.util.List;

import com.nenadniko.entity.Message;

public interface MessageService {
	boolean addMessage(Message msg);
	List<Message> getAllMessages();
	Message getByUniqueId(long id);
	boolean deleteMessage(Long id);
	void updateMessage(Message msg);
}
