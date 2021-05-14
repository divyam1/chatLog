package com.demo.chatlog.requestResponse;

public class CreateLogResponse extends GenericResponse {
	private String messageId;
	
	
	public static GenericResponse getSuccess(String reason,String messageId) {
		CreateLogResponse gr = new CreateLogResponse();
		gr.setMessageId(messageId);
		gr.setMessage(reason);
		gr.setStatus(RequestStatus.SUCCESS.toString());
		return gr;
		
	}


	public String getMessageId() {
		return messageId;
	}


	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
}
