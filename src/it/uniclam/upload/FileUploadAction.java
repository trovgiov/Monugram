package it.uniclam.upload;

/**
 * Created by GiovanniTrovini on 29/04/17.
 */

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Monument;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class FileUploadAction extends ActionSupport implements
        ServletRequestAware {




    private File userImage;
    private String userImageContentType;
    private String userImageFileName;
    private HttpServletRequest servletRequest;
    private String monument;

    // Variabili User


    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }


    public static String findUserId(String u_nome)
    {
        String uId = "null";
        Statement st = null;
        try{

            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            String query = "select idUser from User where nome='"+u_nome+"';";

            ResultSet rs=st.executeQuery(query);

            if (rs.next())
            {
                uId = rs.getString("idUser");
            }
        }catch(Exception e){e.printStackTrace();}

        return uId;
    }

    public static String findMonId(String n_monumento)
    {
        String mId = "null";
        Statement st = null;
        try{

            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            String query = "select idMonument from Monument where monumento='"+n_monumento+"';";

            ResultSet rs=st.executeQuery(query);

            if (rs.next())
            {
                mId = rs.getString("idMonument");
            }
        }catch(Exception e){e.printStackTrace();}

        return mId;
    }

    public static void insertDb(String id_user, String id_monument)
    {
        String mId = "null";
        Statement st = null;
        try{

            Connection con2 = DBUtility.getDBConnection();
            st=con2.createStatement();
            String query = "insert idMonument from Monument where moumento='"+id_monument+"';";

            ResultSet rs=st.executeQuery(query);

            if (rs.next())
            {
                mId = rs.getString("idMonument");
            }
        }catch(Exception e){e.printStackTrace();}
    }


    public String execute() {
        try {

            String userId;
            String monumId;
            User u = Singleton.getMyUser();
            Monument m= Singleton.getMymonument();

            //directory che contiene le foto
            // Creare cartelle per ogni monumento -> FATTO


            String filePath = servletRequest.getSession().getServletContext().getRealPath("/"+m.getMonument());


             System.out.println("Server path:" + filePath);


             // Creo il file con il nome image.jpg per le foto da smartphone

            // ATTENZIONE : Bug da FIXARE

            monumId = findMonId(m.getMonument());

            userImageFileName = monumId +"_" + u.getNome()+u.getCognome()+".jpg";
            File fileToCreate = new File(filePath, this.getUserImageFileName());//userImageFileName);
            String title= this.getUserImageFileName();

            // Qui ottengo il nome file con l'estensione
            // Si dovrebbe dividere in Nome_Cognome_Monumento.EXTENSION

            userId = findUserId(u.getNome());

            System.out.println("Nome File : "+title);
            System.out.println("\nFoto caricata da UserId: "+userId);
            System.out.println("\nMonumento Id: "+monumId);

            //insertDb(userId,monumId);

            FileUtils.copyFile(userImage, fileToCreate);
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

}