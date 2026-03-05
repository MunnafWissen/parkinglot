package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HandleGlobalException {

	@ExceptionHandler(ParkingSpotNotFoundException.class)
	public ResponseError handleParkingSpotNotFoundException(ParkingSpotNotFoundException e, WebRequest request) {
		return new ResponseError(
				e.getMessage(),
				request.getDescription(false)
				);
	}
	
}
