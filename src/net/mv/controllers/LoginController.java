package net.mv.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Set;

import net.mv.pojos.Customer;
import net.mv.pojos.Size;
import net.mv.pojos.Topping;
import net.mv.service.LoginService;
import net.mv.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PizzaService pizzaService;
	/*
	 * Send to login.jsp (GET request)
	 */
	@RequestMapping(value="/fish", method=RequestMethod.GET)
	public String someMethod(ModelMap model){

		model.addAttribute("customer", new Customer());
		
		
		
		return "login";
	}
	
	@RequestMapping(value="/dog", method=RequestMethod.GET)
	public String someOtherMethod(ModelMap model){
		
		model.addAttribute("customer", new Customer());
		return "register";
	}
	
	/*
	 * Authenticate user and if successful send to pizza.jsp (POST request)
	 */
	@RequestMapping(value="/tryToLogin", method=RequestMethod.POST)
	public String otherMethod(@Valid Customer customer, BindingResult result, HttpServletRequest request) {
	
		
		String username = customer.getUsername();
		String password = customer.getPassword();
		String loginErrMsg = "No username or password existed";
		HttpSession session = request.getSession();
		
		try {
			Customer authenticatedCustomer = loginService.authentication(username, password);
			if (authenticatedCustomer != null) {
				
				session.setAttribute("username", authenticatedCustomer.getUsername());
				
				session.setAttribute("authenticatedCustomer", authenticatedCustomer);
				Set<Size> sizes = pizzaService.getSizes();	
				session.setAttribute("sizes", sizes);  
				
				Set<Topping> toppings = pizzaService.getToppings();
				session.setAttribute("toppings", toppings);
	
				return "pizza";
			}
			else
				return "login";
			}catch(NullPointerException e){
				e.printStackTrace();
				session.setAttribute("loginErrMsg", loginErrMsg);
				System.out.println("Customer name is already created!");
			return "login";
		} 
		
	}
	
	@RequestMapping(value="/tryToRegister", method=RequestMethod.POST)
	public String registerPage(@Valid Customer customer ,BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()){
			return "register";
		} else {
			HttpSession session = request.getSession();
			String username = customer.getUsername();
			String password = customer.getPassword();
			String age = customer.getAge();
			String email = customer.getEmail();
			
			Customer newCustomer = new Customer();
			
			newCustomer.setPassword(password);
			newCustomer.setUsername(username);
			newCustomer.setAge(age);
			newCustomer.setEmail(email);
			
			boolean existed = loginService.registerdCustomer(newCustomer);
			
			if (existed) {
				session.setAttribute("existedCustomerErr", "Username is already existed!");
				return "register";
			}else	{
				return "login";
			}
		}
			
	}
}
