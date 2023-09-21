package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class error{

@ExceptionHandler(value=NoSuchCommandException.class)
@ResponseStatus(value = HttpStatus.CONFLICT)
public ErrorResponse handleCustomerAlreadyExistsException(
		NoSuchCommandException ex)
{
	return new ErrorResponse(HttpStatus.CONFLICT.value(),
							ex.getMessage());
}

}