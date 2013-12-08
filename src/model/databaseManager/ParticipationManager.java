package model.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Participation;

public class ParticipationManager {
	private EntityManager entityManager = null;
    private EntityTransaction entityTransaction = null;
	
    @SuppressWarnings("static-access")
	public ParticipationManager(Database database) {
    	entityManager = database.ENTITY_MANAGER;
		entityTransaction = database.ENTITY_TRANSACTION;
	}
    
    public void addParticipation(Participation participation) {
    	entityTransaction.begin();
    	entityManager.persist(participation);
    	entityTransaction.commit();
    }
}
