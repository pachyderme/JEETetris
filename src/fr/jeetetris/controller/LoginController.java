package fr.jeetetris.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.jeetetris.models.User;

@Controller 
public class LoginController { 
	
	@RequestMapping("/login") 
	public String login(Model model) { 
		return "login";
	}
	
	@RequestMapping(value = "/connect" , method = RequestMethod.POST) 
	public String connect(Model model, HttpSession session, HttpServletRequest request) { 
		
		String result = "login";
		
		if(request.getServletContext().getAttribute("users") != null) {
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) request.getServletContext().getAttribute("users");
			for(User u : users) {
				if(u.getIdentifier().equals(request.getParameter("identifier")) && u.getPassword().equals(request.getParameter("password"))) {
					session.setAttribute("user", u);
					result = "redirect:/home";
				}else
				{
					model.addAttribute("msg", "Echec de la connexion");
				}
			}
		}
		
		return result;
	}
}
