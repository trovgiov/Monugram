package it.uniclam.action.backend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Enifix on 02/06/2017.
 */
public class UserInfoMail extends ActionSupport
{
    private int idUser;
    private String Nome;

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    private int idPhoto;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    private String Cognome;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    private String userMail;

    public String execute()
    {
        idPhoto = getIdPhoto();
        idUser = idUtente(idPhoto);
        userMail = getUserMail(idUser);

        System.out.println("ID Foto >>: "+ idPhoto);
        System.out.println("Utente da contattare: "+ idUser);
        System.out.println("EMAIL: "+userMail);

        return "input";
    }

    public int idUtente(int idut)
    {
        int idUt = 0;

        java.sql.Statement st = null;
        String Query = "SELECT user_idUser FROM Photo WHERE idPhoto='"+idut+"'";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(Query);

            if (rs1.next()) {
                idUt = rs1.getInt("user_idUser");
            }
            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return idUt;
    }

    public String getUserMail(int idusr)
    {
        String mail = null;

        try
        {
            Connection con = DBUtility.getDBConnection();

            String sql;

            sql = "SELECT email FROM User WHERE idUser = '"+idusr+"'";

            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                mail = rs.getString("email");

            }
            // chiusura rs2 e stmt2
            rs.close();
            stmt.close();
            // chiusura rs e stmt

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mail;
    }
}
