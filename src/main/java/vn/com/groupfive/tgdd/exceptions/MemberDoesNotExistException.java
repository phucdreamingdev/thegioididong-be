package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class MemberDoesNotExistException extends CrudException {
	public MemberDoesNotExistException() {
		super("Member does not exist", HttpStatus.BAD_REQUEST);
	}
	
}