package test.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Admin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AdminTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@Test
	public void adminOK(){
	    tx.begin();
		Admin admin = new Admin("test","test");
		em.persist(admin);
		tx.commit();
		
		Query query =
		em.createQuery("select a from Admin a where a.id = :id");
		query.setParameter("id", admin.getId());
		@SuppressWarnings("unchecked")
		List<Admin> liste = (List<Admin>)query.getResultList();
		Assert.assertEquals(admin.getId(), liste.get(0).getId());
	}
	
}
