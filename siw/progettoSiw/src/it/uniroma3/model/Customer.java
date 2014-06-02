package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@NamedQuery(name= "getCustomerByEmail", query= "SELECT c FROM Customer c WHERE c.email= :mail")
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column(nullable= false)
	private String firstName;
	@Column(nullable= false)
	private String LastName;
	@Column(nullable= false)
	private String password;
	@Column(nullable= false, unique= true)
	private String email;
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;
	@OneToMany(mappedBy= "customer")
	private List<Order> ownOrders;
	
	public Customer(String firstName, String lastName, String password,
			String email, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate= new Date();
		this.ownOrders= new ArrayList<Order>();
	}
	
	public Customer(){
		this.registrationDate= new Date();
		this.ownOrders= new ArrayList<Order>();
	}
	
	public boolean verifyPassword(String pw){
		return this.password.equals(pw);
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	

}
