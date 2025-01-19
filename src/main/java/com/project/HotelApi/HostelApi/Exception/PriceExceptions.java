package com.project.HotelApi.HostelApi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PriceExceptions {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PriceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePriceNotFoundException(PriceNotFoundException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgNotFoundException(MethodArgumentNotValidException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getFieldError().getDefaultMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PriceAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> handlePriceAlreadyExistException(PriceAlreadyExistException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BedNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleBedNotFoundException(BedNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
