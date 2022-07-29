package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class MemberAlreadyExistedException extends CrudException{
	public MemberAlreadyExistedException() {
		super("Member is already existed", HttpStatus.BAD_REQUEST);
	}
}
