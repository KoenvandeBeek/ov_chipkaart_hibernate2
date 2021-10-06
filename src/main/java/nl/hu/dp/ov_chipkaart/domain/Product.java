package nl.hu.dp.ov_chipkaart.domain;

import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Product {
    @Id
    @Column(name = "product_nummer")
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private int prijs;
    @Transient
    private List<OVChipkaart> ovchipkaarten = new ArrayList<>();

    public Product(){}
    public Product(String naam, String beschrijving, int prijs) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int product_nummer) {
        this.product_nummer = product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public List<OVChipkaart> getOvchipkaarten() {
        return ovchipkaarten;
    }

    public void setOvchipkaarten(List<OVChipkaart> ovchipkaarten) {
        this.ovchipkaarten = ovchipkaarten;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public String toString(){
        return "naam: " + "" + naam + ", " + "beschrijving: " + " " + beschrijving  + ", " + "prijs: " + " " + prijs;
    }
}
