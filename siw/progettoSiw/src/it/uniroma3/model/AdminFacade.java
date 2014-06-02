package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class AdminFacade {
	
	@PersistenceContext(unitName = "unit-project-siw")
    private EntityManager entityManager;

	
	public AdminFacade() {
		
	}
	
	public Administrator getAdmin (String eMail) {
		String queryString = "SELECT a FROM Administrator a WHERE a.eMail=" + eMail;
		Query query = entityManager.createQuery(queryString);
    	Administrator admin = (Administrator) query.getSingleResult();
		return admin;
	}
	
	public List<Product> getAllProducts() {
        CriteriaQuery<Product> cq = entityManager.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = entityManager.createQuery(cq).getResultList();
        return products;
	}
	
	public void updateProduct(Product product) {
        entityManager.merge(product);
	}
	
    private void deleteProduct(Product product) {
        entityManager.remove(product);
    }

	public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        deleteProduct(product);
	}

	
	
	
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}