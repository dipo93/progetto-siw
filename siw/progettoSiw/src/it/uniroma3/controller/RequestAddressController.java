package it.uniroma3.controller;

import it.uniroma3.model.Address;
import it.uniroma3.model.AddressFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RequestAddressController  {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String street;
	private String city;	
	private String state;
	private String zipcode;
	private String country;

	private Address address;
	
	@EJB
	private AddressFacade addressFacade;

	
	public RequestAddressController() {
		
	}
	
	
	public String findAddress(Long id) {
		this.address = addressFacade.getAddress(id);
		return "address";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public AddressFacade getAddressFacade() {
		return addressFacade;
	}


	public void setAddressFacade(AddressFacade addressFacade) {
		this.addressFacade = addressFacade;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//getters and setters
	
}