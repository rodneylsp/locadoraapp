package br.com.locadoraapp.core;



import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;

public abstract class HibernateDbUnitTestCase extends DBTestCase{

	private static SessionFactory factory;
	protected Session session;
	
	public HibernateDbUnitTestCase() {
	
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.postgresql.Driver");  
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:postgresql://localhost:5432/db_locadora_teste");  
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");  
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root");
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset.xml"));
	} 
	
	
	@Before
	public void setUp() throws Exception {
		
		if(factory == null) {
			factory = HibernateUtilTest.newSessionFactory("hibernate.cfg.xml");
		}
		
		session = factory.openSession();
		
		super.setUp();
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		session.close();
		super.tearDown();
	}
	
	
	protected DatabaseOperation getSetUpOperation() {
		return DatabaseOperation.CLEAN_INSERT;
	}
	
	protected DatabaseOperation getTearDownOperation() {
		return DatabaseOperation.NONE;
	}
	
}
