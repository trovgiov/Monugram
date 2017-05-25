package it.uniclam.action.backend;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by GiovanniTrovini on 24/05/17.
 */
public class PhotoManageAction extends ActionSupport {


    private int idPhoto;

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }


    private int idreceived;

    public int getIdreceived() {
        return idreceived;
    }

    public void setIdreceived(int idreceived) {
        this.idreceived = idreceived;
    }

    public String execute ()
    {



        idreceived = getIdPhoto();


            System.out.println("Id photo cliccata"+idreceived);



        return "success";

    }
}
