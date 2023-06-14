package com.caps.app.ws.model.response;

import java.util.Date;

public class ErrorMessage {
	private Date time;
	private String message;
	
	public ErrorMessage() {}
	
	public ErrorMessage(Date time, String message) {
		super();
		this.time = time;
		this.message = message;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
