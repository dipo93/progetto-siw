package it.uniroma3.model;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class CustomerFacade {
	
	@PersistenceContext(unitName = "siw-project-unit")
	private EntityManager em;
	
	public Customer createCustomer(String firstName, String lastName, String password,
			String email, Date dateOfBirth){
		Customer newCustomer= new Customer(firstName, lastName, password, email, dateOfBirth);
		em.persist(newCustomer);
		return newCustomer;
	}
	
	public Customer getCustomer(Long id){
		Customer customer= em.find(Customer.class, id);
		return customer;
	}
	
	public Customer getCustomerByEmail(String email){
		TypedQuery<Customer> tq = em.createQuery("getCustomerByEmail", Customer.class);
		tq.setParameter("mail", email);
		Customer customer= tq.getSingleResult();
		return customer;
	}
	
	public void updateCustomer(Customer customer){
		em.merge(customer);
	}
	
	public void deleteCustomer(Customer customer){
		em.remove(customer);
	}
	
	public void deleteCustomer(Long id) {
        Customer customer = em.find(Customer.class, id);
        deleteCustomer(customer);
	}
	

}
