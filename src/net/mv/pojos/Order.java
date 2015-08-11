package net.mv.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pizzaorder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrderIDKey")
	@SequenceGenerator(name = "seqOrderIDKey", sequenceName = "SEQ_ORDERID_KEY", allocationSize = 1)
	private int o_id;
	
	@Column
	private double price;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	@OneToMany(mappedBy="order", targetEntity=Pizza.class, cascade=CascadeType.ALL)
	private Set<Pizza> setPizzas;

	public Order() {}
	
	public Order(int o_id, Customer customer) {
		super();
		this.o_id = o_id;
		this.customer = customer;
	}

	public int getId() {
		return o_id;
	}

	public void setId(int id) {
		this.o_id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Pizza> getSetPizzas() {
		return setPizzas;
	}

	public void setSetPizzas(Set<Pizza> setPizzas) {
		this.setPizzas = setPizzas;
	}

	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", customer=" + customer
				+ ", setPizzas=" + setPizzas + "]";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
