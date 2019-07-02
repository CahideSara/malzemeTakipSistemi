///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import Utility.DatabaseConnection;
//import entity.*;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//import javax.swing.JOptionPane;
//
//public class malzemeDAO {
//
//    public ArrayList<malzeme> findAll() {
//        ArrayList<malzeme> mList = new ArrayList<>();
//        Connection con;
//        try {
//            con = DatabaseConnection.baglanti();
//            Statement s = con.createStatement();
//            String sql = ("select  from public.malzemeler m where m.sicil_no=0 ");
//
//            ResultSet rs = s.executeQuery(sql);
//
//            while (rs.next()) {
//                malzeme m = new malzeme();
//                m.setId(rs.getLong("id"));
//                m.setSeri_no(rs.getString("seri_no"));
//                m.setAd(rs.getString("ad"));
//
//                mList.add(m);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//
//        return mList;
//    }
//
//    public ArrayList<malzeme> kisiMalzemeleri(kisi k) {
//        ArrayList<malzeme> mList = new ArrayList<>();
//        Connection con;
//        try {
//            con = DatabaseConnection.baglanti();
//            Statement s = con.createStatement();
//            String sql = ("select * from malzemeler where sicil_no=" + k.getSicil_no());
//
//            ResultSet rs = s.executeQuery(sql);
//
//            while (rs.next()) {
//                malzeme m = new malzeme();
//                m.setId(rs.getLong("id"));
//                m.setSeri_no(rs.getString("seri_no"));
//                m.setAd(rs.getString("ad"));
//
//                mList.add(m);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//
//        return mList;
//    }
//
//    public malzeme find(Long id) {
//        malzeme m = null;
//        Connection con;
//        try {
//            con = DatabaseConnection.baglanti();
//            Statement s = con.createStatement();
//            String sql = ("select * from malzemeler where id=" + id);
//            ResultSet rs = s.executeQuery(sql);
//            rs.next();
//            m = new malzeme();
//            m.setId(rs.getLong("id"));
//            m.setAd(rs.getString("malzeme_ad"));
//            m.setSeri_no(rs.getString("seri_no"));
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return m;
//    }
//
//    public void create(malzeme me) {
//        Connection con = DatabaseConnection.baglanti();
//        try {
//            Statement st1 = con.createStatement();
//            st1.executeUpdate("insert into public.malzemeler(seri_no,ad,id,durumu,sicil_no) values (" + me.getSeri_no() + ",'" + me.getAd().toUpperCase() + "'," + me.getId() + ",0,0)");
//
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select ad from public.turu");
//            int a = 0;
//            while (rs.next()) {
//
//                if (me.getAd().toUpperCase().equals(rs.getString("ad").toUpperCase())) {
//                    a = 1;
//
//                }
//
//            }
//            if (a == 0) {
//
//                Statement st2 = con.createStatement();
//                st2.executeUpdate("insert into public.turu(ad) values ('" + me.getAd().toUpperCase() + "')");
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//
//    }
////
//////   public static void main(String arg[]){
//////     malzemeDAO md=new malzemeDAO();
//////     malzeme m=new malzeme(7l,"1254","cscsa",0);
//////     
//////     md.create(m);
//////     }
//////    
//////    
//
//    public void kisiMalzemeEkle(malzeme m, String tur, kisi k) {
//
//        Connection con = DatabaseConnection.baglanti();
//        try {
//
//            Statement st1 = con.createStatement();
//            ResultSet rs = st1.executeQuery("select sicil_no from malzemeler where id=" + m.getId());
//            rs.next();
//            if (rs.getLong("sicil_no") == 0) {
//
//                Statement st = con.createStatement();
//                st.executeUpdate("update public.malzemeler set sicil_no=" + k.getSicil_no() + " where ad='" + tur + "' and id=" + m.getId() + " ");
//
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//
//    }
//
//    public ArrayList turuAl() {
//        ArrayList<malzeme> turList = new ArrayList<>();
//        Connection con;
//        try {
//            con = DatabaseConnection.baglanti();
//            Statement s = con.createStatement();
//            String sql = ("select * from public.turu ");
//
//            ResultSet rs = s.executeQuery(sql);
//
//            while (rs.next()) {
//                malzeme m = new malzeme();
//                m.setAd(rs.getString("ad"));
//
//                turList.add(m);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//
//        return turList;
//
//    }
//
//    public void kisiMalzemeCikar(malzeme m) {
//
//        Connection con = DatabaseConnection.baglanti();
//        try {
//            Statement st1 = con.createStatement();
//            st1.executeUpdate("update public.malzemeler set sicil_no=0   where  id=" + m.getId() + " ");
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//
//    }
//
//    public void  malzemeTalepEt(kisi k, Date tarih, String tur) {
//      Connection con = DatabaseConnection.baglanti();
//      int a=0;
//        try {
//            
//              Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select ad from public.malzemeler  where sicil_no="+k.getSicil_no()+" and ad='"+tur+"' ");
//            rs.next();
//            if(rs.getString("ad").equals(tur)){
//                JOptionPane.showMessageDialog(null, "olmadı");
//            a=0;
//            }else{
//            Statement st1 = con.createStatement();
//            st1.executeUpdate("insert into public.talepler(malzeme_ad,kisi_ad,kisi_soyad,kisi_sicil,durumu) values ('"+tur+"','"+k.getAd()+"','"+k.getSoyad()+"','"+k.getSicil_no()+"','onay bekliyo'");
//             a=1;
//            }
//            
//                  
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//        
//    
//    }
//
//}
