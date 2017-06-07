package it.uniclam.action.frontend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Gestisce il caso in cui, per motivi di privacy al momento della registrazione nell'app,
 * facebook non restituisce la corretta email ma la stringa "unnamed".
 * Consente di inserire una mail valida e successivamente inserirla  nel database.
 * Questo processo verrà effettuato solo quando l'utente accederà per la prima volta.
 * Quando l'utente, già registrato nel db dell'app, effettua il login con facebook e la mail ricevuta è unnamed, la stringa
 * "unnamed" viene sostituita con la mail presente nel db e viene creata la session.
 *
 */
public class RegisterMail extends ActionSupport implements SessionAware{

    private Map<String, Object> session;

    private String email;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    private String cognome;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;


    User u;

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String loginRegisterUser() {

        try {


            Connection con = DBUtility.getDBConnection();

            /*
            String sql1;

            String login_type;
            login_type = "facebook";
            sql1 = "SELECT nome,cognome,email from User where nome='" + nome + "'and cognome='" + cognome + "'and email='" + email + "'and login_type='" + login_type + "'";

            java.sql.Statement stmt2 = con.createStatement();

            ResultSet rs2 = stmt2.executeQuery(sql1);

            //controllo se l'utente esiste
            // se check = false -> utente non esiste
            //se check = true -> utente esiste

            boolean check = rs2.next();

            System.out.println("Check inside : "+check);

            */
            int status = 0;


                 System.out.println("Utente Non esistente  ");

                PreparedStatement stmt = con
                        .prepareStatement("insert into User (nome,cognome,email,password, point,login_type) values(?,?,?,'encrypted',3,'facebook')");

                stmt.setString(1, nome);
                stmt.setString(2, cognome);
                stmt.setString(3, email);


                status = stmt.executeUpdate(); // execute query


            System.out.println("");
                // devo inserirlo






            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Acquisisco l'utente e creo il bean
        try {

            Connection con2 = DBUtility.getDBConnection();

            String sql2;

            System.out.println("email register : "+email );
            sql2 = "SELECT * from User where email='" + email + "'";

            java.sql.Statement stmt2 = con2.createStatement();

            ResultSet rs2 = stmt2.executeQuery(sql2);

            while (rs2.next()) {

                 u = new User(rs2.getInt("idUser"), rs2.getString("nome"), rs2.getString("cognome"), email, "encrypted", rs2.getInt("point"));


                System.out.println("Utente Loggato: Nome " + u.getNome() + "Cognome " + u.getCognome() + "Email: " + getEmail());
            }




            stmt2.close();
            con2.close();

            System.out.println("NEW MAIL "+email);
            session.put("loginId", email);

            Singleton.setMyUser(u);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SUCCESS;

    }

}



