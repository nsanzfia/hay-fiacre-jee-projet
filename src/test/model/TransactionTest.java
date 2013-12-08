package test.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Transaction;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TransactionTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@Test
	public void transactionOK(){
	    tx.begin();
	    Transaction t = new Transaction(0, "test");
	  	em.persist(t);
		tx.commit();
		
		Query query =
		em.createQuery("select t from Transaction t where t.id = :id");
		query.setParameter("id", t.getId());
		@SuppressWarnings("unchecked")
		List<Transaction> liste = (List<Transaction>)query.getResultList();
		Assert.assertEquals(t.getComment(), liste.get(0).getComment());

	}
	
}
