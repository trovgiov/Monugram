package it.uniclam.db;

import it.uniclam.action.frontend.RegisterAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Accesso al db per la registrazione utente
 */
public class RegisterDAO {


    /**
     * Controlla se l'utente è presente nel db.
     * Restituisce true se è già registrato, false se è un nuovo utente
     * @param r Register Action
     * @return boolean
     */
    public static boolean checkUser(RegisterAction r)
    {

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

    /**
     * Controlla se l'utente ha inserito correttamente la mail.
     * Restituisce true se l'inserimento è corretto, false altrimenti.
     * @param email
     * @return
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

    /**
     * Controlla se l'utente ha inserito una password di almeno un carattere
     * Restituisce true se corretto, false altrimenti
     * @param password  Stringa inserita nel form
     * @return
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


    /**
     * Salva l'utente nel db.
     * Restituisce un intero che indica il corretto/errato inserimento.
     * @param r RegisterAction
     * @return int status
     * status = 0 Falso  utente non salvato
    // status = 1 Vero
    // status = 2 Email o Password errata
     */
    public static int save(RegisterAction r)
    {

        int status = 0;
        boolean check = checkUser(r);

        boolean checkemail=isValidEmail(r.getEmail());

        boolean checkPassword=passCheck(r.getPassword1());


        // Inserimento Utente solo se check uguale a false

        if(check == false)
        {
             try {

                //Connessione al db
                Connection con = DBUtility.getDBConnection();
                PreparedStatement stmt = con
                        .prepareStatement("insert into User (nome,cognome,email,password, point,login_type) values(?,?,?,?,3,'app')");

                stmt.setString(1, r.getNome());
                stmt.setString(2, r.getCognome());
                stmt.setString(3, r.getEmail());
                stmt.setString(4, r.getPassword1());

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
