/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author turktelekom
 */
public class DatabaseConnection {
    
     private static String sglurl="jdbc:postgresql://localhost:5432/postgres?zeroDateTimeBehavior=convertToNull";
    private static String driverName="org.postgresql.Driver";
    private static String username="postgres";
    private static String password="sara123";
    private static Connection con;
    
   
        
     public static Connection baglanti(){
    
   
         try{
            
            Class.forName(driverName).newInstance();
            
            con=DriverManager.getConnection(sglurl,username,password);
        }
        catch(SQLException e){
            
            System.out.println("Veritabanına bağlantı kurulamadı");
          }
        
        catch(ClassNotFoundException | InstantiationException |  IllegalAccessException ex){
            
            System.out.println("Sunucu bulunamadı"); 
        }
        
   
        
    return con;
    }  
     
     
       public void liste(){
         
        try{
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select*from malzemeler");
           while(rs.next()){
              
               System.out.println("id =  " +  rs.getInt(1));
           }
       }catch(SQLException e){
           
           System.out.println("Utilitiy.ConnectionManager.listele()");
       }
     }
     

}