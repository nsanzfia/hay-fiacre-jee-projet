package test.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CompanyTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@Test
	public void companyOK(){
	    tx.begin();
	    Company company = new Company("test","test",200,200,"test", "test", "test", "test", "test");
		em.persist(company);
		tx.commit();
		
		Query query =
		em.createQuery("select c from Company c where c.name = :name");
		query.setParameter("name", company.getName());
		@SuppressWarnings("unchecked")
		List<Company> liste = (List<Company>)query.getResultList();
		Assert.assertEquals((int)company.getLastSale(), (int)liste.get(0).getLastSale());
	}
	
}
