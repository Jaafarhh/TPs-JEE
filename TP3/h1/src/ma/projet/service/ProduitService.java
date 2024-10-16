package ma.projet.service;

import java.util.Date;
import ma.projet.dao.IDao;
import ma.projet.entity.Produit;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;

public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
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
    public boolean delete(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(o);
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
    public boolean update(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(o);
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
    public Produit findById(int id) {
        Session session = null;
        Produit e = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Produit) session.get(Produit.class, id);
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
    public List<Produit> findAll() {
        Session session = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            session.getTransaction().commit();
            return produits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return produits;
    }
    
    public List<Produit> findByDate(Date start, Date end) {
    Session session = null;
    List<Produit> produits = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        produits = session.createQuery("from Produit p where p.dateAchat between :start and :end")
                          .setParameter("start", start)
                          .setParameter("end", end)
                          .list();
        session.getTransaction().commit();
    } catch (HibernateException e) {
        if (session != null) {
            session.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return produits;
}

}
