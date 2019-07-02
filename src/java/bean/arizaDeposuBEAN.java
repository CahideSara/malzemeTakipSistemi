/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.arizaDeposuDAO;
import entity.arizaDeposu;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name = "arizaDeposuBEAN")
@SessionScoped

public class arizaDeposuBEAN {

    private arizaDeposu arizad;
    private arizaDeposuDAO arizadDAO;
    private ArrayList arizaDlist;
    private ArrayList arizaKlist;
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    private int pageb = 1;
    private int pageCountb;
     private ArrayList arizaAmir;
     private int pageamr = 1;
    private int pageCountamr;

    public ArrayList getArizaAmir() {
        this.arizaAmir = this.getArizadDAO().amirfindAll(this.getPageamr(), this.getPageSize());
        return arizaAmir;
    }

    public void setArizaAmir(ArrayList arizaAmir) {
        this.arizaAmir = arizaAmir;
    }

    public int getPageamr() {
        return pageamr;
    }

    public void setPageamr(int pageamr) {
        this.pageamr = pageamr;
    }

    public int getPageCountamr() {
        this.pageCountamr= (int) Math.ceil(this.getArizadDAO().amircount() / (double) pageSize);
        return pageCountamr;
    }

    public void setPageCountamr(int pageCountamr) {
        this.pageCountamr = pageCountamr;
    }
    
    
    public int ileriamr() {
        if (this.pageamr == this.getPageCountamr()) {
            this.pageamr = 1;
        } else {
            this.pageamr += +1;
        }
        return this.pageamr;
    }

    public int geriamr() {
        if (this.pageamr == 1) {
            this.pageamr = this.getPageCountamr();
        } else {
            this.pageamr--;
        }
        return this.pageamr;
    }
    
    
    public int getPageb() {
        return pageb;
    }

    public void setPageb(int pageb) {
        this.pageb = pageb;
    }

    public int getPageCountb() {
        this.pageCountb = (int) Math.ceil(this.getArizadDAO().countb() / (double) pageSize);
        return pageCountb;
    }

    public void setPageCountb(int pageCountb) {
        this.pageCountb = pageCountb;
    }

    public int ilerib() {
        if (this.pageb == this.getPageCountb()) {
            this.pageb = 1;
        } else {
            this.pageb += +1;
        }
        return this.pageb;
    }

    public int gerib() {
        if (this.pageb == 1) {
            this.pageb = this.getPageCountb();
        } else {
            this.pageb--;
        }
        return this.pageb;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getArizadDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int ileri() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page += +1;
        }
        return this.page;
    }

    public int geri() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
        return this.page;
    }

    public arizaDeposu getArizad() {
        if (this.arizad == null) {
            this.arizad = new arizaDeposu();
        }
        return arizad;
    }

    public void setArizad(arizaDeposu arizad) {
        this.arizad = arizad;
    }

    public arizaDeposuDAO getArizadDAO() {
        if (this.arizadDAO == null) {
            this.arizadDAO = new arizaDeposuDAO();
        }
        return arizadDAO;
    }

    public void setArizadDAO(arizaDeposuDAO arizadDAO) {
        this.arizadDAO = arizadDAO;
    }

    public ArrayList getArizaDlist() {
        this.arizaDlist = this.getArizadDAO().findAll(this.getPage(), this.getPageSize());
        return arizaDlist;
    }

    public void setArizaDlist(ArrayList arizaDlist) {

        this.arizaDlist = arizaDlist;
    }

    public ArrayList getArizaKlist() {
        this.arizaKlist = this.getArizadDAO().onaysızfindAll(this.getPageb(), this.getPageSize());
        return arizaKlist;
    }

    public void setArizaKlist(ArrayList arizaKlist) {
        this.arizaKlist = arizaKlist;
    }

    public String arizagider(arizaDeposu az) {
        this.getArizadDAO().arizaGider(az);

        return "/tamam";
    }

    public String kabulEt(arizaDeposu az) {
        this.getArizadDAO().kabul(az);
        return "/tamam";
    }

    public String reddet(arizaDeposu az) {
        this.getArizadDAO().red(az);
        return "/tamam";
    }

    public boolean onaylı(String onay) {
        if (onay.equals("ONAYLI")) {
            return true;
        } else {
            return false;
        }
    }
    
     public String arizadanVazgec(arizaDeposu az) {
        this.getArizadDAO().arizaVazgec(az);
        return "/tamam";
    }
    
}
