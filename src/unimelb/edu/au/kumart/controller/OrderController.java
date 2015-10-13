package unimelb.edu.au.kumart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.domainLogic.OrderDLImp;
import unimelb.edu.au.kumart.entity.Order;

@Controller
public class OrderController {

	@Autowired
	OrderDLImp orderDL = new OrderDLImp();

	/**
	 * show a list of orders of users
	 * 
	 * @param request
	 * @return myOrders page
	 */
	@RequestMapping("/myOrders")
	public ModelAndView getOrderList(HttpServletRequest request) {
		ModelAndView maView = new ModelAndView("/customer/order");
		String username = (String) request.getSession().getAttribute("customer");
		List<Order> list = orderDL.getOrderList(username);
		maView.addObject("orderList", list);
		return maView;
	}

	/**
	 * apply for the cancellation of an order
	 * 
	 * @param request
	 * @return myOrders page
	 */
	@RequestMapping(value = "/applyCancellation", method = RequestMethod.GET)
	public ModelAndView applyCancellation(HttpServletRequest request) {
		String order_id = request.getParameter("order_id");
		orderDL.applyCancellation(order_id);
		return new ModelAndView("redirect:myOrders");
	}

	/**
	 * show a list of orders that are waiting to be approved
	 * 
	 * @return waiting orders page
	 */
	@RequestMapping("/admin_orders")
	public ModelAndView getWaitingOrders() {
		ModelAndView mavAndView = new ModelAndView("/handleOrder");
		List<Order> list = orderDL.getWaitToCancelOrders();
		mavAndView.addObject("orderList", list);
		return mavAndView;
	}

	/**
	 * approve the cancellations
	 * 
	 * @param request
	 * @return waiting orders page
	 */
	@RequestMapping(value = "/approveCancellation", method = RequestMethod.GET)
	public ModelAndView approveCancellation(HttpServletRequest request) {
		String order_id = request.getParameter("order_id");
		System.out.println(order_id);
		orderDL.handleCancellation(order_id);
		return new ModelAndView("redirect:admin_orders");
	}

}
