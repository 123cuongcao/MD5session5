package ra.academy.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.academy.exception.NoIdException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler( value = NoSuchElementException.class)
    public ResponseEntity<String> handlerGetAuthor(NoSuchElementException e){
        return new ResponseEntity<>("không tìm thấy tối tượng", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NoIdException.class)
    public  ResponseEntity<String> handleDeleteBook(NoIdException e){
        return  new ResponseEntity<>("kotim thay61 doi619 tuong75",HttpStatus.BAD_REQUEST);
    }
}
