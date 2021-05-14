package com.demo.chatlog;

public class Message {
	private String messageId;
	private Boolean isSent;
	private String message;
	private Long timeStamp;
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Boolean getIsSent() {
		return isSent;
	}
	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}
}
