package com.abastecimento.rest.controller;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.abastecimento.expection.NotFoundException;
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
	

}
