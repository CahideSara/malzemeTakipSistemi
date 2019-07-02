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

/**
 *
 * @author asus
 */
public class userDAO {

    public kisi find(Long id) {
        kisi k = null;

        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from kisiler where sicil_no=" + id);
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            k = new kisi();
            k.setAd(rs.getString("ad"));
            k.setSoyad(rs.getString("soyad"));
            k.setTelefon(rs.getString("telefon"));
            k.setSicil_no(rs.getLong("sicil_no"));
            k.setEkibi(rs.getString("ekibi"));
            k.setMail(rs.getString("mail"));
            k.setGörevi(rs.getString("gorevi"));
            k.setKonumu(rs.getString("konumu"));
            k.setId(rs.getLong("id"));
            k.setTt_firma(rs.getString("tt_firma"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return k;

    }

    public user kullanıcı(Long id) {
        user k = null;

        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from user where sicil_no=" + id);
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            k = new user();
            k.setSicil_no(rs.getLong("sicil_no"));
            k.setKullanici_adi(rs.getString("kullanici_adi"));
            k.setSifre(rs.getString("sifre"));
            k.setSoru(rs.getString("soru"));
            k.setCevap(rs.getString("cevap"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return k;

    }

    public void kullanıcıGüncelle(user r) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("update  public.user set kullanici_adi='" + r.getKullanici_adi() + "',sifre='" + r.getSifre() + "',soru='" + r.getSoru() + "',cevap='" + r.getCevap() + "' where sicil_no=" + r.getSicil_no());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
       public void hadi(user r) {

        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st1 = con.createStatement();
            st1.executeUpdate("update  public.user set kullanici_adi='" + r.getKullanici_adi() + "',sifre='" + r.getSifre() + "'  where sicil_no=" + 6);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    
       }

}
