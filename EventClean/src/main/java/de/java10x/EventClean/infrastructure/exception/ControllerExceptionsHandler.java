package de.java10x.EventClean.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventException(DuplicateEventException message){

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", message.getMessage());
        response.put("Message: ", "Please, insert a valid hashId for your event and try again");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    };


    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundEventException message){

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", message.getMessage());
        response.put("Message: ", "The request event was not found, check the identifier and try again");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    };


}
