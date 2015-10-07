package unimelb.edu.au.kumart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.domainLogic.ItemDLImp;
import unimelb.edu.au.kumart.entity.Item;

@Controller
public class ShoppingCartController {
	@Autowired
	private ItemDLImp itemService;
	
	@RequestMapping("index_cus")
	public ModelAndView getItemList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/index_cus");
		List<Item> list = itemService.getItemList();
		// double check if the list is not null
		if(list!= null){
			mav.addObject("items",list);
			return mav;
		}
		return null;
	}
	
	

}
