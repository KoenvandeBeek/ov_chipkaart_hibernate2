package nl.hu.dp.ov_chipkaart.domain;

import javax.persistence.*;

@Entity
public class Adres {
    @Id
    @Column(name = "adres_id")
    private int adres_id;
    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;
    @OneToOne
    @JoinColumn(name = "reiziger_id", foreignKey = @ForeignKey(name = "reiziger_id"))
    private Reiziger reiziger;

    public Adres(){
    }

    public Adres(String postcode, String huisnummer, String straat, String woonplaats) {
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.straat = straat;
        this.woonplaats = woonplaats;
    }

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }


    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    @Override
    public String toString() {
        String adresString = "    #" + adres_id + ": " + postcode + ". " + straat + woonplaats;
        if(getReiziger() == null){
            return adresString + "dit adres heeft geen eigenaar";
        } else{
            return adresString + "    #" + getReiziger().getReiziger_id() + ": " + getReiziger().getVoorletters() + ". " + getReiziger().getTussenvoegsel() + getReiziger().getAchternaam() + "(" + getReiziger().getGeboortedatum() + ")";
        }
    }
}
