/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utility.DatabaseConnection;
import entity.kisi;
import entity.sarf_malzemeler;
import entity.talepler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class sarfDAO {

    public ArrayList<sarf_malzemeler> findAll(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        ArrayList<sarf_malzemeler> smList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select *,to_char(\"al_tarih\", 'DD/MM/YYYY') as s_al ,to_char(\"zimmet_tarihi\", 'DD/MM/YYYY') as s_zimmet  from public.sarfmalzemeler order by id desc limit " + pageSize + " offset " + start + "");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                sarf_malzemeler sf = new sarf_malzemeler();
                sf.setId(rs.getLong("id"));
                sf.setMalzeme_ad(rs.getString("malzeme_ad"));
                sf.setFirma_ad(rs.getString("firma_adi"));
                sf.setEbat(rs.getString("ebat"));
                sf.setSicil_no(rs.getLong("sicil_no"));
                sf.setDurumu(rs.getString("durumu"));
                sf.setAl_tarihi(rs.getDate("al_tarih"));
                sf.setZimmet_tarihi(rs.getDate("zimmet_tarihi"));
                sf.setEk_1(rs.getString("ek_özellikler"));
                sf.setS_al(rs.getString("s_al"));
                sf.setS_zimmet(rs.getString("s_zimmet"));

                smList.add(sf);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return smList;

    }

    public ArrayList<sarf_malzemeler> dfindAll(int page, int pageSize, Long sicil_no) {

        int start = (page - 1) * pageSize;
        ArrayList<sarf_malzemeler> smList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            String sql;
            if (sicil_no == null) {
                sql = ("select *,to_char(\"al_tarih\", 'DD/MM/YYYY') as s_al ,to_char(\"zimmet_tarihi\", 'DD/MM/YYYY') as s_zimmet  from public.sarfmalzemeler  where sicil_no is " + sicil_no + " order by id desc limit " + pageSize + " offset " + start + " ");
            } else {
                sql = ("select *,to_char(\"al_tarih\", 'DD/MM/YYYY') as s_al ,to_char(\"zimmet_tarihi\", 'DD/MM/YYYY') as s_zimmet  from public.sarfmalzemeler where sicil_no=" + sicil_no + " order by id desc limit " + pageSize + " offset " + start + " ");
            }
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                sarf_malzemeler sf = new sarf_malzemeler();
                sf.setId(rs.getLong("id"));
                sf.setMalzeme_ad(rs.getString("malzeme_ad"));
                sf.setFirma_ad(rs.getString("firma_adi"));
                sf.setEbat(rs.getString("ebat"));
                sf.setSicil_no(rs.getLong("sicil_no"));
                sf.setDurumu(rs.getString("durumu"));
                sf.setAl_tarihi(rs.getDate("al_tarih"));
                sf.setZimmet_tarihi(rs.getDate("zimmet_tarihi"));
                sf.setEk_1(rs.getString("ek_özellikler"));
                sf.setS_al(rs.getString("s_al"));
                sf.setS_zimmet(rs.getString("s_zimmet"));

                smList.add(sf);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return smList;
    }

    public int count() {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as sarf_count  from public.sarfmalzemeler ;");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("sarf_count");

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
            String sql = ("select count(id) as sarf_count  from public.sarfmalzemeler where sicil_no is null;");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("sarf_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

    public int countK(Long sicil_no) {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as sarf_count  from public.sarfmalzemeler where sicil_no=" + sicil_no);
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("sarf_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

    public void create(sarf_malzemeler sarfm) {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("insert into public.sarfmalzemeler(malzeme_ad,firma_adi,ebat,durumu,al_tarih,ek_özellikler) values ('" + sarfm.getMalzeme_ad().toUpperCase() + "','" + sarfm.getFirma_ad() + "','" + sarfm.getEbat() + "','ÇALIŞIYOR','" + sarfm.getAl_tarihi() + "','" + sarfm.getEk_1() + "')");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ad from public.turu");
            int a = 0;
            while (rs.next()) {

                if (sarfm.getMalzeme_ad().toUpperCase().equals(rs.getString("ad").toUpperCase())) {
                    a = 1;

                }

            }
            if (a == 0) {

                Statement st2 = con.createStatement();
                st2.executeUpdate("insert into public.turu(ad) values ('" + sarfm.getMalzeme_ad().toUpperCase() + "')");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(sarf_malzemeler sarfm) {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("update  public.sarfmalzemeler set malzeme_ad='" + sarfm.getMalzeme_ad().toUpperCase() + "',firma_adi='" + sarfm.getFirma_ad() + "',ebat='" + sarfm.getEbat() + "',al_tarih='" + sarfm.getAl_tarihi() + "',ek_özellikler='" + sarfm.getEk_1() + "' where id=" + sarfm.getId());

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ad from public.turu");
            int a = 0;
            while (rs.next()) {

                if (sarfm.getMalzeme_ad().toUpperCase().equals(rs.getString("ad").toUpperCase())) {
                    a = 1;

                }

            }
            if (a == 0) {

                Statement st2 = con.createStatement();
                st2.executeUpdate("insert into public.turu(ad) values ('" + sarfm.getMalzeme_ad().toUpperCase() + "')");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(sarf_malzemeler sarfm) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select malzeme_ad from public.sarfmalzemeler where id=" + sarfm.getId());
            rs.next();
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery("select count(malzeme_ad) as say  from public.sarfmalzemeler where malzeme_ad='" + rs.getString("malzeme_ad") + "'");
            rs1.next();
            if (rs1.getInt("say") == 1) {
                Statement st2 = con.createStatement();
                st2.executeUpdate("delete from public.turu where ad='" + rs.getString("malzeme_ad") + "'");
                Statement st3 = con.createStatement();
                st3.executeUpdate("delete from public.sarfmalzemeler where id=" + sarfm.getId());

            } else {
                Statement st4 = con.createStatement();
                st4.executeUpdate("delete from public.sarfmalzemeler where id=" + sarfm.getId());

            }
        } catch (SQLException ex) {
            Logger.getLogger(sarfDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kisiSarfMalzemeEkle(sarf_malzemeler m, String tur, kisi k) {

        Connection con = DatabaseConnection.baglanti();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select sicil_no from sarfmalzemeler where id=" + m.getId());
            rs.next();
            if (rs.getLong("sicil_no") == 0) {

                Statement st1 = con.createStatement();
                st1.executeUpdate("update public.sarfmalzemeler set sicil_no=" + k.getSicil_no() + " , zimmet_tarihi='" + m.getZimmet_tarihi() + "' where malzeme_ad='" + tur + "' and id=" + m.getId() + " ");

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void kisiSarfMalzemeCikar(sarf_malzemeler m) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("update public.sarfmalzemeler set sicil_no=Null  where  id=" + m.getId() + " ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public ArrayList turuAl() {
        ArrayList<sarf_malzemeler> turList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from public.turu ");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                sarf_malzemeler m = new sarf_malzemeler();
                m.setMalzeme_ad(rs.getString("ad"));

                turList.add(m);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return turList;

    }   

    public ArrayList kisiMalzemeleri(kisi k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
