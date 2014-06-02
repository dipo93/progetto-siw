package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column(nullable = false)
	Float unitPrice;
	
	@Column(nullable = false)
	int quantity;
	
	
	//associazione orderLine-Product: molti a uno, quindi product = owner side; unidirezionale orderLine->Product
	//fetch eager di default è ok, non mi viene in mente alcuna cascade da fare :/
	@ManyToOne()
	Product product;
	

	public OrderLine() {
	}
	
	
	public OrderLine(Float unitPrice, int quantity) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
	}


	//	getters and setters
	
	public Long getId() {
		return id;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantity;
		result = prime * result
				+ ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		OrderLine other = (OrderLine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity != other.quantity)
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}
}
