package it.uniroma3.controller;

import it.uniroma3.lib.OrderFiller;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.OrderLine;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SessionOrderController  {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{param.id}")
	private Long id;	
	private Order currentOrder;
	private List<OrderLine> orderLines;
	private String fillError;
	
	@EJB
	private OrderFacade orderFacade;
	
	public SessionOrderController() {
		
	}
	
	public String findOrder(Long id) {
		this.currentOrder = orderFacade.findOrder(id);
		return "order";
	}
	
	public String prepareOrderFilling(Order order) {
		this.currentOrder = order;
		this.fillError = null;
		return "prepare_order_filling";
	}
	
	public String fillCurrentOrder() {
		String nextPage = null;
		OrderFiller orderFiller = new OrderFiller();
		Boolean orderIsFilled = orderFiller.fillOrder(this.currentOrder);
		if(orderIsFilled)
			nextPage = "order_filling_confirm";
		else
			this.fillError = "ERROR: some lines require a bigger number of products than their available quantity!";
			nextPage = "prepare_order_filling";
		
		return nextPage;
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