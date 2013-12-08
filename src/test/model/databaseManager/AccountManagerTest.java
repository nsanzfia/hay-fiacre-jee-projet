package test.model.databaseManager;

import java.util.List;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import model.Account;
import model.Wallet;
import model.databaseManager.AccountManager;
import model.databaseManager.Database;
import model.databaseManager.WalletManager;

@RunWith(JUnit4.class)
public class AccountManagerTest {
	private Database database = new Database();
	private WalletManager walletManager = new WalletManager(database);
	private AccountManager accountManager = new AccountManager(database);
	
	@Test
	public void addAccountK() {
		Wallet w = new Wallet();
		walletManager.addWallet(w);
		Account account = new Account(300, w);
		accountManager.addAccount(account);
		
		@SuppressWarnings("static-access")
		Query query =
		database.ENTITY_MANAGER.createQuery("select a from Account a where a.wallet.id = :id");
		query.setParameter("id", w.getId());
		@SuppressWarnings("unchecked")
		List<Account> liste = (List<Account>)query.getResultList();
		Assert.assertEquals(w.getId(), liste.get(0).getWallet().getId());
	}

}
