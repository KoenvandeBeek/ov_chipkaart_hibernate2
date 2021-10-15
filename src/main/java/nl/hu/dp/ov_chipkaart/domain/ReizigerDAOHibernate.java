package nl.hu.dp.ov_chipkaart.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO{

    private SessionFactory sessionFactory;

    private OVChipkaartDAO ovChipkaartDAO;

    public ReizigerDAOHibernate(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean save(Reiziger reiziger) throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        ovChipkaartDAO = new OVChipkaartDAOHibernate(sessionFactory);
        for(ov_chipkaart ovchipkaart : reiziger.getOvchipkaarts()){
            ovchipkaart.setReiziger(reiziger);
            ovChipkaartDAO.save(ovchipkaart);
        }
        session.save(reiziger);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reiziger reiziger) throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(reiziger);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Reiziger reiziger) throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(reiziger);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Reiziger findById(int id) throws SQLException {
        Reiziger reiziger = (Reiziger) sessionFactory.openSession().createQuery("FROM Reiziger WHERE reiziger_id = " + id).getSingleResult();
        return reiziger;
    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) throws SQLException {
//        Date datedatum  = (datum);
        List<Reiziger> reizigersgb = (List<Reiziger>) sessionFactory.openSession().createQuery("FROM Reiziger WHERE geboortedatum = '" + Date.valueOf(datum) + "'").getResultList();
        return reizigersgb;
    }

    @Override
    public List<Reiziger> findAll() throws SQLException {
        List<Reiziger> reizigers = (List<Reiziger>) sessionFactory.openSession().createQuery("FROM Reiziger").getResultList();
        return reizigers;
    }

    @Override
    public void setAdao(AdresDAO adao) {

    }

    @Override
    public void setOVdao(OVChipkaartDAO OVDao) {

    }
}
