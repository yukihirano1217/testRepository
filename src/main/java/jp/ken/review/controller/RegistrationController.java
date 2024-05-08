package jp.ken.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.review.dao.MembershipDao;
import jp.ken.review.entity.Trainee;
import jp.ken.review.model.TraineeModel;

@Controller
public class RegistrationController {


	@Autowired
	private MembershipDao membershipDao;

	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String toRegist1(Model model) {
		model.addAttribute("traineeModel", new TraineeModel());
		return "/registration";
	}

	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String toRegist2(@ModelAttribute TraineeModel traineeModel, @ModelAttribute Trainee trainee, Model model) {
		trainee.setTraineeName(traineeModel.getName());
		trainee.setPasswaord(traineeModel.getPassword());
		trainee.setCompanyName(traineeModel.getCompanyName());
		membershipDao.insert(trainee);

		return "/complete2";
	}

}
