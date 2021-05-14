package com.demo.chatlog.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.chatlog.entity.ChatLog;
import com.demo.chatlog.entity.Message;
import com.demo.chatlog.repo.ChatLogRepo;
import com.demo.chatlog.requestResponse.CreateLogRequest;
import com.demo.chatlog.requestResponse.CreateLogResponse;

@Service
public class ChatLogService {

	@Autowired
	ChatLogRepo chatLogRepo;
	public String createChatLog(String userId,CreateLogRequest request) {
		// TODO Auto-generated method stub
		ChatLog log = chatLogRepo.findByUserId(userId);
		List<Message> list = log!=null?log.getMessages():null;
		if(list==null)
			list = new ArrayList<Message>();
		
		String messageId = userId+"_"+(list.size()+1);
		Message msg = new Message(messageId,request.isSent,request.message,request.timeStamp);
		list.add(msg);
		if(log==null) {
			log = new ChatLog();
			log.setUserId(userId);
			log.setMessages(list);
		}
		chatLogRepo.save(log);
		return CreateLogResponse.getSuccess("Log Saved Succesfully",messageId).toJson();
	}

	public String getChatlogOfUser(String userId, String start, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteChatlog(String userId, String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteChatlogsOfUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
