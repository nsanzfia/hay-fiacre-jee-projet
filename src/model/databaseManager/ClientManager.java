package model.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Client;

public class ClientManager {
	private EntityManager entityManager = null;
    private EntityTransaction entityTransaction = null;
	
    @SuppressWarnings("static-access")
	public ClientManager(Database database) {
    	entityManager = database.ENTITY_MANAGER;
		entityTransaction = database.ENTITY_TRANSACTION;
	}
    
    public void addClient(Client client) {
    	entityTransaction.begin();
    	entityManager.persist(client);
    	entityTransaction.commit();
    }
}
