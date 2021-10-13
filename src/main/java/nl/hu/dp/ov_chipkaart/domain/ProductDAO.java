package nl.hu.dp.ov_chipkaart.domain;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    boolean save(Product product) throws SQLException;
    boolean delete(Product product) throws SQLException;
    boolean update(Product product) throws SQLException;
    List<Product> getProductenbyOVChipkaart(ov_chipkaart ovchipkaart) throws SQLException;
    boolean deleteOV_chipkaartProductbyProduct_nummer(Product product) throws SQLException;
    List<Product> findall() throws SQLException;
    Product findbyproductnummer(Product product) throws SQLException;
    void setOVdao(OVChipkaartDAO OVdao);
}
