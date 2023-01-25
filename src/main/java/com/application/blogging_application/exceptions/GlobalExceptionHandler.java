package com.application.blogging_application.exceptions;
import com.application.blogging_application.payloads.APIResponse;
import com.application.blogging_application.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException x){
        String message=x.getMessage();
        return new ResponseEntity<>(new APIResponse(message,false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException y){
        Map<String,String> map=new HashMap<>();
        y.getBindingResult().getAllErrors().forEach(error->{
           String FeildName= ((FieldError)error).getField();
            String Message=(error).getDefaultMessage();
            map.put(FeildName,Message);
        });
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);

    }

}
