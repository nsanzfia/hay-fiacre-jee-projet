package test.model.collectManager;

import java.util.List;

import javax.persistence.Query;

import model.Action;
import model.Bourse;
import model.Company;
import model.collectManager.Extract;
import model.databaseManager.Database;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExtractTest {
	private Extract extract = new Extract();
	private Database database = new Database();

	@SuppressWarnings("static-access")
	@Test
	public void downloadOK() {
		Assert.assertTrue(extract.download());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void insertTableActionOK() {
		Assert.assertTrue(extract.insertTableAction(database, "GOOG", 30));
		
		Query query =
		database.ENTITY_MANAGER.createQuery("select a from Action a");
		@SuppressWarnings("unchecked")
		List<Action> liste = (List<Action>)query.getResultList();
		Assert.assertEquals(30, liste.size());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void insertTableCompanyOK() {
		Assert.assertTrue(extract.insertTableCompany(database, "NASDAQ", 30));
		
		Query query =
		database.ENTITY_MANAGER.createQuery("select c from Company c");
		@SuppressWarnings("unchecked")
		List<Company> liste = (List<Company>)query.getResultList();
		Assert.assertEquals(30, liste.size());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void insertTableBourseOK() {
		extract.insertTableBourse(database);
		
		Query query =
		database.ENTITY_MANAGER.createQuery("select b from Bourse b");
		@SuppressWarnings("unchecked")
		List<Bourse> liste = (List<Bourse>)query.getResultList();
		Assert.assertEquals(3, liste.size());
	}
}
