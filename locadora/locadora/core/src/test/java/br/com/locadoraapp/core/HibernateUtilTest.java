package br.com.locadoraapp.core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtilTest {

	private static final Logger LOG = LoggerFactory.getLogger(HibernateUtilTest.class);  
	  
    /** 
     * @param pathToHibernateCfgXml path to where hibernate.test.cfg.xml is located 
     *        if file is in /my/dir/with/my.cfg.xml, where name of config file is my.cfg.xml 
     *        then all all path with files name must be provided as parameter. 
     * @return Hibernate session factory. 
     */  
    public static SessionFactory newSessionFactory(final String pathToHibernateCfgXml) {
    	
        LOG.info("Loading Hibernate Session Factory with configurations from file "+ pathToHibernateCfgXml + "...");
        
        
        Configuration hibernateConfiguration = new Configuration();  
        hibernateConfiguration.configure(pathToHibernateCfgXml);  
        return hibernateConfiguration.buildSessionFactory();  
    }  
}
