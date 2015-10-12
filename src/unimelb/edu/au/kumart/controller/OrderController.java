package unimelb.edu.au.kumart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.domainLogic.OrderDLImp;

@Controller
public class OrderController {

	@Autowired
	OrderDLImp orderDL = new OrderDLImp();
	
	@RequestMapping("myOrders")
	public ModelAndView getOrderList(HttpServletRequest request) {
	}
	
}
