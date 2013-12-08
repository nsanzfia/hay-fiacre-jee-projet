package model.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Transaction;

public class TransactionManager {
	private EntityManager entityManager = null;
    private EntityTransaction entityTransaction = null;
	
    @SuppressWarnings("static-access")
	public TransactionManager(Database database) {
    	entityManager = database.ENTITY_MANAGER;
		entityTransaction = database.ENTITY_TRANSACTION;
	}
    
    public void addTransaction(Transaction transaction) {
    	entityTransaction.begin();
    	entityManager.persist(transaction);
    	entityTransaction.commit();
    }
}
