package it.uniclam.action.backend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.PhotoView;
import it.uniclam.model.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Gestisce la visualizzazione foto nel backend
 */

    public class PhotoManageAction extends ActionSupport {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    private int idPhoto;

    public String getStatoFoto() {
        return statoFoto;
    }

    public void setStatoFoto(String statoFoto) {
        this.statoFoto = statoFoto;
    }

    private String statoFoto;

    public String getStatPh() {
        return statPh;
    }

    public void setStatPh(String statPh) {
        this.statPh = statPh;
    }

    private String statPh;

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    private String photoname;

    public String getMonumento() {
        return monumento;
    }

    public void setMonumento(String monumento) {
        this.monumento = monumento;
    }

    private String monumento;

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }


    private int idreceived;

    public String getMonu() {
        return monu;
    }

    public void setMonu(String monu) {
        this.monu = monu;
    }

    private String monu;

    public int getIdreceived() {
        return idreceived;
    }

    public void setIdreceived(int idreceived) {
        this.idreceived = idreceived;
    }

    public String execute ()
    {
        idreceived = getIdPhoto();
        monu = getMonumento();
        photoname = photoName(idreceived);
        statPh = getStatus(idreceived);

        String email_user = email_user(idreceived);

        PhotoView p = new PhotoView(email_user,monu);
        Singleton.setMyphoto(p);

        if(statPh.equalsIgnoreCase("checked"))
            statoFoto = "Controllata";
        else
            statoFoto = "Non Controllata";





        System.out.println("Id photo cliccata "+idreceived);
        System.out.println("Nome foto cliccata: "+photoname+" - Stato: "+statoFoto);
        System.out.println("Monumento: "+monu);




        return "success";
    }

    public String photoName(int idph)
    {
        String ph_name=null;

        java.sql.Statement st = null;
        String statQuery = "SELECT tag FROM Photo WHERE idPhoto='"+idph+"'";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(statQuery);
            if (rs1.next()) {
                ph_name = rs1.getString("tag");
            }
            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return ph_name;
    }

    public String getStatus(int idph)
    {
        String stat=null;
        java.sql.Statement st = null;
        String statQuery = "SELECT status FROM Photo WHERE idPhoto='"+idph+"'";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(statQuery);
            if (rs1.next()) {
                stat = rs1.getString("status");
            }
            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return stat;
    }


    public String email_user (int idPhoto){

        String email = null;
        String stat=null;
        java.sql.Statement st = null;

        //String statQuery = "SELECT status FROM Photo WHERE idPhoto='"+idphot+"'";

        String query = "SELECT u.email \n" +
                "from Photo p, User u\n" +
                "WHERE p.User_idUser= u.idUser\n" +
                "and p.idPhoto='"+idPhoto+"'";
        try
        {
            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            ResultSet rs1 = st.executeQuery(query);
            if (rs1.next()) {
                email = rs1.getString("u.email");
            }
            rs1.close();
            st.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return email;
    }



    }


