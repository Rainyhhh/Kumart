package unimelb.edu.au.kumart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.domainLogic.ItemDLImp;
import unimelb.edu.au.kumart.domainLogic.ShoppingCartDLImp;
import unimelb.edu.au.kumart.entity.Item;
import unimelb.edu.au.kumart.entity.ShoppingCart;

@Controller
public class ShoppingCartController {
	@Autowired
	private ItemDLImp itemService;
	@Autowired
	private ShoppingCartDLImp shoppingCartDL;
	
	@RequestMapping("/index")
	public ModelAndView getItemList(){
		ModelAndView mav = new ModelAndView("/customer/index_cus");
		List<Item> list = itemService.getItemList();
		// double check if the list is not null
		if(list!= null){
			mav.addObject("items",list);
			return mav;
		}
		return null;
	}
	
	@RequestMapping(value="/addShoppingCart", method = RequestMethod.POST)
	public ModelAndView addRecord(HttpServletRequest request, ShoppingCart shoppingCart){
//		String id = request.getParameter("id");
//		String item_name = request.getParameter("name");
//		int quantity = Integer.parseInt(request.getParameter("quantity"));
//		shoppingCartDL.addItem(id, item_name, quantity);		
		String username = (String) request.getSession().getAttribute("customer");
		System.out.println(shoppingCart);
		shoppingCartDL.addItem(username, shoppingCart);
		return new ModelAndView("redirect:/index");
	}
	

}
