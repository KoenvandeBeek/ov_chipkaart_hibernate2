package nl.hu.dp.ov_chipkaart;

import nl.hu.dp.ov_chipkaart.domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MainP7 {

    public static void main(String[] args) throws SQLException {
        testReizigerDAO();
        testAdresDAO();
        testOVChipkaartDAO();
        testProductDAO();
    }
        public static void testReizigerDAO() throws SQLException {
            Configuration config = new Configuration();
            config.configure();
            // local SessionFactory bean created
            SessionFactory sessionFactory = config.buildSessionFactory();

            ReizigerDAO rdao = new ReizigerDAOHibernate(sessionFactory);

            System.out.println("\n---------- Test ReizigerDAO -------------");

            // Haal alle reizigers op uit de database
            List<Reiziger> reizigers = rdao.findAll();
            System.out.println("[Test] alle reizigers:");
            for (Reiziger r : reizigers) {
                System.out.println(r);
            }
            System.out.println();

            // Maak een nieuwe reiziger aan en persisteer deze in de database
            String gbdatum = "1981-03-14";
            Reiziger sietske = new Reiziger("S", "", "Boers", Date.valueOf(gbdatum));
            sietske.setReiziger_id(157);
            System.out.print("[Test] voor toevoegen nieuwe reiziger" + reizigers.size() + " reizigers, na toevoegen nieuwe reiziger:");
            rdao.save(sietske);
            reizigers = rdao.findAll();
            System.out.println(reizigers.size() + " reizigers\n");

            // Voeg aanvullende tests van de ontbrekende CRUD-operaties in.

            // reiziger gegevens aanpassen
            System.out.println("[Test] Reiziger eerst");
            System.out.println(rdao.findById(sietske.getReiziger_id()));
//        Reiziger Lars = new Reiziger("L", "T", "Boers", Date.valueOf(gbdatum));
//        Lars.setReiziger_id(sietske.getReiziger_id());
            sietske.setAchternaam("Beek");
            rdao.update(sietske);
            System.out.println("\t na ReizigerDAO.update():");
            System.out.println(rdao.findById(sietske.getReiziger_id()));
            System.out.println();

            // reiziger verwijderen uit database
            System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.delete():");
            rdao.delete(sietske);
            reizigers = rdao.findAll();
            System.out.println(reizigers.size() + " reizigers");
            System.out.println();

            // reiziger zoeken met id
            System.out.println("[Test] findByID test met id = 5");
            System.out.println(rdao.findById(5));
            System.out.println();

            //reiziger zoeken met geboortedatum
            System.out.println("[Test] findByGbdatum met geboortedatum 2002-12-03");
//            String geboortedatum = "2002-12-03";
            List<Reiziger> reizigerss = rdao.findByGbdatum("2002-12-03");
            for (Reiziger r : reizigerss) {
                System.out.println(r);
            }
            System.out.println();
        }
    private static void testAdresDAO() throws SQLException {
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        ReizigerDAO rdao = new ReizigerDAOHibernate(sessionFactory);
        AdresDAO adao = new AdresDAOHibernate(sessionFactory);

        System.out.println("\n---------- Test AdresDAO -------------");

        // Alle adressen ophalen uit de database
        List<Adres> adressen = adao.findAll();
        System.out.println("[Test] alle adressen:");
        for (Adres a : adressen) {
            System.out.println("\t"+a);
        }
        System.out.println();

        // adres toevoegen aan de database
        String gbdatum = "1981-03-14";
        Reiziger r = new Reiziger( "S", "T", "Boers", Date.valueOf(gbdatum));
        r.setReiziger_id(160);
        rdao.save(r);
        Adres a = new Adres("3424SW", "32", "langestraat", "Utrecht");
//        a.setReiziger(r);
        a.setAdres_id(12);
        System.out.print("[Test] voor toevoegen nieuw adres" + adressen.size() + " na toevoegen nieuw adres:");
        a.setReiziger(r);
        r.setAdres(a);

        adao.save(a);
        adressen = adao.findAll();
        System.out.println(adressen.size() + " adressen\n");

        // gegevens veranderen adres
        System.out.println("[Test] voor aanpassen adres");
        gbdatum = "2002-09-17";
        Reiziger gerrit = new Reiziger("G","van","Rijn",Date.valueOf(gbdatum));
        gerrit.setReiziger_id(5);
        Adres adres = adao.findByReiziger(gerrit);
        System.out.println(adres);
        adres.setStraat("vischersplein");
        adao.update(adres);
        System.out.println("na aanpassen adres:");
        adres = adao.findByReiziger(gerrit);
        System.out.println(adres);
        System.out.println();

//         adres vinden met reiziger
        System.out.println("[Test] adres van reiziger met reiziger_id: 1, voorletter: G, tussenvoegsel: van, achternaam: Rijn en geboortedatum: 2002-09-17");
        gbdatum = "2002-09-17";
        Reiziger r1 = new Reiziger("G","van","Rijn",Date.valueOf(gbdatum));
        r1.setReiziger_id(5);
        adres = adao.findByReiziger(r1);
        System.out.println(adres);
        System.out.println();

        // adres verwijderen
        System.out.print("[Test] voor adres verwijderen " + adressen.size() + "adressen na adres verwijderen: ");
        adao.delete(a);
        adressen = adao.findAll();
        System.out.println(adressen.size() + " adressen");
        rdao.delete(r);
        System.out.println();



    }
    private static void testOVChipkaartDAO() throws SQLException {
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        ReizigerDAO rdao = new ReizigerDAOHibernate(sessionFactory);
        OVChipkaartDAO OVdao = new OVChipkaartDAOHibernate(sessionFactory);
        rdao.setOVdao(OVdao);
        System.out.println("\n---------- Test OVCHipkaartDAO -------------");

        List<ov_chipkaart> ovchipkaarten = OVdao.findall();
        System.out.println("[Test] alle ovchipkaarten:");
        for (ov_chipkaart OVchip : ovchipkaarten) {
            System.out.println("\t"+OVchip);
        }
        System.out.println();

        //test reiziger
        String gbdatum1 = "1980-03-14";
        Reiziger r4 = new Reiziger("R", "", "Ossenwaarde", Date.valueOf(gbdatum1));
        r4.setReiziger_id(161);
        String geldig_tot1 = "2021-12-15";
        ov_chipkaart ov2 = new ov_chipkaart(Date.valueOf(geldig_tot1), 2, 10.00);
        ov2.setKaart_nummer(90718);
        ov2.setReiziger(r4);
        r4.addOVChipkaart(ov2);
        String geldig_tot2 = "2021-12-15";
        ov_chipkaart ov1 = new ov_chipkaart(Date.valueOf(geldig_tot2), 2, 10.00);
        ov1.setKaart_nummer(90719);
        ov1.setReiziger(r4);
        r4.addOVChipkaart(ov1);
        rdao.save(r4);
        System.out.println(r4.getOvchipkaarts().size());
        // java object en database bevat twee ov chipkaarten verbonden met r
        ov_chipkaart ov3 = new ov_chipkaart(Date.valueOf(geldig_tot2), 1, 10.00);
        r4.removeOVChipkaart(ov1);
        r4.addOVChipkaart(ov3);
        rdao.update(r4);
        System.out.println(r4.getOvchipkaarts().size());
    }
    public static void testProductDAO() throws SQLException {
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        ReizigerDAO rdao = new ReizigerDAOHibernate(sessionFactory);
        ProductDAO pdao = new ProductDAOHibernate(sessionFactory);
        OVChipkaartDAO OVdao = new OVChipkaartDAOHibernate(sessionFactory);
        System.out.println("\n---------- Test ProductDAO -------------");

        List<Product> producten = pdao.findall();
        System.out.println("[Test] alle producten:");
        for (Product product : producten) {
            System.out.println("\t"+product);
        }

        //test ovchipkaart aanmaken met 2 producten
        String geldig_tot1 = "2021-12-15";
        ov_chipkaart ov1 = new ov_chipkaart(Date.valueOf(geldig_tot1), 2, 10.00);
        ov1.setKaart_nummer(90723);
        ov1.setReiziger(rdao.findById(1));
        Product p1 = new Product("fiets", "mooie fiets", 100);
        p1.setProduct_nummer(102);
        pdao.save(p1);
        Product p2 = new Product("auto", "mooie auto", 100);
        p2.setProduct_nummer(103);
        pdao.save(p2);
        ov1.addProduct(p1);
        ov1.addProduct(p2);
        OVdao.save(ov1);
        System.out.println(OVdao.findall().size());
        //test ovchipkaart aanpassen met een product te verwijderen van 1 ovchipkaart_product
        System.out.println("[Test] ovchipkaart voor aanpassen ovchipkaart en verwijderen van 1 product van het object: "+ OVdao.findbyId(ov1.getKaart_nummer()));
        ov1.setGeldig_tot(Date.valueOf("2021-12-16"));
        Product p3 = new Product("auto", "mooie auto", 100);
        p3.setProduct_nummer(104);
        pdao.save(p3);
        ov1.addProduct(p3);
        OVdao.update(ov1);
        System.out.println();
        System.out.println("ovchipkaart na het aanpassen van de ovchipkaart: " + OVdao.findbyId(ov1.getKaart_nummer()));
        //delete ovchipkaart + connecties met producten
        System.out.println();
        System.out.print("[Test] Eerst " + OVdao.findall().size());
        OVdao.delete(ov1);
        System.out.println( " ovchipkaarten, na OVChipkaartDAO.delete():" + OVdao.findall().size());
        //test producten ophalen gekoppeld aan ovchipkaart met ovchipkaart
        System.out.println();
        System.out.println("producten gekoppeld aan ovchipkaart met kaartnummer 35283");
        String geldig_tot2 = "2021-12-15";
        ov_chipkaart ov2 = new ov_chipkaart(Date.valueOf(geldig_tot2), 2, 10.00);
        ov2.setKaart_nummer(35283);
        ov2.setReiziger(rdao.findById(2));
        for(Product p: pdao.getProductenbyOVChipkaart(ov2)){
            System.out.println("\t" + p);
        }
        System.out.println();
        System.out.println("producten gekoppeld aan ovchipkaart met kaartnummer 68514");
        String geldig_tot3 = "2021-12-15";
        ov_chipkaart ov3 = new ov_chipkaart(Date.valueOf(geldig_tot3), 1, 2.50);
        ov3.setKaart_nummer(68514);
        ov3.setReiziger(rdao.findById(3));
        for(Product p: pdao.getProductenbyOVChipkaart(ov3)){
            System.out.println("\t" + p);
        }
        //test ovchipkaarten ophalen die gekoppeld zijn met product via product
        System.out.println();
        System.out.println("ovchipkaarten gekoppeld aan product met product_nummer 6");
        Product product = new Product("Studentenreisproduct", "Gratis of met korting reizen als je studeert", 0);
        product.setProduct_nummer(6);
        for(ov_chipkaart ovChipkaart : OVdao.getOVChipkaartenbyProduct(product)){
            System.out.println("\t" + ovChipkaart);
        }
        System.out.println();
        System.out.println("ovchipkaarten gekoppeld aan product met product_nummer 2");
        Product product1 = new Product("Studentenreisproduct", "Gratis of met korting reizen als je studeert", 0);
        product1.setProduct_nummer(2);
        for(ov_chipkaart ovChipkaart : OVdao.getOVChipkaartenbyProduct(product1)){
            System.out.println("\t" + ovChipkaart);
        }
        System.out.println();
        System.out.println("ovchipkaarten gekoppeld aan product met product_nummer 1");
        Product product2 = new Product("Studentenreisproduct", "Gratis of met korting reizen als je studeert", 0);
        product2.setProduct_nummer(1);
        for(ov_chipkaart ovChipkaart : OVdao.getOVChipkaartenbyProduct(product2)){
            System.out.println("\t" + ovChipkaart);
        }
    }
}
