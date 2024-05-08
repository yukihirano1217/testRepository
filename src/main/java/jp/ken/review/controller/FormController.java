package jp.ken.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.ken.review.dao.MembershipDao;
import jp.ken.review.model.FormModel;
import jp.ken.review.model.TraineeModel;

@Controller
@SessionAttributes({"loginModel", "formModel", "traineeModel"})

public class FormController {
	@Autowired
	private MembershipDao membershipDao;

	@ModelAttribute("traineeModel")
	public TraineeModel setTraineeModel() {
		return new TraineeModel();
	}

	@ModelAttribute("formModel")
	public FormModel setFormModel() {
		return new FormModel();
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String toForm() {
		return "/form";
	}

	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String answer(@ModelAttribute FormModel formModel) {
		membershipDao.insert(formModel);

		return "/complete";
	}
}
