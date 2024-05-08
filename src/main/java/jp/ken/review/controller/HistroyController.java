package jp.ken.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.ken.review.dao.MembershipDao;
import jp.ken.review.entity.Trainee;
import jp.ken.review.model.FormModel;
import jp.ken.review.model.HistoryModel;
import jp.ken.review.model.LoginModel;

@Controller
@SessionAttributes({"loginModel", "formModel"})
public class HistroyController {

	@Autowired
	private MembershipDao membershipDao;

	@ModelAttribute("loginModel")
	public LoginModel setLoginModel() {
		return new LoginModel();
	}

	@RequestMapping(value="/history", method=RequestMethod.GET)
	public String toHistroy1(@ModelAttribute LoginModel loginModel,Model model) {
		model.addAttribute("historyModel", new HistoryModel());
		
		List<Trainee> list = null;
		membershipDao.checkAccount(loginModel);
		
		
		List<FormModel> formList = membershipDao.getFormHistroyByName(loginModel);
		model.addAttribute("formList", formList);
		return "/personalHistory";
	}

	@RequestMapping(value="/history", method=RequestMethod.POST)
	public String toHistory2(@ModelAttribute HistoryModel historyModel, @ModelAttribute FormModel formModel,
			@ModelAttribute LoginModel loginModel, Model model) {

		String date = historyModel.getDate();
		String contents = historyModel.getContents();
		String comprehensionLevel = historyModel.getComprehensionLevel();
		List<FormModel> formList = null;
		if(!date.isEmpty() && !contents.isEmpty()) {
			formList = membershipDao.getFormHistroyBy1(historyModel);
		}else if(!date.isEmpty() && !contents.isEmpty()) {
			formList = membershipDao.getFormHistroyBy2(historyModel);
		}else if(!date.isEmpty() && !comprehensionLevel.isEmpty()) {
			formList = membershipDao.getFormHistroyBy3(historyModel);
		}else if(!date.isEmpty()) {
			formList = membershipDao.getFormHistroyBy4(historyModel);
		}else if(!contents.isEmpty() && !comprehensionLevel.isEmpty()) {
			formList = membershipDao.getFormHistroyBy4(historyModel);
		}else {
			return "/form";
		}
		model.addAttribute("formList", formList);
		return "/personalHistory";
	}


}
