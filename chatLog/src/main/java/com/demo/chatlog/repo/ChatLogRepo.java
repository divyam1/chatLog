package com.demo.chatlog.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.chatlog.entity.ChatLog;

@Repository
public interface ChatLogRepo extends MongoRepository<ChatLog, String> {
	
	ChatLog findByUserId(String id);
	
}
