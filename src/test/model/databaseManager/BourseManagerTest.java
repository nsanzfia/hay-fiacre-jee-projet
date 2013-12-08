package test.model.databaseManager;

import java.util.List;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import model.Bourse;
import model.databaseManager.BourseManager;
import model.databaseManager.Database;

@RunWith(JUnit4.class)
public class BourseManagerTest {
	private Database database = new Database();
	private BourseManager bourseManager = new BourseManager(database);
	
	@Test
	public void addBourseOK() {
		Bourse b = new Bourse("bourseManagerTest");
		bourseManager.addBourse(b);
		
		@SuppressWarnings("static-access")
		Query query =
		database.ENTITY_MANAGER.createQuery("select b from Bourse b where b.id = :id");
		query.setParameter("id", b.getId());
		@SuppressWarnings("unchecked")
		List<Bourse> liste = (List<Bourse>)query.getResultList();
		Assert.assertEquals(b.getName(), liste.get(0).getName());
	}
	
}
