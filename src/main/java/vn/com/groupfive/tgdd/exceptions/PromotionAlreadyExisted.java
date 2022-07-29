package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class PromotionAlreadyExisted extends CrudException {
	public PromotionAlreadyExisted() {
		super("Promotion is already existed", HttpStatus.BAD_REQUEST);
	}
}
