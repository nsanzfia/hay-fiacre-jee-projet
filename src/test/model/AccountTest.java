package test.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Account;
import model.Wallet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AccountTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@SuppressWarnings("unchecked")
	@Test
	public void accountOK(){
	    tx.begin();
	    Wallet w = new Wallet();
	    em.persist(w);
		Account account = new Account(200, w);
		em.persist(account);
		tx.commit();
		
		Query query =
		em.createQuery("select a from Account a where a.wallet.id = :id");
		query.setParameter("id", w.getId());
		List<Account> liste = (List<Account>)query.getResultList();
		Assert.assertEquals(w.getId(), liste.get(0).getWallet().getId());
	}
	
}
