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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name = "kisiBEAN")
@SessionScoped
public class kisiBEAN {

    private kisi k;
    private ArrayList klist;
    private ArrayList kmlist;
    private ArrayList turlist;
    private kisiDAO kDAO;
    private ArrayList zmlist;
    private zimmetliDAO zDAO;
    private sarf_malzemeler sm;
    private sarfDAO sDAO;
    private String tur;
    
    private int pageSize = 10;
    private int pageCount;
    private int pagek = 1;
    private int pageCountk;
    private int pagee = 1;
    private int pageCounte;
    private elektronik e;
    private elektronikDAO eDAO;
    private ArrayList ellist;
    private int page = 1;
    private arizaDeposu az;
    private arizaDeposuDAO aDao;
    private ArrayList alist;
    private int pagea=1;
    private int pageCounta;
     private talepler tlp;
    private taleplerDAO tlpDAO;
    private ArrayList tlplist;
    private int paget=1;
    private int pageCountt;
    private ArrayList amirkmlist;
     private int pageamk=1;
    private int pageCountamk;
    
    public arizaDeposu getAz() {
        if(this.az==null)
            this.az=new arizaDeposu();
        return az;
    }

    public void setAz(arizaDeposu az) {
        this.az = az;
    }

    public arizaDeposuDAO getaDao() {
        if(this.aDao==null)
            this.aDao=new arizaDeposuDAO();
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
         this.pageCounta = (int) Math.ceil(this.getaDao().kcount(this.getK().getSicil_no())/ (double) pageSize);
        return pageCounta;
    }

    public void setPageCounta(int pageCounta) {
        this.pageCounta = pageCounta;
    }

    public ArrayList getAlist() {
        this.alist=this.getaDao().kfindAll(pagea, pageSize, this.getK().getSicil_no());
        return alist;
    }

    public void setAlist(ArrayList alist) {
        this.alist = alist;
    }

    public talepler getTlp() {
        if(this.tlp==null)
            this.tlp=new talepler();
        return tlp;
    }

    public void setTlp(talepler tlp) {
        this.tlp = tlp;
    }

    public taleplerDAO getTlpDAO() {
        if(this.tlpDAO==null)
            this.tlpDAO=new taleplerDAO();
        return tlpDAO;
    }

    public void setTlpDAO(taleplerDAO tlpDAO) {
        this.tlpDAO = tlpDAO;
    }

    public ArrayList getTlplist() {
        this.tlplist=this.getTlpDAO().tfindAll(paget, pageSize, this.getK().getSicil_no());
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
                 this.pageCountt = (int) Math.ceil(this.getTlpDAO().tcount(this.getK().getSicil_no())/ (double) pageSize);

        return pageCountt;
    }

    public void setPageCountt(int pageCountt) {
        this.pageCountt = pageCountt;
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

    public sarf_malzemeler getSm() {
        if (this.sm == null) {
            this.sm = new sarf_malzemeler();
        }
        return sm;
    }

    public void setSm(sarf_malzemeler sm) {
        this.sm = sm;
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

    public int getPagek() {
        return pagek;
    }

    public void setPagek(int pagek) {
        this.pagek = pagek;
    }

    public int getPageCountk() {
        this.pageCountk = (int) Math.ceil(this.getsDAO().countK(this.getK().getSicil_no()) / (double) pageSize);
        return pageCountk;
    }

    public void setPageCountk(int pageCountk) {
        this.pageCountk = pageCountk;
    }

    public int ilerik() {
        if (this.pagek == this.getPageCountk()) {
            this.pagek = 1;
        } else {
            this.pagek += +1;
        }
        return this.pagek;
    }

    public int gerik() {
        if (this.pagek == 1) {
            this.pagek = this.getPageCountk();
        } else {
            this.pagek--;
        }
        return this.pagek;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getkDAO().count() / (double) pageSize);
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

   public ArrayList getTurlist() {
        this.turlist = this.getsDAO().turuAl();
        return turlist;
    }

    public void setTurlist(ArrayList turlist) {
        this.turlist = turlist;
    }



    public ArrayList getKmlist() {  //kişilerin malzeme listesini getirir
        this.kmlist = this.getsDAO().dfindAll(this.pagek, this.pageSize, this.getK().getSicil_no());
        return kmlist;
    }

    public void setKmlist(ArrayList kmlist) {
        this.kmlist = kmlist;
    }

    public ArrayList getZmlist() {
        this.zmlist = this.getzDAO().zimmetliMalzeme(this.getK());
        return zmlist;
    }

    public void setZmlist(ArrayList zmlist) {
        this.zmlist = zmlist;
    }

    public zimmetliDAO getzDAO() {
        if (this.zDAO == null) {
            this.zDAO = new zimmetliDAO();
        }
        return zDAO;
    }

    public void setzDAO(zimmetliDAO zDAO) {
        this.zDAO = zDAO;
    }

   

    public kisi getK() {
        if (this.k == null) {
            this.k = new kisi();
        }
        return k;
    }

    public void setK(kisi k) {
        this.k = k;
    }

    public ArrayList getKlist() {
        this.klist = this.getkDAO().findAll(this.page, this.pageSize);
        return klist;
    }

    public void setKlist(ArrayList klist) {
        this.klist = klist;
    }

    public kisiDAO getkDAO() {
        if (this.kDAO == null) {
            this.kDAO = new kisiDAO();
        }
        return kDAO;
    }

    public void setkDAO(kisiDAO kDAO) {
        this.kDAO = kDAO;
    }
     private boolean a;

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }
      
    public String create() {
       setA( this.getkDAO().create(this.k));
        this.k = new kisi();
        return "/tamam";

    }

    public String detail(kisi k) {
        this.setK(k);
        return "/admin/kisiTakip/sarf.xhtml";

    }
     public String detaila(kisi k) {
        this.setK(k);
        return "/amir/kisiTakip/sarf.xhtml";

    }
     public String detay(elektronik k) {
        this.setE(k);
        return "/admin/user/detay.xhtml";

    }
       public String detayk(elektronik k) {
        this.setE(k);
        return "/admin/kisiTakip/detay.xhtml";

    }
      public String detaya(elektronik k) {
        this.setE(k);
        return "/amir/user/detay.xhtml";

    }
         public String detayak(elektronik k) {
        this.setE(k);
        return "/amir/kisiTakip/detay.xhtml";

    }
    

    public String updateForm(kisi k) {
        this.setK(k);

        return "/TAMAM";

    }

    public String updateModal() {
        this.setK(this.k);
        this.kntrl=this.getkDAO().kontrol(this.getK(),this.kntrl);
        
        return "/TAMAM";

    }

    public String clearForm() {
        this.k = new kisi();
        return "/TAMAM";

    }

    public String update() {
        this.getkDAO().update(this.getK());
        clearForm();

        return "/TAMAM";

    }
    private boolean kntrl;

    public boolean isKntrl() {
        return kntrl;
    }

    public void setKntrl(boolean kntrl) {
        this.kntrl = kntrl;
    }
    
    
    public String delete() {

        this.getkDAO().delete(this.getK());
        clearForm();

        return "/TAMAM";
    }

    public String sarfEkle() {
        this.getsDAO().kisiSarfMalzemeEkle(this.getSm(), this.getTur(), this.getK());
        this.setSm(new sarf_malzemeler());
       

        return "/tamam";
    }

    public String sarfCikar(sarf_malzemeler ml) {

        this.getsDAO().kisiSarfMalzemeCikar(ml);

        return "/tamam";
    }

    public String elektronikEkle() {
        this.geteDAO().kisiElektronikEkle(this.getE(), this.getK());
        this.setE(new elektronik());

        return "/tamam";
    }

    public String elektronikCikar(elektronik ml) {
        this.geteDAO().kisiElektronikCikar(ml);

        return "/tamam";
    }

 
    public String sifreDegistir() {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update public.user set kullanici_adi='turktelekom',sifre='turktelekom' where sicil_no=" + this.getK().getSicil_no() + ";");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return "/tamam";
    }

}
