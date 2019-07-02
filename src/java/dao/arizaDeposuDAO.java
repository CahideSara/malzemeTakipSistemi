/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utility.DatabaseConnection;
import entity.arizaDeposu;
import entity.elektronik;
import entity.sarf_malzemeler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class arizaDeposuDAO {

    public ArrayList<arizaDeposu> findAll(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        ArrayList<arizaDeposu> aList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from public.arizalar where durumu='ONAYLI' or durumu='REDDEDİLDİ'or durumu='ARIZA GİDERİLDİ' order by id desc limit " + pageSize + " offset " + start + "");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                arizaDeposu az = new arizaDeposu();
                az.setId(rs.getLong("id"));
                az.setMalzeme_ad(rs.getString("malzeme_ad"));
                az.setArizak(rs.getString("arizak"));
                az.setSarf_id(rs.getLong("sarf_id"));
                az.setElektronik_id(rs.getLong("elektronik_id"));
                az.setAriza_nedeni(rs.getString("ariza_nedeni"));
                az.setArizat(rs.getString("arizat"));
                az.setTur(rs.getString("tur"));
                az.setDurumu(rs.getString("durumu"));

                aList.add(az);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return aList;
    }

     public ArrayList<arizaDeposu> amirfindAll(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        ArrayList<arizaDeposu> aList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from public.arizalar order by id desc limit " + pageSize + " offset " + start + "");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                arizaDeposu az = new arizaDeposu();
                az.setId(rs.getLong("id"));
                az.setMalzeme_ad(rs.getString("malzeme_ad"));
                az.setArizak(rs.getString("arizak"));
                az.setSarf_id(rs.getLong("sarf_id"));
                az.setElektronik_id(rs.getLong("elektronik_id"));
                az.setAriza_nedeni(rs.getString("ariza_nedeni"));
                az.setArizat(rs.getString("arizat"));
                az.setTur(rs.getString("tur"));
                az.setDurumu(rs.getString("durumu"));

                aList.add(az);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return aList;
    }
    public ArrayList<arizaDeposu> onaysızfindAll(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        ArrayList<arizaDeposu> aList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from public.arizalar where durumu='ONAY BEKLİYOR' order by id desc limit " + pageSize + " offset " + start + "");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                arizaDeposu az = new arizaDeposu();
                az.setId(rs.getLong("id"));
                az.setMalzeme_ad(rs.getString("malzeme_ad"));
                az.setArizak(rs.getString("arizak"));
                az.setSarf_id(rs.getLong("sarf_id"));
                az.setElektronik_id(rs.getLong("elektronik_id"));
                az.setAriza_nedeni(rs.getString("ariza_nedeni"));
                az.setArizat(rs.getString("arizat"));
                az.setTur(rs.getString("tur"));
                az.setDurumu(rs.getString("durumu"));

                aList.add(az);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return aList;
    }

    public ArrayList<arizaDeposu> kfindAll(int page, int pageSize, Long sicil) {
        int start = (page - 1) * pageSize;
        ArrayList<arizaDeposu> aList = new ArrayList<>();
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select * from public.arizalar where arizak='" + sicil + "' order by id desc limit " + pageSize + " offset " + start + "");

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                arizaDeposu az = new arizaDeposu();
                az.setId(rs.getLong("id"));
                az.setMalzeme_ad(rs.getString("malzeme_ad"));
                az.setArizak(rs.getString("arizak"));
                az.setSarf_id(rs.getLong("sarf_id"));
                az.setElektronik_id(rs.getLong("elektronik_id"));
                az.setAriza_nedeni(rs.getString("ariza_nedeni"));
                az.setArizat(rs.getString("arizat"));
                az.setTur(rs.getString("tur"));
                az.setDurumu(rs.getString("durumu"));

                aList.add(az);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return aList;
    }

    public void sarfArizabildir(sarf_malzemeler sm, arizaDeposu az) {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from public.sarfmalzemeler where id=" + sm.getId());
            rs.next();

            if (rs.getString("durumu").equals("ÇALIŞIYOR")) {
                if (rs.getLong("sicil_no") != 0) {
                    Statement st3 = con.createStatement();
                    st3.executeUpdate("insert into public.arizalar(sarf_id,malzeme_ad,arizak,ariza_nedeni,arizat,tur,durumu) values (" + sm.getId() + ",'" + sm.getMalzeme_ad() + "','" + sm.getSicil_no() + "','" + az.getAriza_nedeni() + "','" + az.getArizat() + "','SARF MALZEME','ONAY BEKLİYOR')");

                } else {
                    Statement st1 = con.createStatement();
                    st1.executeUpdate("insert into public.arizalar(sarf_id,malzeme_ad,arizak,ariza_nedeni,arizat,tur,durumu) values(" + sm.getId() + ",'" + sm.getMalzeme_ad() + "','depo','" + az.getAriza_nedeni() + "','" + az.getArizat() + "','SARF MALZEME','ONAYLI')");

                    Statement st2 = con.createStatement();
                    st2.executeUpdate("update sarfmalzemeler set durumu='ARIZALI' where id=" + sm.getId());

                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void elektronikArizabildir(elektronik e, arizaDeposu az) {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from public.elektronik where id=" + e.getId());
            rs.next();
            if (rs.getString("durumu").equals("ÇALIŞIYOR")) {
                if (rs.getLong("sicil_no") != 0) {
                    Statement st3 = con.createStatement();
                    st3.executeUpdate("insert into public.arizalar(elektronik_id,malzeme_ad,arizak,ariza_nedeni,arizat,tur,durumu) values(" + e.getId() + ",'" + e.getMalzeme_ad() + "','" + e.getSicil_no() + "','" + az.getAriza_nedeni() + "','" + az.getArizat() + "','ELEKTRONİK','ONAY BEKLİYOR')");

                } else {
                    Statement st1 = con.createStatement();
                    st1.executeUpdate("insert into public.arizalar(elektronik_id,malzeme_ad,arizak,ariza_nedeni,arizat,tur,durumu) values "
                            + "(" + e.getId() + ",'" + e.getMalzeme_ad() + "','depo','" + az.getAriza_nedeni() + "','" + az.getArizat() + "','ELEKTRONİK','ONAYLI')");

                    Statement st2 = con.createStatement();
                    st2.executeUpdate("update public.elektronik set durumu='ARIZALI' where id=" + e.getId());

                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void arizaGider(arizaDeposu az) {
        Connection con = DatabaseConnection.baglanti();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from arizalar where id=" + az.getId());
            rs.next();

            if (rs.getLong("sarf_id") != 0) {
                Statement st1 = con.createStatement();
                st1.executeUpdate("update sarfmalzemeler set durumu='ÇALIŞIYOR' where id=" + az.getSarf_id() + ";");

            } else if (rs.getLong("elektronik_id") != 0) {
                Statement st2 = con.createStatement();
                st2.executeUpdate("update elektronik set durumu='ÇALIŞIYOR' where id=" + az.getElektronik_id() + ";");

            }
            Statement st3 = con.createStatement();
            st3.executeUpdate("update arizalar set durumu='ARIZA GİDERİLDİ' where id=" + az.getId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public int count() {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as ariza_count  from public.arizalar where durumu='ONAYLI' or durumu='REDDEDİLDİ'or durumu='ARIZA GİDERİLDİ'");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("ariza_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }
    
        public int amircount() {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as ariza_count  from public.arizalar ");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("ariza_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

    public int countb() {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as ariza_count  from public.arizalar where durumu='ONAY BEKLİYOR'");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("ariza_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

    public int kcount(Long sicil) {
        Connection con;
        int count = 0;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            String sql = ("select count(id) as ariza_count  from public.arizalar where arizak='" + sicil + "' ");
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("ariza_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return count;

    }

    public void kabul(arizaDeposu az) {
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            s.executeUpdate("update arizalar set durumu='ONAYLI' where id=" + az.getId() + " ");
            if (az.getElektronik_id() != null) {
                Statement st2 = con.createStatement();
                st2.executeUpdate("update public.elektronik set durumu='ARIZALI' where id=" + az.getElektronik_id());
            }  if (az.getSarf_id() != null) {
                Statement st3 = con.createStatement();
                st3.executeUpdate("update public.sarfmalzemeler set durumu='ARIZALI' where id=" + az.getSarf_id());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void red(arizaDeposu az) {
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            s.executeUpdate("update arizalar set durumu='REDDEDİLDİ' where id=" + az.getId() + " ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void arizaVazgec(arizaDeposu az) {
        Connection con;
        try {
            con = DatabaseConnection.baglanti();
            Statement s = con.createStatement();
            s.executeUpdate("delete from arizalar where id= "+az.getId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
