package test.model.databaseManager;

import java.util.List;

import javax.persistence.Query;

import model.Client;
import model.Participation;
import model.Transaction;
import model.databaseManager.ClientManager;
import model.databaseManager.Database;
import model.databaseManager.ParticipationManager;
import model.databaseManager.TransactionManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParticipationManagerTest {
	private Database database = new Database();
	private ParticipationManager participationManager = new ParticipationManager(database);
	private TransactionManager transactionManager = new TransactionManager(database);
	private ClientManager clientManager = new ClientManager(database);
	
	@Test
	public void addParticipationOK() {
	    Client client = new Client();
	    client.setFirstName("Yohayoh");
	    clientManager.addClient(client);
	    Transaction t = new Transaction();
	    transactionManager.addTransaction(t);
	    Participation p = new Participation(client, t);
	    participationManager.addParticipation(p);
	    
		@SuppressWarnings("static-access")
		Query query =
		database.ENTITY_MANAGER.createQuery("select p from Participation p where p.client.id = :idClient and " +
				"p.transaction.id = :idTransaction");
		query.setParameter("idClient", client.getId());
		query.setParameter("idTransaction", t.getId());
		@SuppressWarnings("unchecked")
		List<Participation> liste = (List<Participation>)query.getResultList();
		Assert.assertNotNull(liste.get(0));
		Assert.assertTrue(liste.size() == 1);
	}
}
