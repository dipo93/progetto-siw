package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@ManyToMany(mappedBy= "products")
	private List<Provider> providers;
	@Column(nullable= false)
	private String code;
	@Column(nullable= false)
	private String name;
	private String description;
	@Column(nullable= false)
	private Float price;
	@Column(nullable= false)
	private int inStock;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	

}
