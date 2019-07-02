/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author asus
 */
public class elektronik {

    private Long id;
    private String malzeme_ad;
    private String xdsl_ttbarkot_no;
    private String im_no;
    private String seri_no;
    private String firma_adi;
    private String ukd_tarihi;    
    private String ek1;
    private String ek2;
    private String jdsu_gövde;
    private String jdsu_baslik;
    private Date zimmet_tarihi;
    private String s_zimmet;
    private Long sicil_no;
    private String durumu;
    private String cutt_barkot_no;
    private Date al_tarihi;
    private String s_al;

    public elektronik() {

        this.id = null;
        this.malzeme_ad = null;
        this.xdsl_ttbarkot_no = null;
        this.im_no = null;
        this.seri_no = null;
        this.firma_adi = null;
        this.ukd_tarihi = null;
        this.ek1 = null;
        this.ek2 = null;
        this.jdsu_gövde = null;
        this.jdsu_baslik = null;
        this.zimmet_tarihi = null;
        this.sicil_no = null;
        this.durumu = null;
        this.s_zimmet = null;
        this.cutt_barkot_no = null;
        this.al_tarihi = null;
        this.s_al = null;
    }

    public elektronik(Long id, String malzeme_ad, String xdsl_ttbarkot_no, String im_no, String seri_no, String firma_adi, String ukd_tarihi, String ek1, String ek2, String jdsu_gövde, String jdsu_baslik, Date zimmet_tarihi, String s_zimmet, Long sicil_no, String durumu, String cutt_barkot_no, Date al_tarihi, String s_al) {
        this.id = id;
        this.malzeme_ad = malzeme_ad;
        this.xdsl_ttbarkot_no = xdsl_ttbarkot_no;
        this.im_no = im_no;
        this.seri_no = seri_no;
        this.firma_adi = firma_adi;
        this.ukd_tarihi = ukd_tarihi;
        this.ek1 = ek1;
        this.ek2 = ek2;
        this.jdsu_gövde = jdsu_gövde;
        this.jdsu_baslik = jdsu_baslik;
        this.zimmet_tarihi = zimmet_tarihi;
        this.s_zimmet = s_zimmet;
        this.sicil_no = sicil_no;
        this.durumu = durumu;
        this.cutt_barkot_no = cutt_barkot_no;
        this.al_tarihi = al_tarihi;
        this.s_al = s_al;
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

    public String getXdsl_ttbarkot_no() {
        return xdsl_ttbarkot_no;
    }

    public void setXdsl_ttbarkot_no(String xdsl_ttbarkot_no) {
        this.xdsl_ttbarkot_no = xdsl_ttbarkot_no;
    }

    public String getIm_no() {
        return im_no;
    }

    public void setIm_no(String im_no) {
        this.im_no = im_no;
    }

    public String getSeri_no() {
        return seri_no;
    }

    public void setSeri_no(String seri_no) {
        this.seri_no = seri_no;
    }

    public String getFirma_adi() {
        return firma_adi;
    }

    public void setFirma_adi(String firma_adi) {
        this.firma_adi = firma_adi;
    }

    public String getUkd_tarihi() {
        return ukd_tarihi;
    }

    public void setUkd_tarihi(String ukd_tarihi) {
        this.ukd_tarihi = ukd_tarihi;
    }

    public String getEk1() {
        return ek1;
    }

    public void setEk1(String ek1) {
        this.ek1 = ek1;
    }

    public String getEk2() {
        return ek2;
    }

    public void setEk2(String ek2) {
        this.ek2 = ek2;
    }

    public String getJdsu_gövde() {
        return jdsu_gövde;
    }

    public void setJdsu_gövde(String jdsu_gövde) {
        this.jdsu_gövde = jdsu_gövde;
    }

    public String getJdsu_baslik() {
        return jdsu_baslik;
    }

    public void setJdsu_baslik(String jdsu_baslik) {
        this.jdsu_baslik = jdsu_baslik;
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

    public String getCutt_barkot_no() {
        return cutt_barkot_no;
    }

    public void setCutt_barkot_no(String cutt_barkot_no) {
        this.cutt_barkot_no = cutt_barkot_no;
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

    @Override
    public String toString() {
        return "elektronik{" + "id=" + id + ", malzeme_ad=" + malzeme_ad + ", xdsl_ttbarkot_no=" + xdsl_ttbarkot_no + ", im_no=" + im_no + ", seri_no=" + seri_no + ", firma_adi=" + firma_adi + ", ukd_tarihi=" + ukd_tarihi + ", ek1=" + ek1 + ", ek2=" + ek2 + ", jdsu_g\u00f6vde=" + jdsu_gövde + ", jdsu_baslik=" + jdsu_baslik + ", zimmet_tarihi=" + zimmet_tarihi + ", s_zimmet=" + s_zimmet + ", sicil_no=" + sicil_no + ", durumu=" + durumu + ", cutt_barkot_no=" + cutt_barkot_no + ", al_tarihi=" + al_tarihi + ", s_al=" + s_al + '}';
    }

  

}
