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
	
	/**
	 * after users input valid values and click "submit" button, this method will be 
	 * executed.Create an new Item object and show the new item in the user interface.
	 * @param request
	 * @param item
	 * @return index page
	 */
	@RequestMapping(value ="/addItem",method=RequestMethod.POST)
	public ModelAndView newItem(HttpServletRequest request, Item item) {
		//logger.info("sfwefwf");
		if(request.getSession().getAttribute("username") == "") return new ModelAndView("redirect:/login");
		ModelAndView mav = new ModelAndView("redirect:/index");
		if(itemService.newItem(item)) {
			return new ModelAndView("redirect:/index");
		}	
		return null;				
	}
	
	/**
	 * when the user click the "add a new item" button, the user interface will redirect to 
	 * add a new item
	 * @return addNeeItem page
	 */
	@RequestMapping("prepareaddItem")
	public ModelAndView prepareNewItem() {
		ModelAndView mav = new ModelAndView("/addNewItem");
		return mav;
	}
	
	/**
	 * It is the index page after the user log in, this page show all items of the store.
	 * @param request
	 * @return index page
	 */
	@RequestMapping("index")
	public ModelAndView getItemList(HttpServletRequest request){
		if(request.getSession().getAttribute("username") == "") return new ModelAndView("redirect:/login");
		ModelAndView mav = new ModelAndView("/index");
		List<Item> list = itemService.getItemList();
		// double check if the list is not null
		if(list!= null){
			mav.addObject("items",list);
			return mav;
		}
		return null;
	}
	
	/**
	 * It is the index page after the user log in, this page show all items of the store.
	 * redirect to index page.
	 * @param request
	 * @return index page
	 */
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public ModelAndView deleteItem(HttpServletRequest request){
		if(request.getSession().getAttribute("username") == "") return new ModelAndView("redirect:/login");
		String id = request.getParameter("id");
		if(itemService.deleteItem(id)){
			return new ModelAndView("redirect:/index");
		}
		return null;
	}

	/**
	 * it shows the information of the item which will be modified later
	 * @param request
	 * @return update page
	 */
	@RequestMapping(value = "/prepareUpdate", method = RequestMethod.GET)
	public ModelAndView prepareUpdate(HttpServletRequest request){
		if(request.getSession().getAttribute("username") == "") return new ModelAndView("redirect:/login");
		String id = request.getParameter("id");
		ModelAndView mav = new ModelAndView("/update");
		Item item = itemService.getOneItem(id);
		if(item!=null){
			mav.addObject("Item", item);
			return mav;
		}
		return null;
	}

	/**
	 * where users edit the information of one item.
	 * @param req
	 * @param item
	 * @return index page
	 */
	@RequestMapping(value ="/update",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, Item item) {
		if(req.getSession().getAttribute("username") == "") return new ModelAndView("redirect:/login");
		String id = req.getParameter("_id");
		if(itemService.updateItem(id, item)) {
			return new ModelAndView("redirect:/index");
		}				
		return null;		
	}
	
	/**
	 * after the user inputs the query and click search button, this method will be executed
	 * and show the result in result page.
	 * @param req
	 * @return result page
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(HttpServletRequest req){
		if(req.getSession().getAttribute("username") == "") return new ModelAndView("redirect:/login");
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
