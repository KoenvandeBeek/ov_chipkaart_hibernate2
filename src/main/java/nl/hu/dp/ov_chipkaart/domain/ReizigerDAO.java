package nl.hu.dp.ov_chipkaart.domain;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ReizigerDAO {
    boolean save(Reiziger reiziger) throws SQLException;
    boolean update(Reiziger reiziger) throws SQLException;
    boolean delete(Reiziger reiziger) throws SQLException;
    Reiziger findById(int id) throws SQLException;
    List<Reiziger> findByGbdatum(String datum) throws SQLException;
    List<Reiziger> findAll() throws SQLException;
    void setOVdao(OVChipkaartDAO OVDao);
}
