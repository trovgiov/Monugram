package it.uniclam.action;

/**
 * Created by GiovanniTrovini on 21/04/17.
 */


import it.uniclam.db.DBUtility;
import it.uniclam.db.LoginDAO;
import it.uniclam.model.User;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;


public  class Login implements SessionAware {
    private String email,password;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //private String photo;
    SessionMap sessionmap;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
//  private ArrayList<User> lista = new ArrayList<Utente>();


    User u;



    public String execute(){

        boolean check = LoginDAO.validate(email, password);
         if(LoginDAO.validate(email, password)){



            try{

                Connection con = DBUtility.getDBConnection();

                String sql2;

                sql2 = "SELECT idUser,nome,cognome,email,password,point from User where email='"+email+"'";

                java.sql.Statement stmt2 = con.createStatement();

                ResultSet rs2 = stmt2.executeQuery(sql2);

                while (rs2.next()) {

                    u=new User(rs2.getInt("idUser"),rs2.getString("nome"),rs2.getString("cognome"),email,password,rs2.getInt("point"));

                }
                nome=u.getNome();
                System.out.println("nome " +u.getNome());
                // chiusura rs2 e stmt2
                rs2.close();
                stmt2.close();
                // chiusura rs e stmt
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }





            return "success";
        }
        else{
            return "error";
        }
    }




    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }




    public SessionMap getSessionmap() {
        return sessionmap;
    }


    public void setSessionmap(SessionMap sessionmap) {
        this.sessionmap = sessionmap;
    }

    @Override
    public void setSession(Map<String, Object> map) {

    }
}