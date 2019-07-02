/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utility.DatabaseConnection;
import entity.kisi;
import entity.zimmetliMalzeme;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class zimmetliDAO {

    public ArrayList<zimmetliMalzeme> findAll() {

        ArrayList<zimmetliMalzeme> zList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select z.*,to_char(\"al_tarih\", 'DD/MM/YYYY') as al  from public.zimmetli z where z.sicil_no=0");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                zimmetliMalzeme z = new zimmetliMalzeme();
                z.setId(rs.getLong("id"));
                z.setAd(rs.getString("ad"));
                z.setEk1(rs.getString("ek1"));
                z.setEk2(rs.getString("al"));
                z.setAtarih(rs.getDate("al_tarih"));
                z.setZtarih(rs.getDate ("zt"));
                z.setSicil_no(rs.getLong("sicil_no"));
               

                zList.add(z);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return zList;

    }
    
    
    
      public void create(zimmetliMalzeme zm) {
        Connection con=DatabaseConnection.baglanti();
        try{
            Statement st1=con.createStatement();
            st1.executeUpdate("insert into public.zimmetli(id,ad,ek1,ek2,al_tarih,sicil_no) values ("+zm.getId()+",'"+zm.getAd()+"','"+zm.getEk1()+"','"+zm.getEk2()+"','"+zm.getAtarih()+"',0)");
        }
         catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
    }

    
         public ArrayList<zimmetliMalzeme> zimmetliMalzeme(kisi k) {
         ArrayList<zimmetliMalzeme> zmList =new ArrayList<>();
      Connection con ;
         try {
             con=DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from public.zimmetli where sicil_no="+k.getSicil_no());
           
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
                zimmetliMalzeme zm=new zimmetliMalzeme(); 
                zm.setId(rs.getLong("id"));
                zm.setAd(rs.getString("ad"));
                zm.setEk1(rs.getString("ek1"));
                zm.setEk2(rs.getString("ek2"));
                zm.setAtarih(rs.getDate("al_tarih"));
                zm.setZtarih(rs.getDate("zimmettarihi"));
                zmList.add(zm);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        
         return zmList;
    
    }
    
      public void kisiZimmetEkle(zimmetliMalzeme zm, kisi k) {
     Connection con=DatabaseConnection.baglanti();
        try{
             Statement st1=con.createStatement();
            ResultSet rs= st1.executeQuery("select sicil_no from zimmetli where id="+zm.getId());
             rs.next();
             if(rs.getLong("sicil_no")==0){
            
            Statement st=con.createStatement();
            st.executeUpdate("update public.zimmetli set sicil_no="+k.getSicil_no()+" ,zimmettarihi='"+zm.getZtarih()+"' where  id="+zm.getId()+" ");
        }
            
        }
         catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
      }
          
          public void  zimmetMalzemeCikar(zimmetliMalzeme zm) {

         Connection con=DatabaseConnection.baglanti();
        try{
            Statement st1=con.createStatement();
            st1.executeUpdate("update public.zimmetli set sicil_no=0  where  id="+zm.getId()+" ");
        
            
        }
         catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }

    }

    public void update(zimmetliMalzeme z){
        
                Connection con=DatabaseConnection.baglanti();
        try{
            Statement st1=con.createStatement();
            st1.executeUpdate("update public.zimmetli set ad='"+z.getAd()+"',ek1='"+z.getEk1()+"',ek2='"+z.getEk2()+"',al_tarih='"+z.getAtarih()+"' where id="+z.getId()+";");
        }
         catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        
        
    }
        
        
    

    

}
