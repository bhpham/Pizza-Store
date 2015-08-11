package net.mv.pojos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Topping {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqToppingIDKey")
	@SequenceGenerator(name = "seqToppingIDKey", sequenceName = "SEQ_TOPPINGID_KEY", allocationSize = 1)
	private int t_id;
	
	@Column
	private String description;
	
	@Column
	private double price;
	
	@ManyToMany(mappedBy="toppings")
	private Set<Pizza> pizzas;
	
	
	public Topping(){}
	
	public Topping(String description, double price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	
	
	
}
