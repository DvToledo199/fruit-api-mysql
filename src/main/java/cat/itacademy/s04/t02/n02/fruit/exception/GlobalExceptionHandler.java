package cat.itacademy.s04.t02.n02.fruit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProviderNotFoundException.class)
    public ResponseEntity<String> handleProviderNotFoundException(ProviderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProviderAlreadyExistsException.class)
    public ResponseEntity<String> handleProviderAlreadyExistsException(ProviderAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ProviderHasFruitsException.class)
    public ResponseEntity<String> handleProviderHasFruitsException(ProviderHasFruitsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldError() != null
                ? ex.getBindingResult().getFieldError().getDefaultMessage()
                : "Validation error";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
