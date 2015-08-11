package net.mv.pojos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcustIDKey")
	@SequenceGenerator(name = "seqcustIDKey", sequenceName = "SEQ_CUSTID_KEY", allocationSize = 1)
	private int c_id;
	
	@Column(unique=true)
	@NotEmpty(message = "Username is required")
	private String username;
	
	@Column
	@NotEmpty(message = "Password is required")
	private String password;
	
	@Column
	@NotEmpty(message = "Age is required")
	private String age;
	
	@Column
	@NotEmpty(message = "Email is required")
	@Email(message="Please provide a valid email address")
	private String email;
	
	@OneToMany(mappedBy="customer", targetEntity=Order.class)
	private Set<Order> orders;
	
	
	public Customer() {}
	
	public Customer(int c_id, String username, String password, String age,
			String email) {
		super();
		this.c_id = c_id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
