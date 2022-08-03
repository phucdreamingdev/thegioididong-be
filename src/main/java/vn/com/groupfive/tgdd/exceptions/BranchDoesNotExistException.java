package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class BranchDoesNotExistException extends CrudException {
	public BranchDoesNotExistException() {
		super("Branch does not exist", HttpStatus.BAD_REQUEST);
	}
	
}