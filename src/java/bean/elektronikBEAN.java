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
@ManagedBean(name = "elektronikBEAN")
@SessionScoped
public class elektronikBEAN {

    private elektronik el;
    private elektronikDAO elDAO;
    private ArrayList<elektronik> ellist;
    private ArrayList<elektronik> dellist;
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    private int paged = 1;
    private int pageCountd;
    private arizaDeposu az;
    private arizaDeposuDAO azDAO;

    public arizaDeposuDAO getAzDAO() {
        if (this.azDAO == null) {
            this.azDAO = new arizaDeposuDAO();
        }
        return this.azDAO;
    }

    public void setAzDAO(arizaDeposuDAO azDAO) {
        this.azDAO = azDAO;
    }

    public arizaDeposu getAz() {
        if (this.az == null) {
            this.az = new arizaDeposu();
        }
        return this.az;
    }

    public void setAz(arizaDeposu az) {
        this.az = az;
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
        this.pageCount = (int) Math.ceil(this.getElDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPaged() {
        return paged;
    }

    public void setPaged(int paged) {
        this.paged = paged;
    }

    public int getPageCountd() {
        this.pageCountd = (int) Math.ceil(this.getElDAO().countD() / (double) pageSize);
        return pageCountd;
    }

    public void setPageCountd(int pageCountd) {
        this.pageCountd = pageCountd;
    }

    public int ileri() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
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

    public int ilerid() {
        if (this.paged == this.getPageCountd()) {
            this.paged = 1;
        } else {
            this.paged += +1;
        }
        return this.paged;
    }

    public int gerid() {
        if (this.paged == 1) {
            this.paged = this.getPageCountd();
        } else {
            this.paged--;
        }
        return this.paged;
    }

    public elektronik getEl() {
        if (this.el == null) {
            this.el = new elektronik();
        }
        return this.el;
    }

    public void setEl(elektronik el) {
        this.el = el;
    }

    public elektronikDAO getElDAO() {
        if (this.elDAO == null) {
            this.elDAO = new elektronikDAO();
        }
        return elDAO;
    }

    public void setElDAO(elektronikDAO elDAO) {
        this.elDAO = elDAO;
    }

    public ArrayList<elektronik> getEllist() {
        this.ellist = this.getElDAO().findAll(this.page, this.pageSize);
        return this.ellist;
    }

    public void setEllist(ArrayList<elektronik> ellist) {
        this.ellist = ellist;
    }

    public ArrayList<elektronik> getDellist() {
        this.dellist = this.getElDAO().dfindAll(this.paged, this.pageSize, null);
        return dellist;
    }

    public void setDellist(ArrayList<elektronik> dellist) {
        this.dellist = dellist;
    }

    public String create() {
        this.getElDAO().create(this.el);
        clearForm();
        this.page=1;
        return "/tamam";
    }

    public String updateForm(elektronik el) {
        this.el = el;
        return "/tamam";
    }

    public String clearForm() {
        this.el = null;
        return "/tamam";
    }

    public String detay(elektronik k) {
        this.setEl(k);
        return "/admin/malzemeler/elektronikDetay.xhtml";

    }
     public String detaya(elektronik k) {
        this.setEl(k);
        return "/amir/malzemeler/elektronikDetay.xhtml";

    }

    public String update() {
        this.getElDAO().update(this.getEl());
        clearForm();
        return "/tamam";
    }

    public String delete() {
        this.getElDAO().delete(this.getEl());
        clearForm();
        return "/tamam";
    }

    public String updateModal() {
        this.setEl(this.el);

        return "/TAMAM";

    }

    public String arizali() {
        System.out.println("arıza ya kayıt");
        this.getAzDAO().elektronikArizabildir(this.el, this.az);
        this.el=new elektronik();
        this.az=new arizaDeposu();

        return "/tamam";
    }
    
       public boolean arizaKontrol(elektronik e) {
        if (e.getDurumu().equals("ÇALIŞIYOR") && this.getEl().getId()!=e.getId()) {
            return true;
        } 
        else 
        {
            return false;
        }
        
    }
}
