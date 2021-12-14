package base;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {
    protected SessionFactory sessionFactory;
    //protected Session session;

    public BaseDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
        //this.session = sessionFactory.openSession();
    }

    protected Session getCurrentSession(){
        Session session = sessionFactory.openSession();
        return session;
    }
}
