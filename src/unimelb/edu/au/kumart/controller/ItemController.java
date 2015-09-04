package unimelb.edu.au.kumart.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.entity.Item;
import unimelb.edu.au.kumart.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	private static Logger logger = Logger.getLogger(ItemController.class.getName()); 
	
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}
	
	@RequestMapping(value ="/addItem",method=RequestMethod.POST)
	public ModelAndView newItem(Item item) {
		//logger.info("sfwefwf");
		if(itemService.newItem(item)) {
			return new ModelAndView("/index");
		}				
		return null;		
	}
	@RequestMapping("getItem")
	public ModelAndView getItem(){
		ModelAndView mav = new ModelAndView("/display");
		if(itemService.getItem()!= null){
			return mav;
		}
		return null;
	}
}
