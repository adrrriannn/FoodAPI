package com.london.food.controller;

import com.london.food.response.Response;

public class ParentController {

	protected Response buildResponse(Boolean success, String content) {
		Response r = new Response();
		r.setSuccess(success);
		r.setContent(content);
		return r;
	}
}
