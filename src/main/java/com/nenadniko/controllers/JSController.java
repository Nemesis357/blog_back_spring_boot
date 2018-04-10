package com.nenadniko.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nenadniko.entity.Message;
import com.nenadniko.service.MessageServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class JSController {
	@Autowired
	MessageServiceImpl msgService;
	
	@PostMapping("/addMessage")
	public Message addMessage(@RequestBody Message msg) {
		msgService.addMessage(msg);
		return msg;
	}
	
	@GetMapping("/getMessages")
	public List<Message> getMessages() {
		List<Message> messages = msgService.getAllMessages();
		return messages;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMessage(@PathVariable("id") Long id) {
		if(msgService.deleteMessage(id))
			return new ResponseEntity<Object>("Successfully deleted - ", HttpStatus.OK);
		return new ResponseEntity<Object>("Error - ", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
	public Message updateMessage(@PathVariable Long id, @RequestBody Message msg) {
		if(msgService.getByUniqueId(id) != null) 
			msg.setId(id);
			msgService.updateMessage(msg);
		return msg;
	}
}
