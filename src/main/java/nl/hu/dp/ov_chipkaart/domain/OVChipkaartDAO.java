package nl.hu.dp.ov_chipkaart.domain;

import java.sql.SQLException;
import java.util.List;

public interface OVChipkaartDAO {
    boolean save(ov_chipkaart ov_chipkaart) throws SQLException;
    boolean update(ov_chipkaart ov_chipkaart) throws SQLException;
    boolean delete(ov_chipkaart ov_chipkaart) throws SQLException;
    List<ov_chipkaart> findall() throws SQLException;
    ov_chipkaart findbyId(int id) throws SQLException;
    List<ov_chipkaart> findbyReiziger(Reiziger reiziger) throws SQLException;
    void setRdao(ReizigerDAO rdao);
    void setPdao(ProductDAO pdao);
    boolean saveOVChipkaart_product(ov_chipkaart ov_chipkaart, Product product) throws SQLException;
    List<ov_chipkaart> getOVChipkaartenbyProduct(Product product) throws SQLException;
    boolean deleteOV_chipkaartProductbyKaart_nummer(ov_chipkaart ov_chipkaart) throws SQLException;

}
