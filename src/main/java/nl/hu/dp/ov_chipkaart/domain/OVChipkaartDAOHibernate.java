package nl.hu.dp.ov_chipkaart.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO{
    private SessionFactory sessionFactory;

    public OVChipkaartDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean save(ov_chipkaart ov_chipkaart) throws SQLException {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.save(ov_chipkaart);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public boolean update(ov_chipkaart ov_chipkaart) throws SQLException {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.update(ov_chipkaart);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public boolean delete(ov_chipkaart ov_chipkaart) throws SQLException {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.delete(ov_chipkaart);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public List<ov_chipkaart> findall() throws SQLException {
        List<ov_chipkaart> ov_chipkaarten = (List<ov_chipkaart>) sessionFactory.openSession().createQuery("FROM ov_chipkaart").getResultList();
        return ov_chipkaarten;
    }

    @Override
    public ov_chipkaart findbyId(int id) throws SQLException {
        ov_chipkaart ovChipkaart = (ov_chipkaart) sessionFactory.openSession().createQuery("FROM ov_chipkaart WHERE kaart_nummer = " + id).getSingleResult();
        return ovChipkaart;
    }

    @Override
    public List<ov_chipkaart> findbyReiziger(Reiziger reiziger) throws SQLException {
        return null;
    }

    @Override
    public List<ov_chipkaart> getOVChipkaartenbyProduct(Product product) throws SQLException {
        Session sessie = sessionFactory.openSession();
        Product product1 = sessie.createQuery(String.format("from Product where product_nummer = %s", product.getProduct_nummer()), Product.class).getSingleResult();
        return product1.getOvchipkaarten();
    }
}
