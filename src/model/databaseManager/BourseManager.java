package model.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Bourse;

public class BourseManager {
	private EntityManager entityManager = null;
    private EntityTransaction entityTransaction = null;
	
    @SuppressWarnings("static-access")
	public BourseManager(Database database) {
    	entityManager = database.ENTITY_MANAGER;
		entityTransaction = database.ENTITY_TRANSACTION;
	}
    
    public void addBourse(Bourse bourse) {
    	entityTransaction.begin();
    	entityManager.persist(bourse);
    	entityTransaction.commit();
    }

}
