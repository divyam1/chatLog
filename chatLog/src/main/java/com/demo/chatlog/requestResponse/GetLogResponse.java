package com.demo.chatlog.requestResponse;

import java.util.List;

import com.demo.chatlog.entity.Message;

public class GetLogResponse extends GenericResponse {
	private List<Message> messages;
	
	
	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	public static GenericResponse getSuccess(String reason,List<Message> messages) {
		GetLogResponse gr = new GetLogResponse();
		gr.setMessages(messages);
		gr.setMessage(reason);
		gr.setStatus(RequestStatus.SUCCESS.toString());
		return gr;
	}


	
}
