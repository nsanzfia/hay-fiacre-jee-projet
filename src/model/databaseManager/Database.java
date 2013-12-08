package model.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Database {
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("jee-projet");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    public static final EntityTransaction ENTITY_TRANSACTION = ENTITY_MANAGER.getTransaction();
    
    public static void close() {
    	ENTITY_MANAGER_FACTORY.close();
    	ENTITY_MANAGER.close();
    }
}
