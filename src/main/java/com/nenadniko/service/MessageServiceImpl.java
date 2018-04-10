package com.nenadniko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nenadniko.entity.Message;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageRepo msgRepo;
	
	@Override
	public boolean addMessage(Message msg) {
		msgRepo.save(msg);
		return true;
	}

	@Override
	public List<Message> getAllMessages() {
		List<Message> messages = msgRepo.findAll();
		return messages;
	}

	@Override
	public Message getByUniqueId(long id) {
		if(msgRepo.findById(id) != null) {
			return msgRepo.getOne(id);
		}
		return null;
	}
	
	@Override
	public boolean deleteMessage(Long id) {
		if(msgRepo.findById(id) != null) {
			msgRepo.deleteById(id);
			return  true;
		}
		return false;
	}

	@Override
	public void updateMessage(Message msg) {
		msgRepo.save(msg);
	}
	
}
