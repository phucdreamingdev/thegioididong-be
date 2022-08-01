package vn.com.groupfive.tgdd.exceptions;

import org.springframework.http.HttpStatus;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;

public class PromotionDoesNotExist extends CrudException {
	public PromotionDoesNotExist() {
		super("Promotion does not exist", HttpStatus.BAD_REQUEST);
	}
}
