package fr.webatrio.demo.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		log.error(ex.getMessage());

		// Create and return a custom error response
		ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(errorResponse, INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DomainException.class)
	public ResponseEntity<ErrorResponse> handleDomainException(DomainException ex) {
		log.error(ex.getMessage());

		// Create and return a custom error response
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getCode().value());

		return new ResponseEntity<>(errorResponse, ex.getCode());
	}
}
