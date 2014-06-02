package it.uniroma3.lib;

import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import java.util.List;

import javax.ejb.EJB;

public class OrderFiller {
	
	@EJB
	private ProductFacade productFacade;
	@EJB
	private OrderFacade orderFacade;
	
	
	
	public Boolean fillOrder(Order order) {
		List<OrderLine> orderLines = order.getOrderLines();
		Boolean orderIsFillable = this.checkQuantities(order);
		if(orderIsFillable) {
			for(OrderLine line : orderLines) {
				Product product = line.getProduct();
				product.decreaseQuantity(line.getQuantity());
				productFacade.updateProduct(product);
			}
			order.setStatusFilled();
			orderFacade.updateOrder(order);
		}
		return orderIsFillable;
	}
	
	
	private Boolean checkQuantities(Order order) {
		List<OrderLine> orderLines = order.getOrderLines();
		Boolean quantitiesAreOk=true;
		for(int i=0; i<orderLines.size() && quantitiesAreOk; i++) {
			Product product = orderLines.get(i).getProduct();
			if(orderLines.get(i).getQuantity() > product.getQuantity())
				quantitiesAreOk=false;
		}
		return quantitiesAreOk;
	}
}
