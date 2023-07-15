package com.springboot.timeproject.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TimeExceptionHandler {
	
	@ExceptionHandler(value = {TimeException.class})
	public ResponseEntity<Object> handleTimeRequestException(TimeException e){
		HttpStatus badStatus = HttpStatus.BAD_REQUEST;
		TimeExceptionEntity exceptionEntity=new TimeExceptionEntity(
				e.getMessage(),
				e,
				badStatus,
				ZonedDateTime.now());
		
		return new ResponseEntity<>(exceptionEntity, badStatus);
	}
}
