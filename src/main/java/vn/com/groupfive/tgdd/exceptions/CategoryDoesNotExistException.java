package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class CategoryDoesNotExistException extends CrudException {
	public CategoryDoesNotExistException() {
		super("Category does not exist", HttpStatus.BAD_REQUEST);
	}
	
}