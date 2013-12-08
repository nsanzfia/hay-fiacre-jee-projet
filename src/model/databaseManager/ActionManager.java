package model.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Action;

public class ActionManager {
	private EntityManager entityManager = null;
    private EntityTransaction entityTransaction = null;
	
    @SuppressWarnings("static-access")
	public ActionManager(Database database) {
    	entityManager = database.ENTITY_MANAGER;
		entityTransaction = database.ENTITY_TRANSACTION;
	}
    
    public void addAction(Action action) {
    	entityTransaction.begin();
    	entityManager.persist(action);
    	entityTransaction.commit();
    }

}
