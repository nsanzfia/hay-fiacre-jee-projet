package test.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class WalletTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-projet");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
	
	@Test
	public void walletOK(){
	    tx.begin();
	    Wallet w = new Wallet();
	    Action action = new Action();
	    action.setAdj(800);
	    Action action1 = new Action();
	    action.setAdj(805);
	    Set<Action> actions = new HashSet<Action>();
	    actions.add(action);
	    actions.add(action1);
	    w.setActions(actions);
		em.persist(w);
		tx.commit();
		
		Query query =
		em.createQuery("select w from Wallet w where w.id = :id");
		query.setParameter("id", w.getId());
		@SuppressWarnings("unchecked")
		List<Wallet> liste = (List<Wallet>)query.getResultList();
		Assert.assertEquals(2, liste.get(0).getActions().size());    
	}
	
}
