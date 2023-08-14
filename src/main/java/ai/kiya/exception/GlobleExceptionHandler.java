package ai.kiya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobleExceptionHandler {
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex){
		String message=ex.getMessage();
	    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
