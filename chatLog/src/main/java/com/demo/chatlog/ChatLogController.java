package com.demo.chatlog;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChatLogController {
		
		@Autowired
		ChatLogService chatlogService;
		
		private static Logger logger = Logger.getLogger(ChatLogController.class.getName());

		
		@PostMapping("v1/chatlogs/{user_id}")
		String createChatlog(@PathVariable("user_id")String userId, 
				@RequestBody Map<String, Object> requestBody){
			
			return chatlogService.createChatLog(userId, requestBody);
		}

		@GetMapping("v1/chatlogs/{user_id}")
		String getChatlogOfUser(@PathVariable("user_id")String userId,
				@RequestParam(name="page") int page, @RequestParam(name="size") int size){
			
			return chatlogService.getChatlogOfUser(userId, page, size);
		}
		
		@DeleteMapping("v1/chatlogs/{user_id}/{message_id}")
		String deleteChatlog(@PathVariable("user_id")String userId, 
				@PathVariable("message_id")String messageId){
			
			return chatlogService.deleteChatlog(userId, messageId);
			
		}
		
		@DeleteMapping("v1/chatlogs/{user_id}")
		String deleteChatlogsOfUser(@PathVariable("user_id")String userId){
			
			return chatlogService.deleteChatlogsOfUser(userId);
		}
		
	}