package net.mv.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pizzasize")
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSizeIDKey")
	@SequenceGenerator(name = "seqSizeIDKey", sequenceName = "SEQ_SIZEID_KEY", allocationSize = 1)
	private int s_id;
	
	@Column
	private String description;
	
	@Column
	private double price;
	
	@OneToOne
	private Pizza pizza;
	
	public Size() {}
	
	public Size(String description, double price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
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

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
	
	
}
