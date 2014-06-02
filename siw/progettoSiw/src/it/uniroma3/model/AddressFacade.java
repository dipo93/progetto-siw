package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AddressFacade {
	
    @PersistenceContext(unitName = "unit-siw-project")
    private EntityManager em;
    
	public Address getAddress(Long id) {
	    Address address = em.find(Address.class, id);
		return address;
	}
}