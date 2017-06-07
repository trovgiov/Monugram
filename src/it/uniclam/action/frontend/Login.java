package it.uniclam.action.frontend;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

/**
 * Gestisce il login per gli utenti registrati con l'app.
 * Il login viene gestito con l'uso degli interceptor, per avere un maggiore controllo sulla sessione di accesso.
 */
public class Login extends ActionSupport implements SessionAware {

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
     * Effettua il logout rimuovendo la sessione
     * @return
     */
    public String logOut() {
        session.remove("loginId");
        addActionMessage("You Have Been Successfully Logged Out");
        return SUCCESS;
    }

    // ---------------------------- Login register user


    /**
     * Controlla se email e password sono contenuti nel db. Se sono presenti, viene creata una sessione e viene allocato
     * l'utente, tramite l'uso del costrutto singleton
     * @return
     */
    public String loginRegisterUser() {

        try{

            Connection con = DBUtility.getDBConnection();

            PreparedStatement ps=(PreparedStatement) con.prepareStatement(
                    "select * from User where email=? and password=?");
            ps.setString(1,userName);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();


            if(rs.next()){
                session.put("loginId", userName);

                try{

                    Connection con1 = DBUtility.getDBConnection();

                    String sql2;

                    sql2 = "SELECT idUser,nome,cognome,email,password,point from User where email='"+userName+"'";


                    java.sql.Statement stmt2 = con.createStatement();

                    ResultSet rs2 = stmt2.executeQuery(sql2);

                    while (rs2.next()) {

                        u=new User(rs2.getInt("idUser"),rs2.getString("nome"),rs2.getString("cognome"),userName,password,rs2.getInt("point"));


                    }

                    nome=u.getNome();
                    cognome=u.getCognome();
                    email=u.getEmail();


                    // Alloco l'utente
                    Singleton.setMyUser(u);




                    // chiusura rs2 e stmt2
                    rs2.close();
                    stmt2.close();
                    // chiusura rs e stmt
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }





                return SUCCESS;
            } else {
                addActionError("Please Enter Valid emailId or Password");
                return LOGIN;
            }







            //System.out.println("Email "+getUser_email());
        }catch(Exception e){e.printStackTrace();
        }
        return LOGIN;
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
