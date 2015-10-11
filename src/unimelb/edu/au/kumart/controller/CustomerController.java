package unimelb.edu.au.kumart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.domainLogic.CustomerDL;
import unimelb.edu.au.kumart.entity.Customer;

@Controller
public class CustomerController {

	@Autowired
	CustomerDL customerDL = new CustomerDL();
	
	@RequestMapping("login")
	public ModelAndView LoginInterceptor(HttpServletRequest request) {
		if(!(request.getSession().getAttribute("customer") == null) && request.getSession().getAttribute("customer") != "") {
		return new ModelAndView("/customer/index_cus");
		}
		return new ModelAndView("/customer/login");
	}
	/**
	 * get username and password from the user interface and pass these two parameters to next layer
	 * and check if the username and password pair is valid.
	 * If it is valid, redirect to index page; if not, return error message.
	 * @param request
	 * @return if username and password pair is valid, return indext page, otherwise stay in login page.
	 */
	@RequestMapping(value ="/loginCheck",method=RequestMethod.GET)
	public ModelAndView loginCheck(HttpServletRequest request) {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		if(customerDL.login(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", username);
			return new ModelAndView("redirect:/index");
		}
		else {
			request.setAttribute("error", "Invalid username or password!");
			return new ModelAndView("redirect:/index");
		}
	}
	
	/**
	 * customer register
	 * @return register page
	 */
	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("/customer/register");
	}
	
	/**
	 * if the username has been used, return an error; if not, store this customer into the database and login.
	 * @param request
	 * @param customer
	 * @return if the customer is valid, to index; if not, to register page.
	 */
	@RequestMapping(value = "/registerCheck", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, Customer customer) {
		System.out.println(customer.getEmail());
		if(customerDL.register(customer)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer.getEmail());
			return new ModelAndView("redirect:/index");			
		}
		else {
			request.setAttribute("error", "The email has been used");
			return new ModelAndView("redirect:/register");
		}
	}
		
	/**
	 * user logout and redirect to login page.
	 * @param request
	 * @return login page
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().setAttribute("customer", "");
		return new ModelAndView("redirect:/index"); 
	}
}
