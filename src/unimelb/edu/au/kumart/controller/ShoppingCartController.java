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
	
	@RequestMapping ("/index")
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
	
	@RequestMapping (value="/addShoppingCart", method = RequestMethod.POST)
	public ModelAndView addRecord(HttpServletRequest request, ShoppingCart shoppingCart){
		String item_id = request.getParameter("item_id");
		int price = Integer.parseInt(request.getParameter("price"));
		String username = (String) request.getSession().getAttribute("customer");
		shoppingCart.setItem_id(item_id);
		shoppingCart.setPrice(price);
		shoppingCartDL.addItem(username, shoppingCart);
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping ("/shoppingCart")
	public ModelAndView showShopppingCart(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("customer/shoppingCart");
		String customer = request.getSession().getAttribute("customer").toString();
		int totalPrice = shoppingCartDL.totalPrice(customer);
		List<ShoppingCart> shoppingCarts = shoppingCartDL.getShoppingCart(customer);
		if(shoppingCarts!= null){
			mav.addObject("shoppingCarts", shoppingCarts);
			mav.addObject("totalPrice",totalPrice);
			return mav;
		}
		return null;
	}
	
	@RequestMapping (value = "/deleteRecord", method = RequestMethod.GET)
	public ModelAndView deleteRecord(HttpServletRequest request){
		String item_id = request.getParameter("item_id").toString();
		String username = request.getSession().getAttribute("customer").toString();
		shoppingCartDL.deleteItem(item_id, username);
		return new ModelAndView("redirect:/shoppingCart");
	}

}
