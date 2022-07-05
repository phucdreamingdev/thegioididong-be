package vn.com.groupfive.tgdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.services.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
}
