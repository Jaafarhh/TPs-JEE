package metier;


import dao.IDao;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class ProductDaoImpl implements IDao<Product> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(Product prod) {
        Session session = sessionFactory.getCurrentSession();
        session.save(prod);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Product prod) {
        Session session = sessionFactory.getCurrentSession();
        session.update(prod);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Product prod) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(prod);
        return true;
    }

    @Override
    @Transactional
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product").list();
    }
}
