package fr.jeetetris.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.jeetetris.dao.IUserDAO;
import fr.jeetetris.models.User;

@Controller 
public class LoginController { 

	@Autowired
	private IUserDAO userDAO;

	@RequestMapping("/login") 
	public String login(Model model) { 
		return "login";
	}

	@RequestMapping(value = "/connect" , method = RequestMethod.POST) 
	public String connect(@ModelAttribute("user") User user, BindingResult bResult, Model model, HttpSession session, HttpServletRequest request) { 

		String result = "redirect:/login";

		user = userDAO.findByIdentifier(user.getIdentifier(), user.getPassword());
		if(user != null) {
			session.setAttribute("user", user);
			result = "redirect:/home";
		}else
		{
			model.addAttribute("msg", "Echec de la connexion");
		}

		return result;
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session, HttpServletRequest request) {
		session.setAttribute("user", null);
		return "login";
	}
}
