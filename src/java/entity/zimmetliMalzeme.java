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
public class zimmetliMalzeme {
    private Long id;
    private String  ad;
    private String ek1;
    private String ek2;
    private Long sicil_no;
    private Date  ztarih;
    private Date atarih;

    public zimmetliMalzeme() {
        
        this.id = null;
        this.ad = null;
        this.ek1 = null;
        this.ek2 = null;
        this.sicil_no =null;
        this.ztarih = null;
        this.atarih = null;
        
    }

    
    
    
    
    public zimmetliMalzeme(Long id, String ad, String ek1, String ek2, Long sicil_no, Date ztarih, Date atarih) {
        this.id = id;
        this.ad = ad;
        this.ek1 = ek1;
        this.ek2 = ek2;
        this.sicil_no = sicil_no;
        this.ztarih = ztarih;
        this.atarih = atarih;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
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

    public Long getSicil_no() {
        return sicil_no;
    }

    public void setSicil_no(Long sicil_no) {
        this.sicil_no = sicil_no;
    }

    public Date getZtarih() {
        return ztarih;
    }

    public void setZtarih(Date ztarih) {
        this.ztarih = ztarih;
    }

    public Date getAtarih() {
        return atarih;
    }

    public void setAtarih(Date atarih) {
        this.atarih = atarih;
    }

    @Override
    public String toString() {
        return "zimmetliMalzeme{" + "id=" + id + ", ad=" + ad + ", ek1=" + ek1 + ", ek2=" + ek2 + ", sicil_no=" + sicil_no + ", ztarih=" + ztarih + ", atarih=" + atarih + '}';
    }
        
}
