package test.model.databaseManager;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import model.Action;
import model.Wallet;
import model.databaseManager.ActionManager;
import model.databaseManager.Database;
import model.databaseManager.WalletManager;

@RunWith(JUnit4.class)
public class ActionManagerTest {
	private Database database = new Database();
	private ActionManager actionManager = new ActionManager(database);
	private WalletManager walletManager = new WalletManager(database);
	
	@Test
	public void addActionOK() {
		Wallet w = new Wallet();
		walletManager.addWallet(w);
	    java.util.Date d = new java.util.Date();
	    java.sql.Date dSql = new Date(d.getTime());
		Action action = new Action(dSql, 200, 200, 200, 200, 200, 200, w);
		actionManager.addAction(action);
		
		@SuppressWarnings("static-access")
		Query query =
		database.ENTITY_MANAGER.createQuery("select a from Action a where a.date = :date and a.wallet.id = :id");
		query.setParameter("date", dSql);
		query.setParameter("id", w.getId());
		@SuppressWarnings("unchecked")
		List<Action> listeWallet = (List<Action>)query.getResultList();
		Assert.assertEquals(w.getId(), listeWallet.get(0).getWallet().getId());
		Assert.assertEquals(dSql, listeWallet.get(0).getDate());
	}
}
