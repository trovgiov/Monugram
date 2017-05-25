package it.uniclam.action.frontend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Monument;
import it.uniclam.model.Session;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MonumentAction extends ActionSupport{
     private ArrayList<String> list = new ArrayList<String>();
    private String monument;
private String name;
private int idmon;
Monument m;

    public Monument getM() {
        return m;
    }

    public void setM(Monument m) {
        this.m = m;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }

    public MonumentAction (){
        try{

            Connection con = DBUtility.getDBConnection();

            String sql;

            sql = "SELECT idMonument,monumento from Monument";

            java.sql.Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

              //Monument m=new Monument(rs.getString("monumento"));
                //idmon=rs.getInt("idMonument");

                monument = rs.getString("monumento");
               list.add(monument);
            }
            // chiusura rs2 e stmt2
            rs.close();
            stmt.close();
            // chiusura rs e stmt
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute (){
        User u = Singleton.getMyUser();
        Session s = Singleton.getMysession();

        int idmon = findMonId(monument);
        Monument m = new Monument(idmon,monument);
        Singleton.setMymonument(m);

             name=u.getNome();

            //System.out.println("Nome dopo scelta : "+name+" Monumento : "+m.getMonument()+" "+m.getIdMonument());

        return "success";
    }

    public String display (){

        return NONE;
    }


    public static int findMonId(String n_monumento)
    {
        int mId=0;
        java.sql.Statement st = null;
        try{

            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            String query = "select idMonument from Monument where monumento='"+n_monumento+"';";

            ResultSet rs=st.executeQuery(query);

            if (rs.next())
            {
                mId = rs.getInt("idMonument");
            }
        }catch(Exception e){e.printStackTrace();}

        return mId;
    }
}
