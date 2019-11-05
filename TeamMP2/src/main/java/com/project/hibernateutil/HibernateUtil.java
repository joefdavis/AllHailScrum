package com.project.hibernateutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	private static Session sess;
    private static SessionFactory sf = new Configuration()
            .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    
    public static Session getSession() {
        if(sess==null) {
            sess=sf.openSession();
        }
        return sess;
    }
    
    public static void closeSess() {
        sess.close();
    }
}
