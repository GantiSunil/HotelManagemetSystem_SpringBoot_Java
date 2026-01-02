package com.sunil.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {
	
	private LocalDateTime localDateTime;
	
	private String error;
	
	private int status;
	
	private String message;
	
	private String path;
	
	
	

	public ErrorResponse(LocalDateTime localDateTime, String error, int status, String message, String path) {
		super();
		this.localDateTime = localDateTime;
		this.error = error;
		this.status = status;
		this.message = message;
		this.path = path;
	}
	

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
	

}
