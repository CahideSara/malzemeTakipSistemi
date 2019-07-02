/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class talepler {

    private Long id;
    private Long kisi_sicil;
    private String kisi_ad;
    private String kisi_doyad;
    private String malzeme_ad;
    private String talep_t;
    private String s_talep;
    private String islem_t;
    private String s_islem;
    private String durumu;
    private String tur;
    private String aciklama;
    private String islem_y;
    private String islem_aciklama;

    public talepler() {
        this.id = null;
        this.kisi_sicil = null;
        this.kisi_ad = null;
        this.kisi_doyad = null;
        this.malzeme_ad = null;
        this.talep_t = null;
        this.islem_t = null;
        this.durumu = null;
        this.tur = null;
        this.aciklama = null;
        this.s_talep = null;
        this.s_islem = null;
        this.islem_y = null;
        this.islem_aciklama = null;
    }

    public talepler(Long id, Long kisi_sicil, String kisi_ad, String kisi_doyad, String malzeme_ad, String talep_t, String s_talep, String islem_t, String s_islem, String durumu, String tur, String aciklama, String islem_y, String islem_aciklama) {
        this.id = id;
        this.kisi_sicil = kisi_sicil;
        this.kisi_ad = kisi_ad;
        this.kisi_doyad = kisi_doyad;
        this.malzeme_ad = malzeme_ad;
        this.talep_t = talep_t;
        this.s_talep = s_talep;
        this.islem_t = islem_t;
        this.s_islem = s_islem;
        this.durumu = durumu;
        this.tur = tur;
        this.aciklama = aciklama;
        this.islem_y = islem_y;
        this.islem_aciklama = islem_aciklama;
    }

    public String getIslem_aciklama() {
        return islem_aciklama;
    }

    public void setIslem_aciklama(String islem_aciklama) {
        this.islem_aciklama = islem_aciklama;
    }

    public String getIslem_y() {
        return islem_y;
    }

    public void setIslem_y(String islem_y) {
        this.islem_y = islem_y;
    }

    public String getS_talep() {
        return s_talep;
    }

    public void setS_talep(String s_talep) {
        this.s_talep = s_talep;
    }

    public String getS_islem() {
        return s_islem;
    }

    public void setS_islem(String s_islem) {
        this.s_islem = s_islem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKisi_sicil() {
        return kisi_sicil;
    }

    public void setKisi_sicil(Long kisi_sicil) {
        this.kisi_sicil = kisi_sicil;
    }

    public String getKisi_ad() {
        return kisi_ad;
    }

    public void setKisi_ad(String kisi_ad) {
        this.kisi_ad = kisi_ad;
    }

    public String getKisi_doyad() {
        return kisi_doyad;
    }

    public void setKisi_doyad(String kisi_doyad) {
        this.kisi_doyad = kisi_doyad;
    }

    public String getMalzeme_ad() {
        return malzeme_ad;
    }

    public void setMalzeme_ad(String malzeme_ad) {
        this.malzeme_ad = malzeme_ad;
    }

    public String getTalep_t() {
        return talep_t;
    }

    public void setTalep_t(String talep_t) {
        this.talep_t = talep_t;
    }

    public String getIslem_t() {
        return islem_t;
    }

    public void setIslem_t(String islem_t) {
        this.islem_t = islem_t;
    }

    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return "talepler{" + "id=" + id + ", kisi_sicil=" + kisi_sicil + ", kisi_ad=" + kisi_ad + ", kisi_doyad=" + kisi_doyad + ", malzeme_ad=" + malzeme_ad + ", talep_t=" + talep_t + ", s_talep=" + s_talep + ", islem_t=" + islem_t + ", s_islem=" + s_islem + ", durumu=" + durumu + ", tur=" + tur + ", aciklama=" + aciklama + ", islem_y=" + islem_y + ", islem_aciklama=" + islem_aciklama + '}';
    }

}
