package hibernate;

import org.hibernate.SessionFactory;


import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory = buildSessionFactory();

    private static  SessionFactory buildSessionFactory(){
        try {
            Configuration cfg = new Configuration();

            //cfg.addAnnotatedClass(FirstEntity.class);

            SessionFactory sessionFactory = cfg.configure("hibernet.cfg.xml").buildSessionFactory();

            return sessionFactory;
        } catch (Exception e){

            System.out.println("Session factory oluşturulurken hata oluştu" + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
