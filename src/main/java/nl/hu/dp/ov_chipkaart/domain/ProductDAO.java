package nl.hu.dp.ov_chipkaart.domain;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    boolean save(Product product) throws SQLException;
    boolean delete(Product product) throws SQLException;
    boolean update(Product product) throws SQLException;
    List<Product> getProductenbyOVChipkaart(ov_chipkaart ovchipkaart) throws SQLException;
    List<Product> findall() throws SQLException;
}
