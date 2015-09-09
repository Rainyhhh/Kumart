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

import unimelb.edu.au.kumart.domainLogic.ItemDLImp;
import unimelb.edu.au.kumart.entity.Item;

@Controller
public class ItemController {
	
	@Autowired
	private ItemDLImp itemService;
	
	private static Logger logger = Logger.getLogger(ItemController.class.getName()); 
	
	
	@RequestMapping(value ="/addItem",method=RequestMethod.POST)
	public ModelAndView newItem(HttpServletRequest request, Item item) {
		//logger.info("sfwefwf");
		if(request.getSession().getAttribute("username") == null) return new ModelAndView("redirect:/login");
		ModelAndView mav = new ModelAndView("redirect:/index");
		if(itemService.newItem(item)) {
			return mav;
		}	
		else{
			String msg = "please input valid values!";
			mav.addObject("message", msg);			
		}
		return null;		
	}
	@RequestMapping("index")
	public ModelAndView getItemList(HttpServletRequest request){
		if(request.getSession().getAttribute("username") == null) return new ModelAndView("redirect:/login");
		ModelAndView mav = new ModelAndView("/index");
		List<Item> list = itemService.getItemList();
		if(list!= null){
			mav.addObject("items",list);
			return mav;
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public ModelAndView deleteItem(HttpServletRequest request){
		if(request.getSession().getAttribute("username") == null) return new ModelAndView("redirect:/login");
		String id = request.getParameter("id");
		if(itemService.deleteItem(id)){
			return new ModelAndView("redirect:/index");
		}
		return null;
	}
	
	@RequestMapping(value = "/prepareUpdate", method = RequestMethod.GET)
	public ModelAndView prepareUpdate(HttpServletRequest request){
		if(request.getSession().getAttribute("username") == null) return new ModelAndView("redirect:/login");
		String id = request.getParameter("id");
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
		if(req.getSession().getAttribute("username") == null) return new ModelAndView("redirect:/login");
		String id = req.getParameter("_id");
		if(itemService.updateItem(id, item)) {
			return new ModelAndView("redirect:/index", "message", "dkfwkjflewkfw");
		}				
		return null;		
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(HttpServletRequest req){
		if(req.getSession().getAttribute("username") == null) return new ModelAndView("redirect:/login");
		String query = req.getParameter("query");
		ModelAndView mav = new ModelAndView("/result");
		List<Item> list = itemService.searchByName(query);
		if(list!=null){
			mav.addObject("items",list);
			return mav;
		}
		return null;
	}
	
}
