package it.uniroma3.controller;

import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RequestCustomerController  {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String firstName;	
	private String lastName;
	private String eMail;
	private String phoneNumber;
	private Date dateOfBirth;
	private Date registrationDay;

	private Customer currentCustomer;
	private List<Customer> customers;
	
	@EJB
	private CustomerFacade customerFacade;

	
	public RequestCustomerController() {
		
	}
	
	
	public String findCustomer(Long id) {
		this.currentCustomer = customerFacade.getCustomer(id);
		return "customer";
	}
	
	public String findAllCustomers() {
		customers = customerFacade.getAllCustomers();
		return "customers";
	}

	
	//getters and setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
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


	public Date getRegistrationDay() {
		return registrationDay;
	}


	public void setRegistrationDay(Date registrationDay) {
		this.registrationDay = registrationDay;
	}


	public Customer getCurrentCustomer() {
		return currentCustomer;
	}


	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}


	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}