package test.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;
import model.Participation;
import model.Transaction;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParticipationTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@Test
	public void participationOK(){
	    tx.begin();
	    Client client = new Client();
	    client.setFirstName("Yohayoh");
	    em.persist(client);
	    Transaction t = new Transaction();
	    em.persist(t);
	    Participation p = new Participation();
	    p.setClient(client);
	    p.setTransaction(t);
		em.persist(p);
		tx.commit();
		
		Query query =
		em.createQuery("select p from Participation p where p.client.id = :idClient and " +
				"p.transaction.id = :idTransaction");
		query.setParameter("idClient", client.getId());
		query.setParameter("idTransaction", t.getId());
		@SuppressWarnings("unchecked")
		List<Participation> liste = (List<Participation>)query.getResultList();
		Assert.assertNotNull(liste.get(0));
		Assert.assertTrue(liste.size() == 1);
	}
	
}
