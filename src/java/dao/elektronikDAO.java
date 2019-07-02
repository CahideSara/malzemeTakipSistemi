/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utility.DatabaseConnection;
import entity.elektronik;
import entity.kisi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class elektronikDAO {

    public int count() {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as elektronik_count  from public.elektronik ;");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("elektronik_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

    public int countD() {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as elektronik_count  from public.elektronik where sicil_no is null;");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("elektronik_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;
    }

    public int countE(Long sicil_no) {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as elektronik_count  from public.elektronik where sicil_no=" + sicil_no);
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("elektronik_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

    public ArrayList<elektronik> findAll(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        ArrayList<elektronik> smList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select to_char(\"al_tarihi\", 'DD/MM/YYYY') as s_al  ,to_char(\"zimmet_tarihi\", 'DD/MM/YYYY') as s_zimmet ,* from public.elektronik order by id desc limit " + pageSize + " offset " + start + "");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                elektronik el = new elektronik();
                el.setId(rs.getLong("id"));
                el.setMalzeme_ad(rs.getString("malzeme_ad"));
                el.setXdsl_ttbarkot_no(rs.getString("xdsl_ttbarkot_no"));
                el.setIm_no(rs.getString("im_no"));
                el.setSeri_no(rs.getString("seri_no"));
                el.setFirma_adi(rs.getString("firma_adi"));
                el.setUkd_tarihi(rs.getString("ukd_tarihi"));
                el.setEk1(rs.getString("ek1"));
                el.setEk2(rs.getString("ek2"));
                el.setJdsu_gövde(rs.getString("jdsu_gövde"));
                el.setJdsu_baslik(rs.getString("jdsu_baslik"));
                el.setCutt_barkot_no(rs.getString("cutt_barkot_no"));
                el.setZimmet_tarihi(rs.getDate("zimmet_tarihi"));
                el.setSicil_no(rs.getLong("sicil_no"));
                el.setDurumu(rs.getString("durumu"));
                el.setS_zimmet(rs.getString("s_zimmet"));
                el.setAl_tarihi(rs.getDate("al_tarihi"));
                el.setS_al(rs.getString("s_al"));
                smList.add(el);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return smList;
    }

    public ArrayList<elektronik> dfindAll(int page, int pageSize, Long sicil_no) {

        int start = (page - 1) * pageSize;
        ArrayList<elektronik> smList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            String sql;
            if (sicil_no == null) {
                sql = ("select *,to_char(\"al_tarihi\", 'DD/MM/YYYY') as s_al,to_char(\"zimmet_tarihi\",'DD/MM/YYYY') as s_zimmet  from public.elektronik  where sicil_no is " + sicil_no + " order by id desc limit " + pageSize + " offset " + start + "");
            } else {
                sql = ("select *,to_char(\"al_tarihi\", 'DD/MM/YYYY') as s_al,to_char(\"zimmet_tarihi\",'DD/MM/YYYY') as s_zimmet  from public.elektronik where sicil_no=" + sicil_no + " order by id desc limit " + pageSize + " offset " + start + "");
            }
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                elektronik el = new elektronik();
                el.setId(rs.getLong("id"));
                el.setMalzeme_ad(rs.getString("malzeme_ad"));
                el.setXdsl_ttbarkot_no(rs.getString("xdsl_ttbarkot_no"));
                el.setIm_no(rs.getString("im_no"));
                el.setSeri_no(rs.getString("seri_no"));
                el.setFirma_adi(rs.getString("firma_adi"));
                el.setUkd_tarihi(rs.getString("ukd_tarihi"));
                el.setEk1(rs.getString("ek1"));
                el.setEk2(rs.getString("ek2"));
                el.setJdsu_gövde(rs.getString("jdsu_gövde"));
                el.setJdsu_baslik(rs.getString("jdsu_baslik"));
                el.setCutt_barkot_no(rs.getString("cutt_barkot_no"));
                el.setZimmet_tarihi(rs.getDate("zimmet_tarihi"));
                el.setSicil_no(rs.getLong("sicil_no"));
                el.setDurumu(rs.getString("durumu"));
                el.setS_zimmet(rs.getString("s_zimmet"));
                el.setAl_tarihi(rs.getDate("al_tarihi"));
                el.setS_al(rs.getString("s_al"));

                smList.add(el);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return smList;
    }

    public void elektronikEkle(elektronik e, kisi k) {
        Connection con = DatabaseConnection.baglanti();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery( "select * from public.elektronik where id=" + e.getId() + "");
           while( rs.next()){
            if (rs.getLong("sicil_no") == 0) {
                Statement st1 = con.createStatement();
                st1.executeUpdate("update  public.elektronik  set  sicil_no=" + k.getSicil_no() + " , zimmet_tarihi='" + e.getZimmet_tarihi() + "' where  id=" + e.getId() + "");

            }
           }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }


    }

    public void kisiElektronikEkle(elektronik e, kisi k) {
        Connection con = DatabaseConnection.baglanti();

        try {
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery("select * from  public.elektronik  where  id= " + e.getId() + ";");
            rs2.next();

            System.out.println("daoekle");
            if (rs2.getLong("sicil_no") == 0) {
                System.out.println("daoekle3");
                Statement st1 = con.createStatement();
                System.out.println("daoekle1");
                st1.executeUpdate("update  public.elektronik  set  sicil_no=" + k.getSicil_no() + " , zimmet_tarihi='" + e.getZimmet_tarihi() + "' where  id=" + e.getId() + " ");
                System.out.println("daoekle2");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void kisiElektronikCikar(elektronik e) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("update public.elektronik set sicil_no=Null  where  id=" + e.getId() + " ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void delete(elektronik el) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st4 = con.createStatement();
            st4.executeUpdate("delete from public.elektronik where id=" + el.getId());

        } catch (SQLException ex) {
            Logger.getLogger(elektronikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(elektronik el) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("update  public.elektronik set malzeme_ad='" + el.getMalzeme_ad() + "',xdsl_ttbarkot_no='" + el.getXdsl_ttbarkot_no() + "',im_no='" + el.getIm_no() + "' ,seri_no='" + el.getSeri_no() + "'  ,firma_adi='" + el.getFirma_adi() + "'  ,ukd_tarihi= '" + el.getUkd_tarihi() + "' ,ek1 ='" + el.getEk1() + "'  ,ek2='" + el.getEk2() + "'  ,jdsu_gövde='" + el.getJdsu_gövde() + "',jdsu_baslik= '" + el.getJdsu_baslik() + "' ,cutt_barkot_no= '" + el.getCutt_barkot_no() + "',al_tarihi='" + el.getAl_tarihi() + "'   where id=" + el.getId() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void create(elektronik el) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("insert into public.elektronik(malzeme_ad,xdsl_ttbarkot_no,im_no,seri_no,firma_adi,ukd_tarihi,ek1,ek2,jdsu_gövde,jdsu_baslik,cutt_barkot_no,durumu,al_tarihi) values ('" + el.getMalzeme_ad() + "','" + el.getXdsl_ttbarkot_no() + "','" + el.getIm_no() + "','" + el.getSeri_no() + "','" + el.getFirma_adi() + "','" + el.getUkd_tarihi() + "','" + el.getEk1() + "','" + el.getEk2() + "','" + el.getJdsu_gövde() + "','" + el.getJdsu_baslik() + "','" + el.getCutt_barkot_no() + "','ÇALIŞIYOR','" + el.getAl_tarihi() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

}
