package com.ora.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {static EntityManagerFactory factory=null;

public static EntityManagerFactory getFactory()
{
	if(factory==null)
		factory=Persistence.createEntityManagerFactory("JPA-PU");
	
	return factory;
}

public static EntityManager getEntityManager()
{
	return getFactory().createEntityManager();
	
}


}

