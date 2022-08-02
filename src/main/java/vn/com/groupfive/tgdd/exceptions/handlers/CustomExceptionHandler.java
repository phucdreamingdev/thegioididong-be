package vn.com.groupfive.tgdd.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import vn.com.groupfive.tgdd.exceptions.CategoryAlreadyExistedException;
import vn.com.groupfive.tgdd.exceptions.MemberAlreadyExistedException;
import vn.com.groupfive.tgdd.exceptions.MemberDoesNotExistedException;
import vn.com.groupfive.tgdd.exceptions.MemberOrderDoesNotExistedException;
import vn.com.groupfive.tgdd.exceptions.PromotionAlreadyExisted;
import vn.com.groupfive.tgdd.exceptions.PromotionDoesNotExist;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value = {
		CategoryAlreadyExistedException.class,
		MemberAlreadyExistedException.class,
		CategoryAlreadyExistedException.class,
		PromotionAlreadyExisted.class,
		PromotionDoesNotExist.class,
		MemberDoesNotExistedException.class,
		MemberOrderDoesNotExistedException.class
	})
	protected ResponseEntity<Response> handleAuthExceptions(CrudException exception) {
		return ResponseEntity
				.status(exception.getStatus())
				.body(new Response("Error", exception.getMessage()));
	}
	
}
