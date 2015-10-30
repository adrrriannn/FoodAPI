package com.london.food.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.london.food.response.Response;

public class ParentController {
	
	   protected String buildResponse(Boolean success, String content) {
	        Response r = new Response();
	        r.setSuccess(success);
	        r.setContent(content);
	        ObjectMapper mapper = new ObjectMapper();
	        try {
	            return mapper.writeValueAsString(r);
	        } catch (JsonProcessingException e) {
	            return "Error creating response";
	        }
	    }

}
