package nl.hu.dp.ov_chipkaart.domain;

import java.sql.SQLException;
import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO{
    @Override
    public boolean save(ov_chipkaart ov_chipkaart) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ov_chipkaart ov_chipkaart) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(ov_chipkaart ov_chipkaart) throws SQLException {
        return false;
    }

    @Override
    public List<ov_chipkaart> findall() throws SQLException {
        return null;
    }

    @Override
    public ov_chipkaart findbyId(int id) throws SQLException {
        return null;
    }

    @Override
    public List<ov_chipkaart> findbyReiziger(Reiziger reiziger) throws SQLException {
        return null;
    }

    @Override
    public void setRdao(ReizigerDAO rdao) {

    }

    @Override
    public void setPdao(ProductDAO pdao) {

    }

    @Override
    public boolean saveOVChipkaart_product(ov_chipkaart ov_chipkaart, Product product) throws SQLException {
        return false;
    }

    @Override
    public List<ov_chipkaart> getOVChipkaartenbyProduct(Product product) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteOV_chipkaartProductbyKaart_nummer(ov_chipkaart ov_chipkaart) throws SQLException {
        return false;
    }
}
