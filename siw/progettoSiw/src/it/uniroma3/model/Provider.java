package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class Provider {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column(nullable= false)
	private String name;
	private String phoneNumber;
	private String email;
	@Column(nullable= false)
	private String vatIn;
	@Column(nullable= false)
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;
	@ManyToMany
	private List<Product> products;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVatIn() {
		return vatIn;
	}
	public void setVatIn(String vatIn) {
		this.vatIn = vatIn;
	}

}
