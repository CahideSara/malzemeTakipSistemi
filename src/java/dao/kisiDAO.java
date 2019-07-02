/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utility.DatabaseConnection;
import entity.kisi;
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
public class kisiDAO {

    public ArrayList findAll(int page, int pageSize) {

        int start = (page - 1) * pageSize;
        ArrayList<kisi> kList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from public.kisiler order by id desc limit " + pageSize + " offset " + start + "");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                kisi k = new kisi();
                k.setId(rs.getLong("id"));
                k.setSicil_no(rs.getLong("sicil_no"));
                k.setAd(rs.getString("ad"));
                k.setSoyad(rs.getString("soyad"));
                k.setTelefon(rs.getString("telefon"));
                k.setMail(rs.getString("mail"));
                k.setEkibi(rs.getString("ekibi"));
                k.setGörevi(rs.getString("gorevi"));
                k.setKonumu(rs.getString("konumu"));
                k.setTt_firma(rs.getString("tt_firma"));
                kList.add(k);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return kList;

    }

    public int count() {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as kisi_count  from public.kisiler ;");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("kisi_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

    public boolean create(kisi k) {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("insert into public.kisiler(sicil_no,ad,soyad,telefon,ekibi,mail,gorevi,konumu,tt_firma) values (" + k.getSicil_no() + ",'" + k.getAd() + "','" + k.getSoyad() + "','" + k.getTelefon() + "','" + k.getEkibi() + "','" + k.getMail() + "','" + k.getGörevi() + "','" + k.getKonumu() + "','" + k.getTt_firma() + "');");

            Statement st = con.createStatement();
            st.executeUpdate("insert into public.user (sicil_no,kullanici_adi,sifre) values (" + k.getSicil_no() + ",'turktelekom','turktelekom')");

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          return false;
        }

    }

    public void update(kisi k) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st4 = con.createStatement();
            ResultSet rs4 = st4.executeQuery("select konumu from public.kisiler  where  id=" + k.getId() + " ;");
            rs4.next();
            if (rs4.getString("konumu").equals("BAŞ YETKİLİ") == true) {
                if (k.getKonumu().equals("BAŞ YETKİLİ") == false) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select konumu,count(konumu) as top from kisiler  where konumu='BAŞ YETKİLİ'  group by konumu  ;");
                    rs.next();
                    if (rs.getInt("top") != 1) {
                        Statement st1 = con.createStatement();
                        st1.executeUpdate("update kisiler set tt_firma='" + k.getTt_firma() + "', sicil_no=" + k.getSicil_no() + ",ad='" + k.getAd() + "',soyad='" + k.getSoyad() + "',telefon='" + k.getTelefon() + "',ekibi='" + k.getEkibi() + "',mail='" + k.getMail() + "',gorevi='" + k.getGörevi() + "',konumu='" + k.getKonumu() + "'  where   id=" + k.getId() + " ;");
                    }

                } else {
                    Statement st3 = con.createStatement();
                    st3.executeUpdate("update kisiler set tt_firma='" + k.getTt_firma() + "',sicil_no=" + k.getSicil_no() + ",ad='" + k.getAd() + "',soyad='" + k.getSoyad() + "',telefon='" + k.getTelefon() + "',ekibi='" + k.getEkibi() + "',mail='" + k.getMail() + "',gorevi='" + k.getGörevi() + "',konumu='" + k.getKonumu() + "'  where   id=" + k.getId() + " ;");
                }
            } else {
                Statement st2 = con.createStatement();
                st2.executeUpdate("update kisiler set tt_firma='" + k.getTt_firma() + "',sicil_no=" + k.getSicil_no() + ",ad='" + k.getAd() + "',soyad='" + k.getSoyad() + "',telefon='" + k.getTelefon() + "',ekibi='" + k.getEkibi() + "',mail='" + k.getMail() + "',gorevi='" + k.getGörevi() + "',konumu='" + k.getKonumu() + "'  where   id=" + k.getId() + " ;");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public boolean kontrol(kisi k, boolean a) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st4 = con.createStatement();
            ResultSet rs4 = st4.executeQuery("select konumu from public.kisiler  where  id=" + k.getId() + " ;");
            rs4.next();
            if (rs4.getString("konumu").equals("BAŞ YETKİLİ") == true) {
                if (k.getKonumu().equals("BAŞ YETKİLİ") == false) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select konumu,count(konumu) as top from kisiler  where konumu='BAŞ YETKİLİ'  group by konumu  ;");
                    rs.next();
                    if (rs.getInt("top") == 1) {
                        return false;
                    }

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return true;
    }

    public void delete(kisi k) {
        Connection con = DatabaseConnection.baglanti();
        try {
            if (k.getKonumu().equals("BAŞ YETKİLİ")) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select count(konumu) as top from kisiler group by konumu having konumu='BAŞ YETKİLİ';");
                rs.next();

                if (rs.getInt("top") != 1) {
                    Statement st1 = con.createStatement();
                    st1.executeUpdate("delete from public.kisiler where sicil_no=" + k.getSicil_no() + " ");
                }
            } else {

                Statement st2 = con.createStatement();
                st2.executeUpdate("delete from public.kisiler where sicil_no=" + k.getSicil_no() + " ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public ArrayList amirfindAll(int pageamk, int pageSize, user r) {
   
     int start = (pageamk - 1) * pageSize;
        ArrayList<kisi> kList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select ekibi from kisiler where sicil_no="+r.getSicil_no());
            rs1.next();
            Statement s = con.createStatement();
            String sql = ("select * from public.kisiler where ekibi='"+rs1.getString("ekibi")+"' order by id desc limit " + pageSize + " offset " + start + "");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                kisi k = new kisi();
                k.setId(rs.getLong("id"));
                k.setSicil_no(rs.getLong("sicil_no"));
                k.setAd(rs.getString("ad"));
                k.setSoyad(rs.getString("soyad"));
                k.setTelefon(rs.getString("telefon"));
                k.setMail(rs.getString("mail"));
                k.setEkibi(rs.getString("ekibi"));
                k.setGörevi(rs.getString("gorevi"));
                k.setKonumu(rs.getString("konumu"));
                k.setTt_firma(rs.getString("tt_firma"));
                kList.add(k);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return kList;

    
    }
    
      public int countamk(user r) {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
             Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select ekibi from public.kisiler where sicil_no="+r.getSicil_no());
            rs1.next();
            Statement s = con.createStatement();
            String sql = ("select count(id) as kisi_count  from public.kisiler where ekibi='"+rs1.getString("ekibi")+"'");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("kisi_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

}
