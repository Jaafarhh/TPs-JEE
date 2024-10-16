package ma.projet.service;

import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;

public class CommandeService implements IDao<Commande> {

    @Override
    public boolean create(Commande o) {
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
    public Commande findById(int id) {
        Session session = null;
        Commande e = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Commande) session.get(Commande.class, id);
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
    public List<Commande> findAll() {
        Session session = null;
        List<Commande> commandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            commandes = session.createQuery("from Commande").list();
            session.getTransaction().commit();
            return commandes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return commandes;
    }

    public void afficherProduitsCommande(int commandeId) {
        Session session = null;
        Commande c = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            c = (Commande) session.get(Commande.class, commandeId);
            String hql = "SELECT lcp FROM LigneCommandeProduit lcp "
                    + "JOIN FETCH lcp.produit "
                    + "WHERE lcp.commande.id = :commandeId";
            List<LigneCommandeProduit> lignesCommande = session.createQuery(hql)
                    .setParameter("commandeId", commandeId)
                    .list();
            System.out.println("Commande : " + c.getId() + "\t Date : "
                    + new SimpleDateFormat("dd MMMM yyyy").format(c.getDate()));
            System.out.println("Liste des produits :");
            System.out.println("Référence\tPrix\t\tQuantité");

            for (LigneCommandeProduit lcp : lignesCommande) {
                Produit produit = lcp.getProduit();
                System.out.printf("%s\t\t%.2f DH\t%d%n",
                        produit.getReference(),
                        produit.getPrix(),
                        lcp.getQuantite());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
