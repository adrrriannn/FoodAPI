package com.london.food.response;

public class ErrorResponse extends Response{
	
	private String content = "";
	
	public ErrorResponse(){}
	
	public ErrorResponse(Boolean success, String content){
		super(success);
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResponse other = (ErrorResponse) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		}else if(success == null){
			if(other.success != null)
				return false;			
		} else if (!content.equals(other.content)){
			return false;
		}else if(!success.equals(other.success))
			return false;
		return true;
	}
	
	
}
