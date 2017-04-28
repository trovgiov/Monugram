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

    /* CONTROLLO SE L'UTENTE INSERISCE CORRETTAMENTE L'INDIRIZZO EMAIL:
        -> Restituisce TRUE se l'email è corretta
                       FALSE altrimenti
     */
    public static boolean isValidEmail(String email) {
        boolean stricterFilter = true;
        String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
        String emailRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    /* CONTROLLO SE L'UTENTE INSERISCE LA PASSWORD:
        -> Restituisce TRUE se c'è almeno un carattere
                       FALSE altrimenti
     */
    public static boolean passCheck(String password)
    {
        boolean isPasswordOk = false;
        if (password.length()==0)
            isPasswordOk=false;
        else
            isPasswordOk=true;
        return isPasswordOk;
    }

    public static int save(RegisterAction r)
    {

        int status = 0;
        boolean check = checkUser(r);
        //System.out.println(".............."+check);

        boolean checkemail=isValidEmail(r.getEmail());
        //System.out.println("STATUS EMAIL "+checkemail);

        boolean checkPassword=passCheck(r.getPassword());
        //System.out.println("STATUS PASSWORD "+checkPassword);

        /* Controllo PRE-QUERY:
            -> Controlla se l'utente è già presente nel DB, se l'email è corretta e se c'è la m_password
         */



        // Status = 0 Falso   // utente non salvato
        // Status = 1 Vero
        // Status = 2 Email o Password errata

        if(check == false && checkemail==true && checkPassword==true)
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
        else {

            status =2;
        }
        System.out.println("Status "+status);
        return status;
    }
}
