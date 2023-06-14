package com.caps.app.ws.model.exception;

import java.util.Date;

import com.caps.app.ws.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {StudentServiceException.class})
	public ResponseEntity<Object> handleUserServiceException(StudentServiceException ex, WebRequest request) {
		String messageDescription = ex.getLocalizedMessage();
		if (messageDescription == null) messageDescription = ex.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), messageDescription);
		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
