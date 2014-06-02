package it.uniroma3.controller;

import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RequestProductController  {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String code;
	private Float price;
	private String description;	
	private Product product;
	private List<Product> products;
	@EJB
	private ProductFacade productFacade;

	
	public RequestProductController() {
		
	}
	
	public String createProduct() {
		this.product = productFacade.createProduct(this.name, this.code, this.price, this.description);
		return "product";
	}
	
	public String findProduct() {
		this.product = productFacade.getProduct(this.id);
		return "product";
	}
	
	public String getAllProducts() {
		products = productFacade.getAllProducts();
		return "products";
	}
	
	public String prepareUpdateProduct() {
		this.product = productFacade.getProduct(this.id);
		return "updateProduct";

	}
	public String updateProduct() {
		productFacade.updateProduct(this.product);
		return "product";
	}

	public String deleteProduct() {
		productFacade.deleteProduct(this.id);
		return "products";
	}

	
	
	//getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}