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
import com.demo.chatlog.requestResponse.GenericResponse;
import com.demo.chatlog.requestResponse.GetLogResponse;

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
		ChatLog log = chatLogRepo.findByUserId(userId);
	    List<Message> messages = log!=null?log.getMessages():null;
	    if(limit<messages.size())
	    		messages.subList(0, limit);
	    return GetLogResponse.getSuccess("Logs found",messages).toJson();
	}

	public String deleteChatlog(String userId, String messageId) {
		// TODO Auto-generated method stub
		ChatLog log = chatLogRepo.findByUserId(userId);
		if(log==null)
				GenericResponse.getFailure("No user found").toJson();
		List<Message> list = log.getMessages();
		for(Message msg: list) {
				if(msg.getMessageId().equals(messageId)) {
						list.remove(msg);
						chatLogRepo.save(log);
						return GenericResponse.getSuccess("Deletion Done").toJson();
				}
		}
		
		return GenericResponse.getFailure("Message Not Found").toJson();
	}

	public String deleteChatlogsOfUser(String userId) {
		// TODO Auto-generated method stub
		ChatLog log = chatLogRepo.findByUserId(userId);
		if(log==null)
				return GenericResponse.getFailure("No user found").toJson();
		chatLogRepo.delete(log);
		return GenericResponse.getSuccess("Deletion Done").toJson();
	}

}
