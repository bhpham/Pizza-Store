package net.mv.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.mv.pojos.Customer;
import net.mv.pojos.Order;
import net.mv.pojos.Pizza;
import net.mv.pojos.Size;
import net.mv.pojos.Topping;
import net.mv.service.LoginService;
import net.mv.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PizzaController {

	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	LoginService loginService;
	
	
	/*
	 * Add pizza to order (POST request)
	 */
	@RequestMapping(value="/addPizza", method=RequestMethod.POST)
	public String addPizza(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Set<Pizza> pizzasInOrder = (Set<Pizza>) session.getAttribute("pizzasInOrder");
		double totalPrice = 0.0;
		if (session.getAttribute("totalPrice") != null)
			totalPrice = (double) session.getAttribute("totalPrice");
		/*
		 * Check if pizzasOrder is existed
		 */
		if (pizzasInOrder == null) {
			pizzasInOrder = new HashSet<Pizza>();
		}
		
		/*
		 * Get data from JSP form
		 */
		String newSizeString = request.getParameter("sizeSelected");
		String[] newToppingsString = request.getParameterValues("toppingSelected");
		
		Size newSizeObject = new Size();
		newSizeObject.setDescription(newSizeString);

		/*
		 * Convert to Set<Topping> object
		 */
		Set<Topping> newToppingsObject = new HashSet<Topping>();
		if (request.getParameterValues("toppingSelected") != null ) {
			for (String temp : newToppingsString) {
				Topping toppingToAdd = new Topping();
				toppingToAdd.setDescription(temp);
				newToppingsObject.add(toppingToAdd);
			}
		}
		/*
		 * Create Pizza objet, add to pizzasInOrder, update the HttpSession
		 */
		Pizza newPizza = new Pizza(newSizeObject, newToppingsObject);
		newSizeObject.setPizza(newPizza);
//		
		double price = pizzaService.calculatePrice(newPizza);
		totalPrice += price;
		
		newPizza.setPrice(price);
	
		pizzasInOrder.add(newPizza);		//Add pizza to List of pizzas
		
		session.setAttribute("pizzasInOrder", pizzasInOrder);
		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("errMsg", null);
		return "pizza";
	}

	
	/*
	 * Submit order /persist order (POST request)
	 */
	@RequestMapping(value="/submitOrder", method=RequestMethod.POST)
	public String submitOrder(HttpServletRequest request){
		HttpSession session = request.getSession();
		Set<Pizza> pizzas = (Set<Pizza>) session.getAttribute("pizzasInOrder");
		Customer customer = (Customer) session.getAttribute("authenticatedCustomer");
		double totalPrice = (double) session.getAttribute("totalPrice");
		Order order = new Order();	

		/*Set pizza to current order*/
		for (Pizza pizza : pizzas) {
			pizza.setOrder(order);
		}
		
		order.setPrice(totalPrice);
		order.setSetPizzas(pizzas);
		order.setCustomer(customer);
	
		boolean submit = pizzaService.submitOrder(order);
		
		if (pizzas != null && pizzas.size() != 0 && submit == true) {	
			session.setAttribute("pizzasInOrder", null);
			session.setAttribute("totalPrice", 0.0);
			System.out.println("submitOrder success");
		}else {
			System.out.println("submitOrderFailure");
			String errMsg = "Add your pizza before submitting order";
			session.setAttribute("errMsg", errMsg);;
		}
	
		return "pizza";
	}
}
