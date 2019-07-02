/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utility.DatabaseConnection;
import entity.kisi;
import entity.talepler;
import entity.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class taleplerDAO {

    public ArrayList<talepler> findAll(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        ArrayList<talepler> aList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select *,to_char(\"talep_t\", 'DD/MM/YYYY') as s_talep,to_char(\"islem_t\", 'DD/MM/YYYY') as s_islem from public.talepler order by id desc limit " + pageSize + " offset " + start + "");
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                talepler t = new talepler();
                t.setId(rs.getLong("id"));
                t.setKisi_sicil(rs.getLong("kisi_sicil"));
                t.setKisi_ad(rs.getString("kisi_ad"));
                t.setKisi_doyad(rs.getString("kisi_soyad"));
                t.setMalzeme_ad(rs.getString("malzeme_ad"));
                t.setTur(rs.getString("tur"));
                t.setTalep_t(rs.getString("talep_t"));
                t.setDurumu(rs.getString("durumu"));
                t.setIslem_t(rs.getString("islem_t"));
                t.setAciklama(rs.getString("aciklama"));
                t.setS_talep(rs.getString("s_talep"));
                t.setS_islem(rs.getString("s_islem"));
                t.setIslem_y(rs.getString("islem_y"));
                t.setIslem_aciklama(rs.getString("islem_aciklama"));
                aList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

    public ArrayList<talepler> tfindAll(int page, int pageSize, Long sicil) {
        int start = (page - 1) * pageSize;
        ArrayList<talepler> aList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select *,to_char(\"talep_t\", 'DD/MM/YYYY') as s_talep,to_char(\"islem_t\", 'DD/MM/YYYY') as s_islem from public.talepler where kisi_sicil=" + sicil + " order by id desc limit " + pageSize + " offset " + start + "");
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                talepler t = new talepler();
                t.setId(rs.getLong("id"));
                t.setKisi_sicil(rs.getLong("kisi_sicil"));
                t.setKisi_ad(rs.getString("kisi_ad"));
                t.setKisi_doyad(rs.getString("kisi_soyad"));
                t.setMalzeme_ad(rs.getString("malzeme_ad"));
                t.setTur(rs.getString("tur"));
                t.setTalep_t(rs.getString("talep_t"));
                t.setDurumu(rs.getString("durumu"));
                t.setIslem_t(rs.getString("islem_t"));
                t.setAciklama(rs.getString("aciklama"));
                t.setS_talep(rs.getString("s_talep"));
                t.setS_islem(rs.getString("s_islem"));
                t.setIslem_y(rs.getString("islem_y"));
                t.setIslem_aciklama(rs.getString("islem_aciklama"));
                aList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

    public int count() {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as sarf_count  from public.talepler ;");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("sarf_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int tcount(Long sicil) {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as sarf_count  from public.talepler where kisi_sicil=" + sicil);
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("sarf_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public void sarfTalebi(kisi k, talepler tlp, String tur) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            String sql = ("insert into public.talepler(kisi_sicil,kisi_ad,kisi_soyad,malzeme_ad,tur,talep_t,durumu,aciklama) values (" + k.getSicil_no() + ",'" + k.getAd() + "','" + k.getSoyad() + "','" + tur + "','SARF MALZEME','" + tlp.getTalep_t() + "','ONAY BEKLİYOR','" + tlp.getAciklama() + "')");
            st1.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void elektronikTalebi(kisi k, talepler tlp) {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("insert into public.talepler(kisi_sicil,kisi_ad,kisi_soyad,malzeme_ad,tur,talep_t,durumu,aciklama) values (" + k.getSicil_no() + ",'" + k.getAd() + "','" + k.getSoyad() + "','" + tlp.getMalzeme_ad() + "','ELEKTRONİK MALZEME','" + tlp.getTalep_t() + "','ONAY BEKLİYOR','" + tlp.getAciklama() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void talepVazgec(talepler tlp, kisi k) {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("update  public.talepler set islem_t='" + tlp.getIslem_t() + "' ,islem_y='" + k.getAd() + "  " + k.getSoyad() + "/" + k.getKonumu() + "' ,islem_aciklama='" + tlp.getIslem_aciklama() + "' ,durumu='İŞLEM İPTAL EDİLDİ' where id=" + tlp.getId() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void talepIslemi(talepler tlp, kisi k) {
        Connection con = DatabaseConnection.baglanti();
        try {
            if (tlp.getDurumu().equals("ONAYLA")) {
                Statement st1 = con.createStatement();
                st1.executeUpdate("update  public.talepler set islem_t='" + tlp.getIslem_t() + "' ,islem_y='" + k.getAd() + "  " + k.getSoyad() + "/" + k.getKonumu() + "' ,islem_aciklama='" + tlp.getIslem_aciklama() + "' ,durumu='ONAYLANDI' where id=" + tlp.getId() + "");

            } else if (tlp.getDurumu().equals("REDDET")) {
                Statement st1 = con.createStatement();
                st1.executeUpdate("update  public.talepler set islem_t='" + tlp.getIslem_t() + "' ,islem_y='" + k.getAd() + "  " + k.getSoyad() + "/" + k.getKonumu() + "' ,islem_aciklama='" + tlp.getIslem_aciklama() + "' ,durumu='REDDEDİLDİ' where id=" + tlp.getId() + "");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public ArrayList amirfindAll(int pageamtlp, int pageSize, user r) {

        int start = (pageamtlp - 1) * pageSize;
        ArrayList aList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();

            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select ekibi from public.kisiler where sicil_no=" + r.getSicil_no());
            rs1.next();

            System.out.println(rs1.getString("ekibi") + "aaaaaa");
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery("select *,to_char(\"talep_t\", 'DD/MM/YYYY') as s_talep,to_char(\"islem_t\", 'DD/MM/YYYY') as s_islem  from  public.talepler where kisi_sicil in (select sicil_no from public.kisiler where ekibi='" + rs1.getString("ekibi") + "') order by id desc limit " + pageSize + " offset " + start + "");

            while (rs.next()) {
                talepler t = new talepler();
                t.setId(rs.getLong("id"));
                t.setKisi_sicil(rs.getLong("kisi_sicil"));
                t.setKisi_ad(rs.getString("kisi_ad"));
                t.setKisi_doyad(rs.getString("kisi_soyad"));
                t.setMalzeme_ad(rs.getString("malzeme_ad"));
                t.setTur(rs.getString("tur"));
                t.setTalep_t(rs.getString("talep_t"));
                t.setDurumu(rs.getString("durumu"));
                t.setIslem_t(rs.getString("islem_t"));
                t.setAciklama(rs.getString("aciklama"));
                t.setS_talep(rs.getString("s_talep"));
                t.setS_islem(rs.getString("s_islem"));
                t.setIslem_y(rs.getString("islem_y"));
                t.setIslem_aciklama(rs.getString("islem_aciklama"));
                aList.add(t);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return aList;

    }

    public int countamirtlp(user r) {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement st = con.createStatement();
            ResultSet rr = st.executeQuery("select ekibi from public.kisiler where sicil_no=" + r.getSicil_no());
            rr.next();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select count(kisi_sicil) as tlp from talepler where kisi_sicil in (select sicil_no from kisiler where ekibi='" + rr.getString("ekibi") + "')");
            rs.next();
            count = rs.getInt("tlp");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

}
