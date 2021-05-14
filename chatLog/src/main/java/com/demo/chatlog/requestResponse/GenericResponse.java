package com.demo.chatlog.requestResponse;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericResponse {
	private String status;
	private String message;
	
	public static GenericResponse getFailure(String reason) {
		
		GenericResponse gr = new GenericResponse();
		gr.setMessage(reason);
		gr.setStatus(RequestStatus.FAILURE.toString());
		return gr;
	}
	
	public static GenericResponse getSuccess(String reason) {
		GenericResponse gr = new GenericResponse();
		gr.setMessage(reason);
		gr.setStatus(RequestStatus.SUCCESS.toString());
		return gr;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.setSerializationInclusion(Include.NON_NULL);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
}
}
