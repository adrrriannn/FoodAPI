package com.london.food.response;

public class Response {
	
	protected Boolean success = false;
	
	public Response(){}
	
	public Response(Boolean success){
		this.success = success;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
