package com.demo.chatlog.requestResponse;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateLogRequest {
	public String message;
	public Long timeStamp;
	public Boolean isSent;

}
