package it.uniclam.action.backend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UpdateStatus extends ActionSupport {


    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }
    private Connection dbConnection;
    private PreparedStatement st;
    private int idPhoto;

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    private String stato = null;

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    private int idUtente;


    public String execute()
    {
        UpdateStatus();
        idUtente = getUtente();
        System.out.println("ID UTENTE DA PREMIARE: "+idUtente);
        updatePoint(idUtente);
        System.out.println("Punti Assegnati con Successo!\n");

        return "success";
    }

    public int getUtente()
    {
        int idusr = 0;
        int idph = getIdPhoto();

        java.sql.Statement st = null;

        String Query = "SELECT User_idUser FROM Photo WHERE idPhoto='"+idph+"'";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(Query);
            if (rs1.next()) {
                idusr = rs1.getInt("User_idUser");
            }
            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return idusr;
    }

    public void UpdateStatus()
    {
        String updateQuery = "UPDATE Photo SET status = ? WHERE idPhoto = ?";
        try {
            dbConnection= DBUtility.getDBConnection();
            st = dbConnection.prepareStatement(updateQuery);

            st.setString(1,"checked");
            st.setInt(2,getIdPhoto());

            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updatePoint(int idUsr)
    {
        String updatePnt = "UPDATE User SET point = point + ? WHERE idUser = ?";
        try {
            dbConnection= DBUtility.getDBConnection();
            st = dbConnection.prepareStatement(updatePnt);

            st.setInt(1,3);
            st.setInt(2,idUsr);

            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public String ignore(){
        String updateQuery = "UPDATE Photo SET status = ? WHERE idPhoto = ?";
        try {
            dbConnection= DBUtility.getDBConnection();
            st = dbConnection.prepareStatement(updateQuery);

            st.setString(1,"ignored");
            st.setInt(2,getIdPhoto());

            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "success";
    }

}
