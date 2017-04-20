package it.uniclam.db;

import it.uniclam.action.RegisterAction;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by GiovanniTrovini on 20/04/17.
 */
public class RegisterDAO {

    public static int save(RegisterAction r) {

        int status = 0;

        try {
            Connection con = DBUtility.getDBConnection();
            PreparedStatement stmt = con
                    .prepareStatement("insert into User (nome,cognome,email,password, point) values(?,?,?,?,3)");

            stmt.setString(1,r.getNome());
            stmt.setString(2,r.getCognome());
            stmt.setString(3,r.getEmail());
            stmt.setString(4,r.getPassword());






            status=stmt.executeUpdate(); // execute query

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }





}
