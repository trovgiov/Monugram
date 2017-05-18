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
 * Created by GiovanniTrovini on 22/04/17.
 */
public class FacebookLogin extends ActionSupport {

User u;

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

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



        //Se l'email è undefined allora :

        System.out.println(email);

        if (email.equals("undefined")){


            email="undefined";

            try {

                Connection con3 = DBUtility.getDBConnection();

                String sql3;

                sql3 = "SELECT idUser,nome,cognome,email,password,point from User where nome='" + nome + "' and cognome= '" + cognome + "'";

                java.sql.Statement stmt3 = con3.createStatement();

                ResultSet rs3 = stmt3.executeQuery(sql3);

                Boolean check = false;

                check=rs3.next();

                System.out.println("CHECK " + check);


                //controllo se l'utente esiste

                //se check = true -> utente esiste, creo il bean , login ok
                // se check = false -> utente non esiste. Deve inserire la mail valida. Reindirizzo a no_email

                if(check){



                    email = rs3.getString("email");


                     u = new User(rs3.getInt("idUser"), rs3.getString("nome"), rs3.getString("cognome"), email, "encrypted", rs3.getInt("point"));


                     Singleton.setMyUser(u);








                    return "success";
                }


                else if(!check){

                    return "no_mail";

                }




            } catch (SQLException e) {
                e.printStackTrace();
            }




         }

         // SE EMAIL NON UNDEFINED
        else {
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


            // Acquisisco l'utente e creo il bean   ???

            try {

                Connection con2 = DBUtility.getDBConnection();

                String sql2;

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



                Singleton.setMyUser(u);


                stmt2.close();
                con2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return "success";

    }

}