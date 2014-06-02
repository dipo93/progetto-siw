package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class OrderFacade {
	
	@PersistenceContext(unitName = "unit-project-siw")
    private EntityManager entityManager;

	
	
	public OrderFacade() {
		
	}
	
	public Order findOrder(Long id) {
	    Order order = entityManager.find(Order.class, id);
		return order;
	}
	
	public List<Order> getClosedOrders() {
		List <Order> closedOrders;
		String queryString = "SELECT o FROM orders o WHERE o.status = closed";
		Query query = entityManager.createNamedQuery(queryString);
		closedOrders = query.getResultList();
		return closedOrders;
	}
	
	public List<Order> getAllOrders() {
		List <Order> allOrders;
		String queryString = "SELECT o FROM orders o ORDER BY o.creationTime";
		Query query = entityManager.createNamedQuery(queryString);
		allOrders = query.getResultList();
		return allOrders;
	}
	

	public void updateOrder(Order order) {
		this.entityManager.merge(order);
	}

	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}