package it.uniclam.db;

import it.uniclam.action.RegisterAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by GiovanniTrovini on 20/04/17.
 */
public class RegisterDAO {


    public static boolean checkUser(RegisterAction r)
    {
        /*
            CONTROLLO SE L'EMAIL E' GIA' PRESENTE NEL DB
         */
        boolean end = false;

        try {
            Connection con2 = DBUtility.getDBConnection();

            String tst = null;
            String sql = "SELECT email from User";


            java.sql.Statement stm2 = con2.createStatement();

            ResultSet rs2 = stm2.executeQuery(sql);

            while (rs2.next()) {
                tst = rs2.getString("email");
                if (r.getEmail().equals(tst)) {
                    end = true;
                }
            }

            stm2.close();
            rs2.close();
            con2.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return end;
    }

    public static int save(RegisterAction r)
    {

        int status = 0;
        boolean check = checkUser(r);
        //System.out.println(".............."+check);


        boolean checkemail=false;

        //controllo

        // se vero check mail = true
        //altrimenti status = -1;


        if(check == false && checkemail==true)
        {
            // Inserimento Utente solo se check uguale a false
            try {

                //Connessione al db
                Connection con = DBUtility.getDBConnection();
                PreparedStatement stmt = con
                        .prepareStatement("insert into User (nome,cognome,email,password, point,login_type) values(?,?,?,?,3,'app')");

                stmt.setString(1, r.getNome());
                stmt.setString(2, r.getCognome());
                stmt.setString(3, r.getEmail());
                stmt.setString(4, r.getPassword());

                status = stmt.executeUpdate(); // execute query

                stmt.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return status;
    }
}
