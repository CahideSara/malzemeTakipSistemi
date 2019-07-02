package entity;

public class user {

    private Long sicil_no;
    private String kullanici_adi;
    private String sifre;
    private String soru;
    private String cevap;

    public user() {
        this.sicil_no = null;
        this.kullanici_adi = null;
        this.sifre = null;
        this.soru = null;
        this.cevap = null;
    }

    public user(Long sicil_no, String kullanici_adi, String sifre, String soru, String cevap) {
        this.sicil_no = sicil_no;
        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
        this.soru = soru;
        this.cevap = cevap;
    }

    public Long getSicil_no() {
        return sicil_no;
    }

    public void setSicil_no(Long sicil_no) {
        this.sicil_no = sicil_no;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    @Override
    public String toString() {
        return "user{" + "sicil_no=" + sicil_no + ", kullanici_adi=" + kullanici_adi + ", sifre=" + sifre + ", soru=" + soru + ", cevap=" + cevap + '}';
    }

}
