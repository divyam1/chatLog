package com.demo.chatlog.controller;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.chatlog.requestResponse.CreateLogRequest;
import com.demo.chatlog.requestResponse.GenericResponse;
import com.demo.chatlog.service.ChatLogService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ChatLogController {
		
		@Autowired
		ChatLogService chatlogService;
		
		private static Logger logger = Logger.getLogger(ChatLogController.class.getName());

		
		@PostMapping("v1/chatlogs/{user_id}")
		String createChatlog(@PathVariable("user_id")String userId, 
				@RequestBody String requestBody){
			logger.info("create chatlog request:   --> "+requestBody);
			ObjectMapper mapper = new ObjectMapper();

			try {
				CreateLogRequest request = mapper.readValue(requestBody, CreateLogRequest.class);
				return chatlogService.createChatLog(userId, request);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return  GenericResponse.getFailure("Invalid data input").toJson();
			
		}

		@GetMapping("v1/chatlogs/{user_id}")
		String getChatlogOfUser(@PathVariable("user_id")String userId,
				@RequestParam(name="start") String start, @RequestParam(name="limit") int limit){
			logger.info("GET log request:   userId::  "+userId);
			return chatlogService.getChatlogOfUser(userId, start, limit);
		}
		
		@DeleteMapping("v1/chatlogs/{user_id}/{message_id}")
		String deleteChatlog(@PathVariable("user_id")String userId, 
				@PathVariable("message_id")String messageId){
			logger.info("Delete message log request :: userId ::  "+userId +" :: message ::  "+messageId);
			return chatlogService.deleteChatlog(userId, messageId);
			
		}
		
		@DeleteMapping("v1/chatlogs/{user_id}")
		String deleteChatlogsOfUser(@PathVariable("user_id")String userId){
			logger.info("Delete user logs request :: userId ::  "+userId);

			return chatlogService.deleteChatlogsOfUser(userId);
		}
		
	}