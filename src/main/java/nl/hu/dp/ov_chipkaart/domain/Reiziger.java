package nl.hu.dp.ov_chipkaart.domain;

import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Reiziger {
    @Id
    @Column(name = "reiziger_id")
    private int reiziger_id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
    @Transient
    private Adres adres;
    @Transient
    private List<OVChipkaart> ovchipkaarts = new ArrayList<OVChipkaart>();

    public Reiziger(){}

    public Reiziger(String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    public void setReiziger_id(int reiziger_id) {
        this.reiziger_id = reiziger_id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void addOVChipkaart(OVChipkaart ovChipkaart){
        ovChipkaart.setReiziger_id(this.getReiziger_id());
        ovchipkaarts.add(ovChipkaart);
    }

    public void removeOVChipkaart(OVChipkaart ovChipkaart){
        ovchipkaarts.remove(ovChipkaart);
    }
    public List<OVChipkaart> getOvchipkaarts() {
        return ovchipkaarts;
    }

    public void setOvchipkaarts(List<OVChipkaart> ovchipkaarts) {
        this.ovchipkaarts = ovchipkaarts;
    }

    @Override
    public String toString() {
        String reizigerstring = "    #" + reiziger_id + ": " + voorletters + ". " + tussenvoegsel + achternaam + "(" + geboortedatum + ")";
        if(getAdres() == null){
            return reizigerstring + " deze reiziger heeft geen adres";
        } else{
            return reizigerstring + " deze reiziger woont op het adres:    #" + getAdres().getPostcode() + ". " + getAdres().getStraat() + getAdres().getWoonplaats();
        }
    }
}