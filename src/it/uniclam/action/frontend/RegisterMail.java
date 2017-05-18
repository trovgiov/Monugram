package it.uniclam.action.frontend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GiovanniTrovini on 26/04/17.
 */
public class RegisterMail extends ActionSupport {


    private String email;

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

    public String execute() {

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

            //controllo se l'utente esiste
            // se check = false -> utente non esiste
            //se check = true -> utente esiste



            stmt2.close();
            con2.close();

            Singleton.setMyUser(u);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "SUCCESS";

    }

}



