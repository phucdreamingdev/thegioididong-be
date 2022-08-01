package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class MemberDoesNotExistedException extends CrudException{
	public MemberDoesNotExistedException() {
		super("Member does not existed", HttpStatus.BAD_REQUEST);
	}
}
