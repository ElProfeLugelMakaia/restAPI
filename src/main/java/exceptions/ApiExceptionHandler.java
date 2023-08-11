package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice()
public class ApiExceptionHandler {
    @ExceptionHandler(value = ApiRequestExeption.class)
    public  ResponseEntity<ApiException> handleNotValueExeption(){
        ApiException exception = new ApiException(HttpStatus.NOT_FOUND.value(), "No encontró el elemento");
        return new ResponseEntity<ApiException>(exception, HttpStatus.NOT_FOUND);
    }
}
