package nl.hu.dp.ov_chipkaart.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class ProductDAOHibernate implements ProductDAO{
    private SessionFactory sessionFactory;

    public ProductDAOHibernate(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public boolean save(Product product) throws SQLException {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.save(product);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public boolean delete(Product product) throws SQLException {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.delete(product);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.update(product);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public List<Product> getProductenbyOVChipkaart(ov_chipkaart ovchipkaart) throws SQLException {
        Session sessie = sessionFactory.openSession();
        ov_chipkaart chipkaart = sessie.createQuery(String.format("from ov_chipkaart where kaart_nummer = %s", ovchipkaart.getKaart_nummer()), ov_chipkaart.class).getSingleResult();
        return chipkaart.getProducten();
    }

//    @Override
//    public boolean deleteOV_chipkaartProductbyProduct_nummer(Product product) throws SQLException {
//        return false;
//    }

    @Override
    public List<Product> findall() throws SQLException {
        List<Product> producten = (List<Product>) sessionFactory.openSession().createQuery("FROM Product").getResultList();
        return producten;
    }

//    @Override
//    public Product findbyproductnummer(Product product) throws SQLException {
//        return null;
//    }


}
