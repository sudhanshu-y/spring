package com.sudhanshu.mapping.restmapping.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class) // to handle all exceptions --> 500 Internal Server Error
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErrorStructureDetail errorStructureDetail = new ErrorStructureDetail(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorStructureDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class) // to handle use not found exceptions --> 400 Client Exception
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorStructureDetail errorStructureDetail = new ErrorStructureDetail(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorStructureDetail, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorStructureDetail errorStructureDetail = new ErrorStructureDetail(LocalDateTime.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorStructureDetail, HttpStatus.BAD_REQUEST);
	}

}
