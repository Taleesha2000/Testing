package springboot.Testing.pos.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springboot.Testing.pos.exception.NotFoundException;
import springboot.Testing.pos.util.StandardResponse;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        404,
                        "Not Found",
                        ex.getMessage()

                ),
                HttpStatus.CREATED
        );
    }

}
