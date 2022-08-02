package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class MemberOrderDoesNotExistedException extends CrudException{
	public MemberOrderDoesNotExistedException() {
		super("Member Order does not existed", HttpStatus.BAD_REQUEST);
	}
}
