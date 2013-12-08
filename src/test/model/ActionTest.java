package test.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Action;
import model.Wallet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ActionTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@SuppressWarnings("unchecked")
	@Test
	public void actionOK(){
	    tx.begin();
	    Wallet w = new Wallet();
	    em.persist(w);
	    java.util.Date d = new java.util.Date();
	    java.sql.Date dSql = new Date(d.getTime());
		Action action = new Action(dSql, 200, 200, 200, 200, 200, 200, w);
		em.persist(action);
		tx.commit();
		
		Query query =
		em.createQuery("select a from Action a where a.date = :date and a.wallet.id = :id");
		query.setParameter("date", dSql);
		query.setParameter("id", w.getId());
		List<Action> listeWallet = (List<Action>)query.getResultList();
		Assert.assertEquals(w.getId(), listeWallet.get(0).getWallet().getId());
		Assert.assertEquals(dSql, listeWallet.get(0).getDate());		
	}
	
}
