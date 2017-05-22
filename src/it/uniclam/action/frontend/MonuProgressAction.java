package it.uniclam.action.frontend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Monument;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by GiovanniTrovini on 21/05/17.
 */
public class MonuProgressAction extends ActionSupport {


private String monumento;
private int progress;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getMonumento() {
        return monumento;
    }

    public void setMonumento(String monumento) {
        this.monumento = monumento;
    }

    public String execute(){


        try{

            Connection con = DBUtility.getDBConnection();

            String sql;

            sql = "select * from Monument where monumento ='"+getMonumento()+"' ";

            java.sql.Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {

                 Monument m=new Monument(rs.getInt("idMonument"),rs.getString("monumento"),rs.getInt("progress"));



                System.out.println("progress"+m.getProgress());
progress=m.getProgress();

            }




            // chiusura rs2 e stmt2
            rs.close();
            stmt.close();
            // chiusura rs e stmt
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }











        return "success";
    }


}
