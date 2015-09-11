package unimelb.edu.au.kumart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.domainLogic.AdminDL;

@Controller
public class AdminController {

	@Autowired
	private AdminDL adminDL;
	
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request) {
		if(request.getSession().getAttribute("username") != "") return new ModelAndView("redirect:/index");
		return new ModelAndView("/login_admin");
		
	}
	
	@RequestMapping(value ="/loginCheck",method=RequestMethod.GET)
	public ModelAndView loginCheck(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(adminDL.login(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			return new ModelAndView("redirect:/index");
		}
		else {
			return new ModelAndView("login_admin", "error", "Invalid username or password!");
		}
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().setAttribute("username", "");
		return new ModelAndView("redirect:/login"); 
	}
	
}
