package it.uniclam.action.backend;

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
public class Login_back extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
                    "select * from Admin where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();


            if(rs.next()){
                session.put("loginId", username);

                User u = new User(username);

                Singleton.setMyUser(u);




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
