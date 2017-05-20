package it.uniclam.upload;

/**
 * Created by GiovanniTrovini on 29/04/17.
 */

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Monument;
import it.uniclam.model.Session;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class FileUploadAction extends ActionSupport implements
        ServletRequestAware {


    private File userImage;
    private String userImageContentType;
    private String userImageFileName;
    private HttpServletRequest servletRequest;
    private String monument;

    public String getOfficial_title() {
        return official_title;
    }

    public void setOfficial_title(String official_title) {
        this.official_title = official_title;
    }

    private String official_title;


    private String filepath;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    private String cartella;

    public String getCartella() {
        return cartella;
    }

    public void setCartella(String cartella) {
        this.cartella = cartella;
    }
    // Variabili User


    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }

    public String execute() {
        try {

            Session s = Singleton.getMysession();
            System.out.println("Session id "+s.getId());
            User u = Singleton.getMyUser();
            Monument m = Singleton.getMymonument();

            //directory che contiene le foto
            // Possibile Sviluppo = Creare cartelle per ogni monumento
            // Per ora, le foto si trovano nella cartella $TOMCAT_HOME/out/uploadedPhoto

            setFilepath(servletRequest.getSession().getServletContext().getRealPath("/Monumenti/" + m.getMonument()));


            System.out.println("Server path:" + getFilepath());


            // Creo il file con il nome image.jpg per le foto da smartphone

            // ATTENZIONE : Bug da FIXARE


            // Titolo immagine di default
            String title = this.getUserImageFileName();
            // Divido la stringa ,  . è il carattere delimitatore
            String[] output = title.split("\\.");

            String titolo = output[0];
            String estensione = output[1];


            String user_info = u.getNome() + u.getCognome();


            // Array per ospitare le variabili di ritorno

            String[] final_title = new String[2];
            final_title = (CheckName(user_info, m, u));


            official_title = final_title[0] + "." + estensione;
            int contatore = Integer.parseInt(final_title[1]);


            System.out.println("**** Nuovo Titolo : " + official_title);
            System.out.println("**** Count : " + contatore);


            File fileToCreate = new File(getFilepath(), official_title);


            FileUtils.copyFile(userImage, fileToCreate);

            insert(m, official_title, contatore, u);

            System.out.println("\nFoto Inserita nel db");

            System.out.println("\nFoto caricata da : " + u.getNome());
            System.out.println("\nMonumento : " + m.getMonument());

        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());

            return INPUT;
        }
        return SUCCESS;
    }

    public File getUserImage() {
        return userImage;
    }

    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }

    public String getUserImageContentType() {
        return userImageContentType;
    }

    public void setUserImageContentType(String userImageContentType) {
        this.userImageContentType = userImageContentType;
    }

    public String getUserImageFileName() {
        return userImageFileName;
    }

    public void setUserImageFileName(String userImageFileName) {
        this.userImageFileName = userImageFileName;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;

    }


    // RESTITUISCE IL NOME FILE

    public String[] CheckName(String filename, Monument m, User u) throws SQLException {


        // Creo l'array per ospitare le variabili di ritorno
        // result[0] è il filename
        // result[1] è il count

        String[] result = new String[2];
        String out = null;

        int count = 0;


        try {

            Connection con = DBUtility.getDBConnection();

            String sql;


            sql = "SELECT tag from Photo WHERE  Monument_idMonument='" + m.getId_monument() + "' and User_idUser='" + u.getIduser() + "'";

            java.sql.Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);


            String new_filename;


            // se è GIà PRESENTE IL FILE NAME, ALLORA AGGIUNGI IL CONTATORE
            if (rs.next()) {


                new_filename = rs.getString("tag");

                System.out.println("Filename già presente " + new_filename);


                Connection con1 = DBUtility.getDBConnection();

                String sql1;

                sql1 = "SELECT max(counter) as counter from Photo WHERE Monument_idMonument='" + m.getId_monument() + "' and User_idUser='" + u.getIduser() + "'";
                java.sql.Statement stmt1 = con1.createStatement();

                ResultSet rs1 = stmt1.executeQuery(sql1);

                if (rs1.next()) {

                    count = rs1.getInt("counter");
                    System.out.println("COUNT : " + count);

                    count = count + 1;

                    System.out.println("COUNT +1: " + count);
                    out = filename + "" + count;


                    System.out.println("Filename : " + out);

                }

                rs1.close();
                stmt1.close();
            } else {

                System.out.println("Filename non presente ");

                count = 0;
                out = filename + "" + count;


            }


            // chiusura rs2 e stmt2

            rs.close();
            stmt.close();

            // chiusura rs e stmt
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // ìnsert


        result[0] = out;


        result[1] = Integer.toString(count);

        System.out.println("ritorno 0 : " + out);
        System.out.println("ritorno 1 : " + count);


        return result;
    }


    public static int findMonId(String n_monumento) {
        int mId = 0;
        java.sql.Statement st = null;
        try {

            Connection con = DBUtility.getDBConnection();
            st = con.createStatement();
            String query = "select idMonument from Monument where monumento='" + n_monumento + "';";

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                mId = rs.getInt("idMonument");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mId;
    }


    public void insert(Monument m, String final_filename, int count, User u) throws SQLException {


        java.util.Date today = new Date();
        java.sql.Date sqlDate = new java.sql.Date(today.getTime());


        int id_monument = findMonId(m.getMonument());

        Connection con = DBUtility.getDBConnection();
        PreparedStatement stmt = con.prepareStatement("insert into Photo (tag,Monument_idMonument,counter, User_idUser,today) values(?,?,?,?,?)");

        stmt.setString(1, final_filename);
        stmt.setInt(2, id_monument);
        stmt.setInt(3, count);
        stmt.setInt(4, u.getIduser());
stmt.setDate(5,sqlDate);
        int status;
        status = stmt.executeUpdate(); // execute query

        stmt.close();
        con.close();

    }


}




