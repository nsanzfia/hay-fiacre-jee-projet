package test.model.databaseManager;

import java.util.List;

import javax.persistence.Query;

import model.Account;
import model.Client;
import model.Wallet;
import model.databaseManager.AccountManager;
import model.databaseManager.ClientManager;
import model.databaseManager.Database;
import model.databaseManager.WalletManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClientManagerTest {
	private Database database = new Database();
	private WalletManager walletManager = new WalletManager(database);
	private AccountManager accountManager = new AccountManager(database);
	private ClientManager clientManager = new ClientManager(database);
	
	@Test
	public void addClientOK() {
		Wallet w = new Wallet();
		walletManager.addWallet(w);
		Account a = new Account(400, w);
		accountManager.addAccount(a);
		Client client = new Client("clientManagerTest", "clientManagerTest", a);
		clientManager.addClient(client);
		
		@SuppressWarnings("static-access")
		Query query =
		database.ENTITY_MANAGER.createQuery("select c from Client c where c.firstName = :name");
		query.setParameter("name", client.getFirstName());
		@SuppressWarnings("unchecked")
		List<Client> liste = (List<Client>)query.getResultList();
		Assert.assertEquals(a.getId(), liste.get(0).getAccount().getId());
}

}
