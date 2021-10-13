package nl.hu.dp.ov_chipkaart.domain;

import java.sql.SQLException;
import java.util.List;

public class ProductDAOHibernate implements ProductDAO{
    @Override
    public boolean save(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }

    @Override
    public List<Product> getProductenbyOVChipkaart(ov_chipkaart ovchipkaart) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteOV_chipkaartProductbyProduct_nummer(Product product) throws SQLException {
        return false;
    }

    @Override
    public List<Product> findall() throws SQLException {
        return null;
    }

    @Override
    public Product findbyproductnummer(Product product) throws SQLException {
        return null;
    }

    @Override
    public void setOVdao(OVChipkaartDAO OVdao) {

    }
}
