package com.yaya.chrono.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Connexion {

	private static Session session = null;  
       
    public static Session configureSessionFactory() throws HibernateException {  
    	
    	final Configuration configuration = new Configuration().configure();
        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        final SessionFactory factory = configuration.buildSessionFactory(builder.build());
        session = factory.openSession();
    	
        return session; 
        
    	/*
    	Configuration configuration = new Configuration().configure();
    	configuration.configure("hibernate.cfg.xml");
         
    	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();*/
         
        //serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());          
        //sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());  
          
    }
}
