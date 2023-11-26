package fr.webatrio.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DomainException extends Exception {

	private static final long serialVersionUID = 1634277697344443753L;

	private final String message;

	private final HttpStatus code;
}
