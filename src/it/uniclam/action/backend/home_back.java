package it.uniclam.action.backend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Session;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

import java.sql.*;

/**
 * Created by GiovanniTrovini on 21/05/17.
 */
public class home_back extends ActionSupport {


    public int getUconn() {
        return uconn;
    }

    public void setUconn(int uconn) {
        this.uconn = uconn;
    }

    private int uconn;

    public int getTotPh() {
        return totPh;
    }

    public void setTotPh(int totPh) {
        this.totPh = totPh;
    }

    private int totPh;

    public int getTotMon() {
        return totMon;
    }

    public void setTotMon(int totMon) {
        this.totMon = totMon;
    }

    private int totMon;

    public int getPcheck() {
        return pcheck;
    }

    public void setPcheck(int pcheck) {
        this.pcheck = pcheck;
    }

    private int pcheck;


    private Connection dbConnection;
    private PreparedStatement pStmt;




    public String execute (){

        Session s = Singleton.getMysession();
        System.out.println("Session id " +s.getId());


        User u = Singleton.getMyUser();
        System.out.println("Username " +u.getUsername());

        uconn = showUserConn();
        totPh = showTotPhoto();
        totMon = showTotMon();
        pcheck = showCheckPh();

        System.out.println("UTENTI ATTIVI "+uconn);
        System.out.println("PHOTO UNCHECHED "+totPh);
        System.out.println("PHOTO CHECHED "+pcheck);
        System.out.println("TOT MONUMENTI "+totMon);

        return "success";
    }

    public static int showUserConn()
    {
        int stat=0;
        java.sql.Statement st = null;
        String statQuery = "SELECT COUNT(\"idUser\") as UtentiAttivi FROM User;";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(statQuery);
            if (rs1.next()) {
                stat = rs1.getInt("UtentiAttivi");
            }
            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return stat;
    }

    public static int showTotPhoto()
    {
        int ph=0;
        java.sql.Statement st = null;
        String statQuery = "SELECT COUNT(\"status\") as unchecked from Photo where status='unchecked'";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(statQuery);
            if (rs1.next()) {
                ph = rs1.getInt("unchecked");
            }
            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return ph;
    }

    public static int showTotMon()
    {
        int tmon=0;
        java.sql.Statement st = null;
        String statQuery = "SELECT COUNT(\"idMonument\") as totMon FROM Monument";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(statQuery);
            if (rs1.next()) {
                tmon = rs1.getInt("totMon");
            }
            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return tmon;
    }

    public static int showCheckPh()
    {
        int pch=0;
        java.sql.Statement st = null;
        String statQuery = "SELECT COUNT(\"status\") as status from Photo where status='checked'";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(statQuery);
            if (rs1.next()) {
                pch = rs1.getInt("status");
            }

            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }



        return pch;
    }
}
