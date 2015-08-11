package net.mv.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.mv.pojos.Order;
import net.mv.pojos.Pizza;
import net.mv.pojos.Size;
import net.mv.pojos.Topping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PizzaDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void submitOrder(Order order) {
		
		/*
		 *  Create session for data source and save it into Dbms
		 */
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}
	
	@Transactional
	public void submitPizza(Pizza pizza) {
		Session session = sessionFactory.getCurrentSession();
		session.save(pizza);
		
	}
//	
//	@Transactional
//	public Set<Size> getSize() {
//		Set<Size> sizes = new HashSet<Size>();
//		Session session = sessionFactory.getCurrentSession();
//		List<Size> listSizes = session.createCriteria(Size.class).list();
//		
//		for (Size s : listSizes) {
//			sizes.add(s);
//		}
//		
//		return sizes;
//	}
//	
//	@Transactional
//	public Set<Topping> getTopping() {
//		Set<Topping> toppings = new HashSet<Topping>();
//		Session session = sessionFactory.getCurrentSession();
//		List<Topping> listToppings = session.createCriteria(Topping.class).list();
//		
//		for (Topping t : listToppings) {
//			toppings.add(t);
//		}
//		
//		return toppings;
//	}
}
