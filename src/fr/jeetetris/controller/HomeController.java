package fr.jeetetris.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.Tetrimino;

@Controller 
public class HomeController { 
	@Autowired
	private IDAO<Tetrimino> tetriminoDAO;
	
	@Autowired
	ServletContext context; 
	
	@RequestMapping("/home") 
	public String home(Model model, HttpSession session) { 
		model.addAttribute("tetrimino", new Tetrimino());
		
		context.setAttribute("tetriminos", tetriminoDAO.findAll());
		return "home";
	}

	@RequestMapping(value = "/addTetrimino" , method = RequestMethod.POST)
	public String addTetrimino(@ModelAttribute("tetrimino") Tetrimino tetrimino, BindingResult bResult, Model model, HttpServletRequest request) {
		tetriminoDAO.save(new Tetrimino(tetrimino.getColor(), tetrimino.getName()));
		
		return "redirect:/home";
	}

	@RequestMapping(value = "/deleteTetrimino" , method = RequestMethod.POST)
	public String deleteTetrimino(@ModelAttribute("tetrimino") Tetrimino tetrimino, Model model, HttpServletRequest request) {
		tetriminoDAO.delete(tetriminoDAO.find(tetrimino.getId()));
		
		return "redirect:/home";
	}
}
