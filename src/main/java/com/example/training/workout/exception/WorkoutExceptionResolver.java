package com.example.training.workout.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WorkoutExceptionResolver extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class, IllegalArgumentException.class, IllegalStateException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
//		String bodyOfResponse = "This should be application specific";
//		return handleExceptionInternal(ex, bodyOfResponse+"--"+ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());
//		error.callerURL(request.get);

		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
