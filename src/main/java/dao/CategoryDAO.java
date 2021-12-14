package dao;

import base.BaseDAO;
import entity.Category;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDAO extends BaseDAO {
    //private SessionFactory sessionFactory;

    public CategoryDAO() {
       //essionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Category> findAll() {
       //ession session = sessionFactory.openSession();

        Query query =  getCurrentSession().createQuery("select category from Category category");

        return  query.list();
    }
}
