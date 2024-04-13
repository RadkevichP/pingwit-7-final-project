package pl.pingwit.pingwitcarrental.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class CarRentExceptionHandler {

    @ExceptionHandler(CarRentNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(CarRentNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(CarRentValidationException.class)
    public ResponseEntity<String> handleValidationException(CarRentValidationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }
}
