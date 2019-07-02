/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

public class sarf_malzemeler {

    private Long id;
    private String malzeme_ad;
    private String firma_ad;
    private String ebat;
    private Long sicil_no;
    private String durumu;
    private Date al_tarihi;
    private String s_al;
    private Date zimmet_tarihi;
    private String s_zimmet;
    private String ek_1;

    public sarf_malzemeler() {
        this.id = null;
        this.malzeme_ad = null;
        this.firma_ad = null;
        this.ebat = null;
        this.sicil_no = null;
        this.durumu = null;
        this.al_tarihi = null;
        this.s_al = null;
        this.zimmet_tarihi = null;
        this.s_zimmet = null;
        this.ek_1 = null;
    }

    public sarf_malzemeler(Long id, String malzeme_ad, String firma_ad, String ebat, Long sicil_no, String durumu, Date al_tarihi, String s_al, Date zimmet_tarihi, String s_zimmet, String ek_1) {
        this.id = id;
        this.malzeme_ad = malzeme_ad;
        this.firma_ad = firma_ad;
        this.ebat = ebat;
        this.sicil_no = sicil_no;
        this.durumu = durumu;
        this.al_tarihi = al_tarihi;
        this.s_al = s_al;
        this.zimmet_tarihi = zimmet_tarihi;
        this.s_zimmet = s_zimmet;
        this.ek_1 = ek_1;
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

    public String getFirma_ad() {
        return firma_ad;
    }

    public void setFirma_ad(String firma_ad) {
        this.firma_ad = firma_ad;
    }

    public String getEbat() {
        return ebat;
    }

    public void setEbat(String ebat) {
        this.ebat = ebat;
    }

    public Long getSicil_no() {
        return sicil_no;
    }

    public void setSicil_no(Long sicil_no) {
        this.sicil_no = sicil_no;
    }

    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }

    public Date getAl_tarihi() {
        return al_tarihi;
    }

    public void setAl_tarihi(Date al_tarihi) {
        this.al_tarihi = al_tarihi;
    }

    public String getS_al() {
        return s_al;
    }

    public void setS_al(String s_al) {
        this.s_al = s_al;
    }

    public Date getZimmet_tarihi() {
        return zimmet_tarihi;
    }

    public void setZimmet_tarihi(Date zimmet_tarihi) {
        this.zimmet_tarihi = zimmet_tarihi;
    }

    public String getS_zimmet() {
        return s_zimmet;
    }

    public void setS_zimmet(String s_zimmet) {
        this.s_zimmet = s_zimmet;
    }

    public String getEk_1() {
        return ek_1;
    }

    public void setEk_1(String ek_1) {
        this.ek_1 = ek_1;
    }

    @Override
    public String toString() {
        return "sarf_malzemeler{" + "id=" + id + ", malzeme_ad=" + malzeme_ad + ", firma_ad=" + firma_ad + ", ebat=" + ebat + ", sicil_no=" + sicil_no + ", durumu=" + durumu + ", al_tarihi=" + al_tarihi + ", s_al=" + s_al + ", zimmet_tarihi=" + zimmet_tarihi + ", s_zimmet=" + s_zimmet + ", ek_1=" + ek_1 + '}';
    }
}
