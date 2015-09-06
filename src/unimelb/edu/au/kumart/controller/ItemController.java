package unimelb.edu.au.kumart.controller;

import java.util.*;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.entity.Item;
import unimelb.edu.au.kumart.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	private static Logger logger = Logger.getLogger(ItemController.class.getName()); 
	
	
	@RequestMapping(value ="/addItem",method=RequestMethod.POST)
	public ModelAndView newItem(Item item) {
		//logger.info("sfwefwf");
		if(itemService.newItem(item)) {
			return new ModelAndView("redirect:/index");
		}				
		return null;		
	}
	@RequestMapping("index")
	public ModelAndView getItem(){
		ModelAndView mav = new ModelAndView("/index");
		List<Item> list = itemService.getItem();
		if(list!= null){
			mav.addObject("items",list);
			return mav;
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public ModelAndView deleteItem(@RequestParam String id){
		if(itemService.deleteItem(id)){
			return new ModelAndView("redirect:/index");
		}
		return null;
	}
	
	@RequestMapping(value = "/prepareUpdate", method = RequestMethod.GET)
	public ModelAndView prepareUpdate(@RequestParam String id){
		ModelAndView mav = new ModelAndView("/update");
		Item item = itemService.getOneItem(id);
		if(item!=null){
			mav.addObject("Item", item);
			return mav;
		}
		return null;
	}
	
	@RequestMapping(value ="/update",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, Item item) {
		String id = req.getParameter("_id");
		if(itemService.update(id, item)) {
			return new ModelAndView("redirect:/index");
		}				
		return null;		
	}
	
}
