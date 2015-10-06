package unimelb.edu.au.kumart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import unimelb.edu.au.kumart.exception.AuthorizationAdminException;
import unimelb.edu.au.kumart.exception.AuthorizationException;

public class LoginInterceptor implements HandlerInterceptor{
	
	private List<String> excludedUrls;
	
	public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String requestUri = arg0.getRequestURI();
		for (String url : excludedUrls) {
			//System.out.println(url);
            if (requestUri.contains(url)) {
                return true;
            }
        }
		
		HttpSession session = arg0.getSession();
		
		if(requestUri.contains("/admin")) {
        	// intercept   		
    		if (session.getAttribute("username") == null || session.getAttribute("username") == "") {
    			throw new AuthorizationAdminException();
    		}
    		else return true;      	
        }
		else {
			if (session.getAttribute("customer") == null || session.getAttribute("customer") == "") {
				throw new AuthorizationException();
			}
			else return true;
		}
            
	}

}
