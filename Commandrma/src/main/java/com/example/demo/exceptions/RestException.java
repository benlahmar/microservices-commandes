package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestException {

	@ExceptionHandler(value= NoSuchCommandException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody ErrorResponse
	handleException(NoSuchCommandException ex)
	{
		return new ErrorResponse(
			HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	
}
