package com.sampana.cms.dto.apivalidation;


import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sampana.cms.dto.ResponseDTO;
/**
 * 
 * This handler is uses for handle error messaging to the rest hit api.  
 * @author Sudhanshu Chaturvedi
 *
 */
@ControllerAdvice
public class ApiValidationHandler extends ResponseEntityExceptionHandler {
	
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status,WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ApiFieldError> apiFieldErrors = bindingResult
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ApiFieldError(fieldError.getField(),fieldError.getDefaultMessage()))
                .collect(toList());
       /* List<ApiGlobalError> apiGlobalErrors = bindingResult
                .getGlobalErrors()
                .stream()
                .map(globalError -> new ApiGlobalError(
                        globalError.getCode())
                )
                .collect(toList());*/
        ResponseDTO responseDTO = new ResponseDTO(HttpStatus.UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY.value(),apiFieldErrors, "Some properties are invalid or missing.");
        return new ResponseEntity<>(responseDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
