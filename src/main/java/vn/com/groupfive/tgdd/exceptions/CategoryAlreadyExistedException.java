package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class CategoryAlreadyExistedException extends CrudException {
	public CategoryAlreadyExistedException() {
		super("Category is already existed", HttpStatus.BAD_REQUEST);
	}
	
}
