package net.mv.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPizzaIDKey")
	@SequenceGenerator(name = "seqPizzaIDKey", sequenceName = "SEQ_PIZZAID_KEY", allocationSize = 1)
	private int p_id;
	
	@Column
	private double price;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Size size;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="PIZZA_TOPPING", joinColumns={
				@JoinColumn(name="p_id")},
				inverseJoinColumns = { @JoinColumn(name="t_id") })
	private Set<Topping> toppings;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Order order;
	
	public Pizza() {}
	
	
	public Pizza(Size size, Set<Topping> toppings) {
		super();
		this.size = size;
		this.toppings = toppings;
	}


	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Set<Topping> getToppings() {
		return toppings;
	}
	public void setToppings(Set<Topping> toppings) {
		this.toppings = toppings;
	}
	@Override
	public String toString() {
		return "Pizza [size=" + size + ", toppings=" + toppings + "]";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
