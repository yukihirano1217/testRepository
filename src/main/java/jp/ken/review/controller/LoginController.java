package jp.ken.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.ken.review.dao.MembershipDao;
import jp.ken.review.entity.Trainee;
import jp.ken.review.model.LoginModel;

@Controller
@SessionAttributes("loginModel")
public class LoginController {
	@Autowired
	private MembershipDao membershipDao;

	@ModelAttribute("loginModel")
	public LoginModel setLoginModel() {
		return new LoginModel();
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String toLogin1() {
		return "/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String toLogin2(@ModelAttribute LoginModel loginModel, Model model) {
		Trainee trainee = membershipDao.loginCheck(loginModel);
		if(trainee != null) {
			return "redirect:/form";
		}else {
			return "login";
		}

	}

}
