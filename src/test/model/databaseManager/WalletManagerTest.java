package test.model.databaseManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import model.Action;
import model.Wallet;
import model.databaseManager.ActionManager;
import model.databaseManager.Database;
import model.databaseManager.WalletManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WalletManagerTest {
	private Database database = new Database();
	private ActionManager actionManager = new ActionManager(database);
	private WalletManager walletManager = new WalletManager(database);
	
	@Test
	public void addWalletOK(){
	    Action action = new Action();
	    action.setAdj(800);
	    actionManager.addAction(action);
	    Action action1 = new Action();
	    action.setAdj(805);
	    actionManager.addAction(action1);
	    Set<Action> actions = new HashSet<Action>();
	    actions.add(action);
	    actions.add(action1);
	    Wallet w = new Wallet(actions);
	    walletManager.addWallet(w);
	    
		@SuppressWarnings("static-access")
		Query query =
		database.ENTITY_MANAGER.createQuery("select w from Wallet w where w.id = :id");
		query.setParameter("id", w.getId());
		@SuppressWarnings("unchecked")
		List<Wallet> liste = (List<Wallet>)query.getResultList();
		Assert.assertEquals(2, liste.get(0).getActions().size());    
	}
}
