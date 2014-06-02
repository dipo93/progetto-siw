package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Provider {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column(nullable = false)
	String name;
	
	@Column(nullable = false)
	String eMail;

	String phoneNumber;
	
	String vatin;
	

	//associazione provider-product: molti a molti bidirezionale; scelgo arbitrariamente owner = provider
	//fetchType lazy ok, non mi viene in mente alcun t
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	List<Product> products;
	
	//associazione provider-address: uno a uno, unidirezionale provider->address, quindi scelgo owner = provider
	@OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	Address address;

	
	public Provider() {
		
	}
	
	public Provider(String name, String eMail, String phoneNumber, String vatin) {
		this.name = name;
		this.eMail = eMail;
		this.phoneNumber = phoneNumber;
		this.vatin = vatin;
	}

	
	//	getters & setters
	
	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((vatin == null) ? 0 : vatin.hashCode());
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
		Provider other = (Provider) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (vatin == null) {
			if (other.vatin != null)
				return false;
		} else if (!vatin.equals(other.vatin))
			return false;
		return true;
	}


}
