/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import Utility.DatabaseConnection;
import dao.*;
import entity.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "userBEAN")
@SessionScoped
public class userBEAN {

    private user r;
    private kisi k;
    private kisiDAO kdao;
    private userDAO uDAO;
    private sarfDAO sDAO;
    private ArrayList kmlist;
    private ArrayList turlist;
    private String tur;
    private Date tarih;

    private int pageSize = 10;
    private arizaDeposu az;
    private arizaDeposuDAO aDao;
    private ArrayList alist;
    private int pagea = 1;
    private int pageCounta;

    private int pages = 1;
    private int pageCounts;

    private int pagee = 1;
    private int pageCounte;
    private elektronik e;
    private elektronikDAO eDAO;
    private ArrayList ellist;

    private talepler tlp;
    private taleplerDAO tlpDAO;
    private ArrayList tlplist;
    private int paget = 1;
    private int pageCountt;

    private ArrayList amirkmlist;
    private int pageamk = 1;
    private int pageCountamk;

    public kisiDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new kisiDAO();
        }
        return kdao;
    }

    public void setKdao(kisiDAO kdao) {
        this.kdao = kdao;
    }

    public ArrayList getAmirkmlist() {

        this.amirkmlist = this.getKdao().amirfindAll(this.pageamk, this.pageSize, this.getR());
        return amirkmlist;
    }

    public void setAmirkmlist(ArrayList amirkmlist) {
        this.amirkmlist = amirkmlist;
    }

    public int getPageamk() {
        return pageamk;
    }

    public void setPageamk(int pageamk) {
        this.pageamk = pageamk;
    }

    public int getPageCountamk() {
        this.pageCountamk = (int) Math.ceil(this.getKdao().countamk(this.getR()) / (double) pageSize);
        return pageCountamk;
    }

    public void setPageCountamk(int pageCountamk) {
        this.pageCountamk = pageCountamk;
    }

    public int ileriamk() {
        if (this.pageamk == this.getPageCountamk()) {
            this.pageamk = 1;
        } else {
            this.pageamk += +1;
        }
        return this.pageamk;
    }

    public int geriamk() {
        if (this.pageamk == 1) {
            this.pageamk = this.getPageCountamk();
        } else {
            this.pageamk--;
        }
        return this.pageamk;
    }

    private ArrayList amirtlpmlist;
    private int pageamtlp = 1;
    private int pageCountamtlp;

    public ArrayList getAmirtlpmlist() {
        this.amirtlpmlist = this.getTlpDAO().amirfindAll(this.pageamtlp, this.pageSize, this.getR());
        return this.amirtlpmlist;
    }

    public void setAmirtlpmlist(ArrayList amirtlpmlist) {
        this.amirtlpmlist = amirtlpmlist;
    }

    public int getPageamtlp() {
        return pageamtlp;
    }

    public void setPageamtlp(int pageamtlp) {
        this.pageamtlp = pageamtlp;
    }

    public int getPageCountamtlp() {
        this.pageCountamtlp = (int) Math.ceil(this.getTlpDAO().countamirtlp(this.getR()) / (double) pageSize);
        return pageCountamtlp;
    }

    public void setPageCountamtlp(int pageCountamtlp) {
        this.pageCountamtlp = pageCountamtlp;
    }
    
    
  public int ileriamtlp() {
        if (this.pageamtlp == this.getPageCountamtlp()) {
            this.pageamtlp = 1;
        } else {
            this.pageamtlp += +1;
        }
        return this.pageamtlp;
    }

    public int geriamtlp() {
        if (this.pageamtlp == 1) {
            this.pageamtlp = this.getPageCountamtlp();
        } else {
            this.pageamtlp--;
        }
        return this.pageamtlp;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPagee() {
        return pagee;
    }

    public void setPagee(int pagee) {
        this.pagee = pagee;
    }

    public int getPageCounte() {
        this.pageCounte = (int) Math.ceil(this.geteDAO().countE(this.getK().getSicil_no()) / (double) pageSize);
        return pageCounte;
    }

    public void setPageCounte(int pageCounte) {

        this.pageCounte = pageCounte;
    }

    public elektronik getE() {
        if (this.e == null) {
            this.e = new elektronik();
        }
        return e;
    }

    public void setE(elektronik e) {
        this.e = e;
    }

    public elektronikDAO geteDAO() {
        if (this.eDAO == null) {
            this.eDAO = new elektronikDAO();
        }
        return eDAO;
    }

    public void seteDAO(elektronikDAO eDAO) {
        this.eDAO = eDAO;
    }

    public ArrayList getEllist() {
        this.ellist = this.geteDAO().dfindAll(this.pagee, this.pageSize, this.getK().getSicil_no());
        return ellist;
    }

    public void setEllist(ArrayList ellist) {
        this.ellist = ellist;
    }

    public int ilerie() {
        if (this.pagee == this.getPageCounte()) {
            this.pagee = 1;
        } else {
            this.pagee += +1;
        }
        return this.pagee;
    }

    public int gerie() {
        if (this.pagee == 1) {
            this.pagee = this.getPageCounte();
        } else {
            this.pagee--;
        }
        return this.pagee;
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

    public arizaDeposuDAO getaDao() {
        if (this.aDao == null) {
            this.aDao = new arizaDeposuDAO();
        }
        return aDao;
    }

    public void setaDao(arizaDeposuDAO aDao) {
        this.aDao = aDao;
    }

    public int getPagea() {
        return pagea;
    }

    public void setPagea(int pagea) {
        this.pagea = pagea;
    }

    public int getPageCounta() {
        this.pageCounta = (int) Math.ceil(this.getaDao().kcount(this.getK().getSicil_no()) / (double) pageSize);
        return pageCounta;
    }

    public void setPageCounta(int pageCounta) {
        this.pageCounta = pageCounta;
    }

    public ArrayList getAlist() {
        this.alist = this.getaDao().kfindAll(pagea, pageSize, this.getK().getSicil_no());
        return alist;
    }

    public void setAlist(ArrayList alist) {
        this.alist = alist;
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

    public taleplerDAO getTlpDAO() {
        if (this.tlpDAO == null) {
            this.tlpDAO = new taleplerDAO();
        }
        return tlpDAO;
    }

    public void setTlpDAO(taleplerDAO tlpDAO) {
        this.tlpDAO = tlpDAO;
    }

    public ArrayList getTlplist() {
        this.tlplist = this.getTlpDAO().tfindAll(paget, pageSize, this.getK().getSicil_no());
        return tlplist;
    }

    public void setTlplist(ArrayList tlplist) {
        this.tlplist = tlplist;
    }

    public int getPaget() {
        return paget;
    }

    public void setPaget(int paget) {
        this.paget = paget;
    }

    public int getPageCountt() {
        this.pageCountt = (int) Math.ceil(this.getTlpDAO().tcount(this.getK().getSicil_no()) / (double) pageSize);

        return pageCountt;
    }

    public void setPageCountt(int pageCountt) {
        this.pageCountt = pageCountt;
    }

    public int ilerit() {
        if (this.paget == this.getPageCountt()) {
            this.paget = 1;
        } else {
            this.paget += +1;
        }
        return this.paget;
    }

    public int gerit() {
        if (this.paget == 1) {
            this.paget = this.getPageCountt();
        } else {
            this.paget--;
        }
        return this.paget;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageCounts() {
        this.pageCounts = (int) Math.ceil(this.getsDAO().countK(this.getK().getSicil_no()) / (double) pageSize);

        return pageCounts;
    }

    public void setPageCounts(int pageCounts) {
        this.pageCounts = pageCounts;
    }

    public int ileris() {
        if (this.pages == this.getPageCounts()) {
            this.pages = 1;
        } else {
            this.pages += +1;
        }
        return this.pages;
    }

    public int geris() {
        if (this.pages == 1) {
            this.pages = this.getPageCounts();
        } else {
            this.pages--;
        }
        return this.pages;
    }

    public int ileria() {
        if (this.pagea == this.getPageCounta()) {
            this.pagea = 1;
        } else {
            this.pagea += +1;
        }
        return this.pagea;
    }

    public int geria() {
        if (this.pagea == 1) {
            this.pagea = this.getPageCounta();
        } else {
            this.pagea--;
        }
        return this.pagea;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String login() {

        Connection con = DatabaseConnection.baglanti();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from public.user where sicil_no=" + this.getR().getSicil_no());
            rs.next();
            System.out.println(rs.getLong("sicil_no"));
            if (this.getR().getSicil_no().equals(rs.getLong("sicil_no")) && this.getR().getKullanici_adi().equals(rs.getString("kullanici_adi")) && this.getR().getSifre().equals(rs.getString("sifre"))) {
                this.getR().setKullanici_adi(null);
                this.getR().setSifre(null);
                if (this.getK().getKonumu().equals("BAŞ YETKİLİ")) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.getR());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_calisan", null);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_amir", null);

                    return "/admin/user/sarf.xhtml";
                } else if (this.getK().getKonumu().equals("DOĞU SAHA ÇALIŞANI") || this.getK().getKonumu().equals("BATI SAHA ÇALIŞANI") || this.getK().getKonumu().equals("HASAR EKİBİ ÇALIŞANI")) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_calisan", this.getR());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", null);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_amir", null);

                    return "/calısan/user/sarf.xhtml";
                } 
                else if (this.getK().getKonumu().equals("DOĞU SAHA AMİRİ") || this.getK().getKonumu().equals("BATI SAHA AMİRİ") || this.getK().getKonumu().equals("HASAR EKİBİ AMİRİ")) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_calisan", null);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", null);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_amir", this.getR());

                    return "/amir/user/sarf.xhtml";
                }
                
                else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("HATALI GİRİŞ YAPTINIZ"));
                    return "/index.xhtml";
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(userBEAN.class.getName()).log(Level.SEVERE, null, ex);

        }

        return "";
    }

    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false

        this.r = null;
        this.k = null;
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";

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

    public userDAO getuDAO() {
        if (this.uDAO == null) {
            this.uDAO = new userDAO();
        }
        return uDAO;
    }

    public kisi getK() {
        this.k = this.getuDAO().find(this.getR().getSicil_no());

        return this.k;
    }

    public void setK(kisi k) {
        this.k = k;
    }

    public user getR() {
        if (this.r == null) {
            this.r = new user();
        }
        return this.r;
    }

    public void setR(user r) {
        this.r = r;
    }

    public ArrayList getKmlist() {
        this.kmlist = this.getsDAO().dfindAll(pages, pageSize, this.getR().getSicil_no());
        return kmlist;
    }

    public ArrayList getTurlist() {
        this.turlist = this.getsDAO().turuAl();
        return turlist;
    }

    public void setTurlist(ArrayList turlist) {
        this.turlist = turlist;
    }

    public String sifreDegistir() {

        this.uDAO.kullanıcıGüncelle(this.getR());
        this.r.setKullanici_adi(null);
        this.r.setSifre(null);
        this.r.setCevap(null);
        

        return "/tamam";
    }

    public String sifreYenile() {
        System.out.println(this.getR().getSicil_no());
        System.out.println(this.getR().getKullanici_adi());
        System.out.println(this.getR().getSifre());

        this.uDAO.hadi(this.getR());
        return "/index.xhtml";
    }

    public String sifremiUnuttum() {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from   public.user where kullanici_adi='" + this.r.getKullanici_adi() + "' and soru='" + this.r.getSoru() + "' and cevap='" + this.r.getCevap() + "'  and sicil_no=" + this.r.getSicil_no());

            rs.next();

            if (rs.getString("kullanici_adi") != null) {
                Statement st = con.createStatement();
                st.executeUpdate("update public.user set sifre='turktelekom' ,kullanici_adi='turktelekom' where sicil_no=" + this.r.getSicil_no());
                this.r = new user();

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return "/oldu";
    }

    public String sarfMalzemeTalebi() {
        System.out.println("olmdy");
        this.getTlpDAO().sarfTalebi(this.getK(), this.getTlp(), this.getTur());
        this.tlp = new talepler();
        return "/tamam";
    }

    public String elektronikMalzemeTalebi() {
        System.out.println("olmdy");
        this.getTlpDAO().elektronikTalebi(this.getK(), this.getTlp());
        this.tlp = new talepler();
        return "/tamam";
    }

    public String detay(elektronik k) {
        this.e = k;
        return "/admin/user/detay.xhtml";

    }
     public String detaya(elektronik k) {
        this.e = k;
        return "/amir/user/detay.xhtml";

    }

    public String Cdetay(elektronik k) {
        this.e = k;
        return "/calısan/user/detay.xhtml";

    }
     public String aCdetay(elektronik k) {
        this.e = k;
        return "/amir/user/detay.xhtml";

    }

    public boolean onayBekleyen(String onay) {
        if (onay.equals("ONAY BEKLİYOR")) {
            return true;
        } else {
            return false;
        }
    }

}
