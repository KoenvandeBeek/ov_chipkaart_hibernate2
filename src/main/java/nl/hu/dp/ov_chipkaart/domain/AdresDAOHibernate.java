package nl.hu.dp.ov_chipkaart.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AdresDAOHibernate implements AdresDAO{

    private SessionFactory sessionFactory;

    public AdresDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public boolean save(Adres adres) {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.save(adres);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public boolean update(Adres adres) {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.update(adres);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public boolean delete(Adres adres) {
        Session sessie = sessionFactory.openSession();
        sessie.beginTransaction();
        sessie.delete(adres);
        sessie.getTransaction().commit();
        sessie.close();
        return true;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        Adres adres = (Adres) sessionFactory.openSession().createQuery("FROM Adres WHERE reiziger = " + reiziger.getReiziger_id()).getSingleResult();
        return adres;
    }

    @Override
    public List<Adres> findAll() {
        List<Adres> adres = (List<Adres>) sessionFactory.openSession().createQuery("FROM Adres").getResultList();
        return adres;
    }

    @Override
    public void setRdao(ReizigerDAO rdao) {

    }
}
