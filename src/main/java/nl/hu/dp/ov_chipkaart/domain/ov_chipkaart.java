package nl.hu.dp.ov_chipkaart.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ov_chipkaart {
    @Id
//    @GeneratedValue
    @Column(name = "kaart_nummer")
    private int kaart_nummer;
    private Date geldig_tot;
    private int klasse;
    private double saldo;
    @ManyToOne
    @JoinColumn(name = "reiziger_id", foreignKey = @ForeignKey(name = "kaart_nummer"))
    private Reiziger reiziger;
    @ManyToMany
    @JoinTable(name = "ov_chipkaart_product",
            joinColumns = { @JoinColumn(name = "kaart_nummer")},
            inverseJoinColumns = {@JoinColumn(name = "product_nummer")}
    )
    private List<Product> producten = new ArrayList<>();

    public ov_chipkaart(){

    }

    public ov_chipkaart(Date geldig_tot, int klasse, double saldo) {
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
    }

    public int getKaart_nummer() {
        return kaart_nummer;
    }

    public void setKaart_nummer(int kaart_nummer) {
        this.kaart_nummer = kaart_nummer;
    }

    public Date getGeldig_tot() {
        return geldig_tot;
    }

    public void setGeldig_tot(Date geldig_tot) {
        this.geldig_tot = geldig_tot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void addProduct(Product product){
        producten.add(product);
    }

    public void removeproduct(Product product){
        producten.remove(product);
    }

    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }

    public void setReiziger(Reiziger reiziger) { this.reiziger = reiziger; }

    public String toString(){
        return "kaartnummer: " + "" + kaart_nummer + ", " + "geldig_tot: " + " " + geldig_tot  + ", " + "klasse: " + " " + klasse + ", " + "saldo: " + " " + saldo + ", " + "gekoppelde producten: " + "  \n" + producten;
    }
}
