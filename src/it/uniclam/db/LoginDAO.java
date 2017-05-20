package it.uniclam.db;

/**
 * Created by GiovanniTrovini on 21/04/17.
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

private static String user_email;

    public static boolean validate(String email,String password){
        boolean status=false;
        try{

            Connection con = DBUtility.getDBConnection();

            PreparedStatement ps=con.prepareStatement(
                    "select * from User where email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();





            user_email=email;

            //System.out.println("Email "+getUser_email());
            status=rs.next();
         }catch(Exception e){e.printStackTrace();}
        return status;
    }


    public static String getUser_email() {
        return user_email;
    }

    public static void setUser_email(String user_email) {
        LoginDAO.user_email = user_email;
    }
}