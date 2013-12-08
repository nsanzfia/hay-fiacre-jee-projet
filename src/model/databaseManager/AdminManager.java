package model.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Admin;

public class AdminManager {
	private EntityManager entityManager = null;
    private EntityTransaction entityTransaction = null;
	
    @SuppressWarnings("static-access")
	public AdminManager(Database database) {
    	entityManager = database.ENTITY_MANAGER;
		entityTransaction = database.ENTITY_TRANSACTION;
	}
    
    public void addAdmin(Admin admin) {
    	entityTransaction.begin();
    	entityManager.persist(admin);
    	entityTransaction.commit();
    }

}
