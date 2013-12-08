package model.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Wallet;

public class WalletManager {
	private EntityManager entityManager = null;
    private EntityTransaction entityTransaction = null;
	
    @SuppressWarnings("static-access")
	public WalletManager(Database database) {
    	entityManager = database.ENTITY_MANAGER;
		entityTransaction = database.ENTITY_TRANSACTION;
	}
    
    public void addWallet(Wallet wallet) {
    	entityTransaction.begin();
    	entityManager.persist(wallet);
    	entityTransaction.commit();
    }
}
