package ma.projet.service;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.classes.Categorie;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;

public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Categorie findById(int id) {
        Session session = null;
        Categorie e = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Categorie) session.get(Categorie.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return e;
    }

    @Override
    public List<Categorie> findAll() {
        Session session = null;
        List<Categorie> categories = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            categories = session.createQuery("from Categorie").list();
            session.getTransaction().commit();
            return categories;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return categories;
    }

}
