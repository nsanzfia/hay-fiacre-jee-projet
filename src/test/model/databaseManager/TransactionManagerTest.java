package test.model.databaseManager;

import java.util.List;

import javax.persistence.Query;

import model.Transaction;
import model.databaseManager.Database;
import model.databaseManager.TransactionManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TransactionManagerTest {
	private Database database = new Database();
	private TransactionManager transactionManager = new TransactionManager(database);
	
	@Test
	public void addTransactionOK() {
	    Transaction t = new Transaction(0, "transactionManagerTest");
	    transactionManager.addTransaction(t);
	    
		@SuppressWarnings("static-access")
		Query query =
		database.ENTITY_MANAGER.createQuery("select t from Transaction t where t.id = :id");
		query.setParameter("id", t.getId());
		@SuppressWarnings("unchecked")
		List<Transaction> liste = (List<Transaction>)query.getResultList();
		Assert.assertEquals(t.getComment(), liste.get(0).getComment());
	}
}
