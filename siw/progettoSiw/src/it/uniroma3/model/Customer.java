package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String eMail;

	private String phoneNumber;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date registrationDay;
	
	//associazione customer-order : uno a molti, quindi owner side = order, inverse side = customer; bidirezionale
	//fetchtype lazy di default è ok
	@OneToMany(mappedBy="customer", cascade={CascadeType.REMOVE})
	private List<Order> ordini;

	//associazione customer-address: uno a uno, unidirezionale (customer->address), quindi customer = owner side
	@OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;
	
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String eMail,
			String phoneNumber, Date dateOfBirth, Date registrationDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.registrationDay = registrationDay;
	}
	

	
	//	getters & setters

	public Long getId() {
		return id;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result
				+ ((registrationDay == null) ? 0 : registrationDay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (registrationDay == null) {
			if (other.registrationDay != null)
				return false;
		} else if (!registrationDay.equals(other.registrationDay))
			return false;
		return true;
	}
}