package it.uniclam.upload;

/**
 * Created by GiovanniTrovini on 29/04/17.
 */

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.File;






public class FileUploadAction extends ActionSupport implements
        ServletRequestAware {




    private File userImage;
    private String userImageContentType;
    private String userImageFileName;
    private HttpServletRequest servletRequest;


    // Variabili User




    public String execute() {
        try {


            User u = Singleton.getMyUser();
            //directory che contiene le foto
            // Possibile Sviluppo = Creare cartelle per ogni monumento
            // Per ora, le foto si trovano nella cartella $TOMCAT_HOME/out/uploadedPhoto

            String filePath = servletRequest.getSession().getServletContext().getRealPath("/uploadPhoto");


             System.out.println("Server path:" + filePath);


             // Creo il file con il nome image.jpg per le foto da smartphone

            // ATTENZIONE : Bug da FIXARE

            File fileToCreate = new File(filePath, this.userImageFileName);
            String title= this.getUserImageFileName();

            // Qui ottengo il nome file con l'estensione
            // Si dovrebbe dividere in Nome_Cognome_Monumento.EXTENSION

            System.out.println("Nome File : "+title);
            System.out.println("\nFoto caricata da : "+u.getNome());




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