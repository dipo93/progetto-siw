package it.uniroma3.controller;

import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.OrderLine;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class RequestOrderController  {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{param.id}")
	private Long id;	
	private Order currentOrder;
	private List<Order> orders;
	private List<OrderLine> orderLines;
	@EJB
	private OrderFacade orderFacade;
	
	public RequestOrderController() {
		
	}
	
	public String findOrder(Long id) {
		this.currentOrder = orderFacade.findOrder(id);
		return "order";
	}
	
	public String getClosedOrders() {
		this.orders = orderFacade.getClosedOrders();
		return "closed_orders";
	}
		
	public String getAllOrders() {
		orders = orderFacade.getAllOrders();
		return "all_orders";
	}

	
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public OrderFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}