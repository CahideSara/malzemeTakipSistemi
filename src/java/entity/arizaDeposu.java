/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class arizaDeposu {

    private Long id;
    private String malzeme_ad;
    private String arizak;
    private String ariza_nedeni;
    private String arizat;
    private String tur;
    private Long sarf_id;
    private Long elektronik_id;
    private String durumu;
    

    public arizaDeposu() {
        this.id = null;
        this.malzeme_ad = null;
        this.arizak = null;
        this.ariza_nedeni = null;
        this.arizat = null;
        this.tur = null;
        this.sarf_id = null;
        this.elektronik_id = null;
        this.durumu =null;
    }

    public arizaDeposu(Long id, String malzeme_ad, String arizak, String ariza_nedeni, String arizat, String tur, Long sarf_id, Long elektronik_id, String durumu) {
        this.id = id;
        this.malzeme_ad = malzeme_ad;
        this.arizak = arizak;
        this.ariza_nedeni = ariza_nedeni;
        this.arizat = arizat;
        this.tur = tur;
        this.sarf_id = sarf_id;
        this.elektronik_id = elektronik_id;
        this.durumu = durumu;
    }



    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMalzeme_ad() {
        return malzeme_ad;
    }

    public void setMalzeme_ad(String malzeme_ad) {
        this.malzeme_ad = malzeme_ad;
    }

    public String getArizak() {
        return arizak;
    }

    public void setArizak(String arizak) {
        this.arizak = arizak;
    }

    public String getAriza_nedeni() {
        return ariza_nedeni;
    }

    public void setAriza_nedeni(String ariza_nedeni) {
        this.ariza_nedeni = ariza_nedeni;
    }

    public String getArizat() {
        return arizat;
    }

    public void setArizat(String arizat) {
        this.arizat = arizat;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public Long getSarf_id() {
        return sarf_id;
    }

    public void setSarf_id(Long sarf_id) {
        this.sarf_id = sarf_id;
    }

    public Long getElektronik_id() {
        return elektronik_id;
    }

    public void setElektronik_id(Long elektronik_id) {
        this.elektronik_id = elektronik_id;
    }

    @Override
    public String toString() {
        return "arizaDeposu{" + "id=" + id + ", malzeme_ad=" + malzeme_ad + ", arizak=" + arizak + ", ariza_nedeni=" + ariza_nedeni + ", arizat=" + arizat + ", tur=" + tur + ", sarf_id=" + sarf_id + ", elektronik_id=" + elektronik_id + ", durumu=" + durumu + '}';
    }

  

}
