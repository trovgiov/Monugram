package it.uniclam.action.frontend;

/**
 * Gestisce il login tramite credenziali di facebook. E' stato usato il tool Facebook SDK for Javascript
 */

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

public class LoginFacebook extends ActionSupport implements SessionAware {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private Map<String, Object> session;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String nome;
    private String cognome;
    private String email;

    User u;
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

    public String home() {
        return SUCCESS;
    }

    // ---------------------------- Log Out register user


    /**
     * Logout
     * @return
     */
    public String logOut() {
        session.remove("loginId");
        addActionMessage("You Have Been Successfully Logged Out");
        return SUCCESS;
    }

    // ---------------------------- Login register user

    /**
     * Crea la session con email e password provenienti da facebook.
     * Se l'email , considerata come chiave primaria, non è presente nel db, si procede alla registrazione dell'utente
     * Se l'email non è presente nelle info utente facebook, per motivi di privacy, si viene reindirizzati ad un'altra
     * pagina dove è possibile inserire una mail valida.
     * Se l'email è presente nel db, allora viene consentito l'accesso all'utente.
     *
     * @return
     */
    public String loginRegisterUser() {


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


                    session.put("loginId", email);
                    Singleton.setMyUser(u);








                    return SUCCESS;
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



                session.put("loginId", email);

                Singleton.setMyUser(u);


                stmt2.close();
                con2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return  SUCCESS;

    }









    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}

