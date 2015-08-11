package net.mv.service;

import java.util.HashSet;
import java.util.Set;

import net.mv.dao.PizzaDao;
import net.mv.pojos.Order;
import net.mv.pojos.Pizza;
import net.mv.pojos.Size;
import net.mv.pojos.Topping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PizzaService {
	
	@Autowired
	PizzaDao pizzaDao;
	
	public Set<Size> getSizes() {
		Set<Size> sizes = new HashSet<Size>();
		sizes.add(new Size("Small", 5.0));
		sizes.add(new Size("Medium", 10.0));
		sizes.add(new Size("Large", 15.0));
		return sizes;
	}
	
	public Set<Topping> getToppings(){
		Set<Topping> toppings = new HashSet<Topping>();
		toppings.add(new Topping("Cheese", 0.5));
		toppings.add(new Topping("Veggies", 1.0));
		toppings.add(new Topping("Meat", 2.0));
		return toppings;
	}
	
	public double calculatePrice(Pizza pizza){
		double sizePrice = 0.0;
		double toppingPrice = 0.0;
		double totalPrice = 0.0;
		
		Set<Size> sizes = getSizes();
		for (Size temp : sizes){
			if (temp.getDescription().equals(pizza.getSize().getDescription())) {
				sizePrice = temp.getPrice();
			}
		}
	
		Set<Topping> toppings = getToppings();
		for (Topping p : pizza.getToppings()) {
			for (Topping temp : toppings) {
				if (temp.getDescription().equals(p.getDescription())){
					toppingPrice += temp.getPrice();
				}
			}
		}

		totalPrice = sizePrice + toppingPrice;
		
		return totalPrice;
	}
	
	public boolean submitOrder(Order order) {
		boolean persistSuccessful = false;
		try {
			pizzaDao.submitOrder(order);
		}catch(Exception e) {
			e.printStackTrace();
			persistSuccessful = false;
		}
		persistSuccessful = true;
		return persistSuccessful;
	}
	
	public void addPizza(Pizza pizza){
		try {
			pizzaDao.submitPizza(pizza);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
