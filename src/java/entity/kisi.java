/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author asus
 */
public class kisi {

    private Long id;
    private Long sicil_no;
    private String ad;
    private String soyad;
    private String ekibi;
    private String mail;
    private String telefon;
    private String görevi;
    private String konumu;
    private String tt_firma;

    public kisi() {
        this.id = null;
        this.sicil_no = null;
        this.ad = null;
        this.soyad = null;
        this.ekibi = null;
        this.mail = null;
        this.telefon = null;
        this.görevi = null;
        this.konumu = null;
        this.tt_firma = null;
    }

    public kisi(Long id, Long sicil_no, String ad, String soyad, String ekibi, String mail, String telefon, String görevi, String konumu,String tt_firma) {
        this.id = id;
        this.sicil_no = sicil_no;
        this.ad = ad;
        this.soyad = soyad;
        this.ekibi = ekibi;
        this.mail = mail;
        this.telefon = telefon;
        this.görevi = görevi;
        this.konumu = konumu;
         this.tt_firma = tt_firma;
    }

    public String getTt_firma() {
        return tt_firma;
    }

    public void setTt_firma(String tt_firma) {
        this.tt_firma = tt_firma;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSicil_no() {
        return sicil_no;
    }

    public void setSicil_no(Long sicil_no) {
        this.sicil_no = sicil_no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEkibi() {
        return ekibi;
    }

    public void setEkibi(String ekibi) {
        this.ekibi = ekibi;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getGörevi() {
        return görevi;
    }

    public void setGörevi(String görevi) {
        this.görevi = görevi;
    }

    public String getKonumu() {
        return konumu;
    }

    public void setKonumu(String konumu) {
        this.konumu = konumu;
    }

    @Override
    public String toString() {
        return "kisi{" + "id=" + id + ", sicil_no=" + sicil_no + ", ad=" + ad + ", soyad=" + soyad + ", ekibi=" + ekibi + ", mail=" + mail + ", telefon=" + telefon + ", g\u00f6revi=" + görevi + ", konumu=" + konumu + ", tt_firma=" + tt_firma + '}';
    }

   

}
