package com.rutac.Validation;

import java.util.ArrayList;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rutac.Models.Error;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ArrayList<Error> errores = new ArrayList<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			Error err = new Error();
			err.setField(((FieldError) error).getField());
			err.setMessage(error.getDefaultMessage());
			errores.add(err);

		});
		return new ResponseEntity<Object>(errores, HttpStatus.PARTIAL_CONTENT);
	}

}
