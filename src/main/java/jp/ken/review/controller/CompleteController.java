package jp.ken.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class CompleteController {

	@RequestMapping(value="/complete2", method=RequestMethod.GET)
	public String toComplete2() {
		return "/complete2";
	}

	@RequestMapping(value="/complete2", method=RequestMethod.POST)
	public String toLogin() {
		return "redirect:/login";
	}
}
