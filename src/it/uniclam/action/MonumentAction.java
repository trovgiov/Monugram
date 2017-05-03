package it.uniclam.action;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Monument;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by GiovanniTrovini on 03/05/17.
 */
public class MonumentAction extends ActionSupport{
     private ArrayList<String> list = new ArrayList<String>();
    private String monument;
private String name;
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

            sql = "SELECT monumento from Monument";

            java.sql.Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

              //Monument m=new Monument(rs.getString("monumento"));
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

        Monument m = new Monument(monument);
        Singleton.setMymonument(m);


             name=u.getNome();


            System.out.println("Nome dopo scelta : "+name+"   "+m.getMonument());

        return "success";

    }

    public String display (){

        return NONE;
    }
}

