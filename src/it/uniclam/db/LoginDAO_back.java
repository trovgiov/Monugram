package it.uniclam.db;

/**
 * Created by GiovanniTrovini on 21/04/17.
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO_back {


    public static boolean validate(String username, String password) {
        boolean status = false;
        try {

            Connection con = DBUtility.getDBConnection();

            PreparedStatement ps = con.prepareStatement(
                    "select * from Admin where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();


            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}