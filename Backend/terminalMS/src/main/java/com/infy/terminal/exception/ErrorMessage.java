package com.infy.terminal.exception;

public class ErrorMessage {
	private Integer StatusCode;
	private String message;
	private String url;
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(Integer statusCode) {
		StatusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
