package test.model.databaseManager;

import java.util.List;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import model.Company;
import model.databaseManager.CompanyManager;
import model.databaseManager.Database;

@RunWith(JUnit4.class)

public class CompanyManagerTest {
	private Database database = new Database();
	private CompanyManager companyManager = new CompanyManager(database);
	
	@Test
	public void addCompanyOK() {
	    Company company = new Company("CompanyManagerTest","CompanyManagerTest",200,200,
	    		"CompanyManagerTest", "CompanyManagerTest", "CompanyManagerTest", 
	    		"CompanyManagerTest", "CompanyManagerTest");
	    companyManager.addCompany(company);
	    
	    @SuppressWarnings("static-access")
		Query query =
	    database.ENTITY_MANAGER.createQuery("select c from Company c where c.name = :name");
	    query.setParameter("name", company.getName());
	    @SuppressWarnings("unchecked")
	    List<Company> liste = (List<Company>)query.getResultList();
	    Assert.assertEquals((int)company.getLastSale(), (int)liste.get(0).getLastSale());
	}

}
