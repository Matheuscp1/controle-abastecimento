package com.abastecimento.rest.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.abastecimento.expection.NotFoundException;
import com.abastecimento.expection.ValidateSupplyMileageExpection;
import com.abastecimento.rest.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	    @ExceptionHandler(NotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public ApiErrors handlePedidoNotFoundException( NotFoundException ex ){
	        return new ApiErrors(ex.getMessage());
	    }
	    
	    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ApiErrors handleInvalidDataAccessResourceUsageException( InvalidDataAccessResourceUsageException ex ){
	        return new ApiErrors(ex.getMessage());
	    }
	    
	    @ExceptionHandler(ValidateSupplyMileageExpection.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ApiErrors handleValidateSupplyMileageExpection( ValidateSupplyMileageExpection ex ){
	        return new ApiErrors(ex.getMessage());
	    }
	
	    
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ApiErrors handleMethodNotValidException( MethodArgumentNotValidException ex ){
	        List<String> errors = ex.getBindingResult().getAllErrors()
	                .stream()
	                .map(erro -> erro.getDefaultMessage())
	                .collect(Collectors.toList());
	        return new ApiErrors(errors);
	    }
}
