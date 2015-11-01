package com.london.food.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.london.food.response.ErrorResponse;
import com.london.food.response.Response;

@RestController
public class ErrorControllerImpl implements ErrorController {
	
	private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    @ExceptionHandler(value = {Exception.class})
    public Response error(Exception e, HttpServletRequest request) {
        String message = e.getCause() != null? e.getCause().getMessage() : "There was an error while processing the request.";
        return new ErrorResponse(Boolean.FALSE, message);
    }
}
