package test.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Account;
import model.Client;
import model.Wallet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClientTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@Test
	public void clientOK(){
	    tx.begin();
	    Wallet w = new Wallet();
	    em.persist(w);
	    Account a = new Account(200, w);
	    em.persist(a);
	    Client client = new Client("Nsanzabandi", "Fiacre", a);
		em.persist(client);
		tx.commit();
		
		Query query =
		em.createQuery("select c from Client c where c.firstName = :name");
		query.setParameter("name", client.getFirstName());
		@SuppressWarnings("unchecked")
		List<Client> liste = (List<Client>)query.getResultList();
		Assert.assertEquals(a.getId(), liste.get(0).getAccount().getId());
	}
	
}
