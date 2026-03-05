package com.example.demo.exception;

import java.time.LocalDateTime;

public class ResponseError {
	
	private String message;
	private String description;
	private LocalDateTime time;
	public ResponseError(String message, String description) {
		super();
		this.message = message;
		this.description = description;
		this.time = LocalDateTime.now();
		
	}
	@Override
	public String toString() {
		return "ResponseError [message=" + message + ", description=" + description + ", time=" + time + "]";
	}
	
	

}
