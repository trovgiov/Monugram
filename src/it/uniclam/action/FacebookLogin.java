package it.uniclam.action;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GiovanniTrovini on 22/04/17.
 */
public class FacebookLogin extends ActionSupport {


    private String nome;
    private String cognome;
    private String email;

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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;

    }


    public String execute() {



        // Acquisisco tutte le persone che si sono collegate all'app con facebook


        try {

            Connection con = DBUtility.getDBConnection();

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
            int status = 0;

            if (check == false) {
                System.out.println("Utente Non esistente");

                PreparedStatement stmt = con
                        .prepareStatement("insert into User (nome,cognome,email,password, point,login_type) values(?,?,?,'encrypted',3,'facebook')");

                stmt.setString(1, nome);
                stmt.setString(2, cognome);
                stmt.setString(3, email);


                status = stmt.executeUpdate(); // execute query


                // devo inserirlo

            } else {
                // non devo inserirlo e creo la session

                System.out.println("Utente Esistente");

            }


            stmt2.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Acquisisco l'utente e creo il bean  // Si può evitare ???

        try {

            Connection con2 = DBUtility.getDBConnection();

            String sql2;

             sql2 = "SELECT * from User where email='" + email + "'";

            java.sql.Statement stmt2 = con2.createStatement();

            ResultSet rs2 = stmt2.executeQuery(sql2);

            while(rs2.next()){

               User u=new User(rs2.getInt("idUser"),rs2.getString("nome"),rs2.getString("cognome"),email,"encrypted",rs2.getInt("point"));


                System.out.println("Utente Loggato: Nome "+u.getNome()+"Cognome "+u.getCognome()+"Email: "+getEmail());
            }

            //controllo se l'utente esiste
            // se check = false -> utente non esiste
            //se check = true -> utente esiste




            stmt2.close();
            con2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }






        return "SUCCESS";

    }

}