/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.*;
import entity.*;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name = "sarfBEAN")
@SessionScoped
public class sarfBEAN {

    private sarf_malzemeler sarfm;
    private sarfDAO sDAO;
    private ArrayList smlist;
    private ArrayList dsmlist;
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    private int pagedepo = 1;
    private int pageCountdepo;
    private arizaDeposu az;
    private arizaDeposuDAO azDAO;

    public arizaDeposuDAO getAzDAO() {
        if (this.azDAO == null) {
            this.azDAO = new arizaDeposuDAO();
        }
        return azDAO;
    }

    public void setAzDAO(arizaDeposuDAO azDAO) {
        this.azDAO = azDAO;
    }

    public arizaDeposu getAz() {
        if (this.az == null) {
            this.az = new arizaDeposu();
        }
        return az;
    }

    public void setAz(arizaDeposu az) {
        this.az = az;
    }

    public int getPagedepo() {
        return pagedepo;
    }

    public void setPagedepo(int pagedepo) {
        this.pagedepo = pagedepo;
    }

    public int getPageCountdepo() {
        this.pageCountdepo = (int) Math.ceil(this.getsDAO().countD() / (double) pageSize);
        return pageCountdepo;
    }

    public void setPageCountdepo(int pageCountdepo) {
        this.pageCountdepo = pageCountdepo;
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

    public int ileridepo() {
        if (this.pagedepo == this.getPageCountdepo()) {
            this.pagedepo = 1;
        } else {
            this.pagedepo += +1;
        }
        return this.pagedepo;
    }

    public int geridepo() {
        if (this.pagedepo == 1) {
            this.pagedepo = this.getPageCountdepo();
        } else {
            this.pagedepo--;
        }
        return this.pagedepo;
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
        this.pageCount = (int) Math.ceil(this.getsDAO().count() / (double) pageSize);
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public sarf_malzemeler getSarfm() {
        if (this.sarfm == null) {
            this.sarfm = new sarf_malzemeler();
        }
        return sarfm;
    }

    public void setSarfm(sarf_malzemeler sarfm) {
        this.sarfm = sarfm;
    }

    public sarfDAO getsDAO() {
        if (this.sDAO == null) {
            this.sDAO = new sarfDAO();
        }
        return sDAO;
    }

    public void setsDAO(sarfDAO sDAO) {
        this.sDAO = sDAO;
    }

    public ArrayList<sarf_malzemeler> getSmlist() {
        this.smlist = this.getsDAO().findAll(this.page, this.pageSize);
        return smlist;
    }

    public void setSmlist(ArrayList<sarf_malzemeler> smlist) {
        this.smlist = smlist;
    }

    public ArrayList<sarf_malzemeler> getDsmlist() {
        this.dsmlist = this.getsDAO().dfindAll(this.pagedepo, this.pageSize, null);
        return dsmlist;
    }

    public void setDsmlist(ArrayList<sarf_malzemeler> dsmlist) {
        this.dsmlist = dsmlist;
    }

    public String create() {
        this.getsDAO().create(this.sarfm);
        this.sarfm = new sarf_malzemeler();
        this.page = 1;
        return "/tamam";
    }

    public String updateForm(sarf_malzemeler sarfm) {
        this.sarfm = sarfm;
        return "/tamam";
    }

    public String updateArıza(arizaDeposu az) {
        this.az = az;
        return "/tamam";
    }

    public String clearForm() {
        this.sarfm = null;
        return "/tamam";
    }

    public String update() {
        this.getsDAO().update(this.getSarfm());
        clearForm();
        return "/tamam";
    }

    public String delete() {
        this.getsDAO().delete(this.getSarfm());
        clearForm();
        return "/tamam";
    }

    public String updateModal() {
        this.setSarfm(this.sarfm);

        return "/TAMAM";

    }

    public String arizali() {
        System.out.println("SARF ");
        this.getAzDAO().sarfArizabildir(this.sarfm, this.az);
        clearForm();

        return "/tamam";
    }

    public boolean arizaKontrol(sarf_malzemeler s) {
        if (s.getDurumu().equals("ÇALIŞIYOR") &&  this.getSarfm().getId()!=s.getId()) {
            return true;
        } 
        else 
        {
            return false;
        }
        
    }

}
