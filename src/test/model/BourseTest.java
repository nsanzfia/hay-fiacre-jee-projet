package test.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Bourse;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BourseTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@Test
	public void bourseOK(){
	    tx.begin();
		Bourse bourse = new Bourse();
		bourse.setName("NASDAC");
		em.persist(bourse);
		tx.commit();
		
		Query query =
		em.createQuery("select b from Bourse b where b.id = :id");
		query.setParameter("id", bourse.getId());
		@SuppressWarnings("unchecked")
		List<Bourse> liste = (List<Bourse>)query.getResultList();
		Assert.assertEquals(bourse.getName(), liste.get(0).getName());
	}
	
}
