package com.bigo.whattypeofdev.global.exception;

import com.bigo.whattypeofdev.global.common.ErrorResponse;
import com.bigo.whattypeofdev.global.common.ErrorStatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
    * @Validated로 binding error 발생할때.
    * */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValid(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = ErrorResponse.of(ErrorStatusEnum.BAD_REQUEST,e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity noHandlerFoundException(NoHandlerFoundException e) {
        ErrorResponse errorResponse = ErrorResponse.of(ErrorStatusEnum.BAD_REQUEST,e.getClass().getName());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity customException(CustomException e) {
        ErrorStatusEnum errorStatusEnum = e.getErrorStatusEnum();
        ErrorResponse errorResponse = ErrorResponse.of(e.getErrorStatusEnum(),e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorStatusEnum.getCode()));
    }

}
