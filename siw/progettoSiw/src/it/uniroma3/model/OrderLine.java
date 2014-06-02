package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@OneToOne
	@Column(nullable= false)
	private Product productDescription;
	@Column(nullable= false)
	private Float unitPrice;
	@Column(nullable= false)
	private int quantity;
	
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Product getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(Product productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
