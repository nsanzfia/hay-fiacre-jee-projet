package test.model.databaseManager;

import java.util.List;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import model.Admin;
import model.databaseManager.AdminManager;
import model.databaseManager.Database;

@RunWith(JUnit4.class)
public class AdminManagerTest {
	private Database database = new Database();
	private AdminManager adminManager = new AdminManager(database);
	
	@Test
	public void addAccountOK() {
		Admin a = new Admin("managerTest", "ManagerTest");
		adminManager.addAdmin(a);		
		
		@SuppressWarnings("static-access")
		Query query =
		database.ENTITY_MANAGER.createQuery("select a from Admin a where a.firstName = :name");
		query.setParameter("name", a.getFirstName());
		@SuppressWarnings("unchecked")
		List<Admin> liste = (List<Admin>)query.getResultList();
		Assert.assertEquals(1, liste.size());
	}
	

}
