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
@ManagedBean(name = "talepBEAN")
@SessionScoped
public class talepBEAN {

    private talepler tlp;
    private taleplerDAO Tdao;
    private ArrayList<talepler> smlist;
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

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
        this.pageCount = (int) Math.ceil(this.getTdao().count() / (double) pageSize);
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

    public talepler getTlp() {
        if (this.tlp == null) {
            this.tlp = new talepler();
        }
        return tlp;
    }

    public void setTlp(talepler tlp) {
        this.tlp = tlp;
    }

    public taleplerDAO getTdao() {
        if (this.Tdao == null) {
            this.Tdao = new taleplerDAO();
        }
        return Tdao;
    }

    public void setTdao(taleplerDAO Tdao) {
        this.Tdao = Tdao;
    }

    public ArrayList<talepler> getSmlist() {
        this.smlist = this.getTdao().findAll(this.getPage(), this.getPageSize());
        return smlist;
    }

    public void setSmlist(ArrayList<talepler> smlist) {
        this.smlist = smlist;
    }

    public String updateForm(talepler tlp) {
        this.tlp = tlp;
        return "/tamam";
    }

    public String taleptenVazgec(kisi k) {
        this.getTdao().talepVazgec(this.getTlp(), k);
        this.tlp=new talepler();

        return "/tamam";
    }
     public String talepIslemi( kisi k) {
        this.getTdao().talepIslemi(this.getTlp(), k);
        this.tlp=new talepler();

        return "/tamam";
    }

}
