package it.uniclam.action;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

/**
 * Created by GiovanniTrovini on 29/04/17.
 */
public class UploadAction extends ActionSupport {


 User u ;

    private String name;
   private  String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }




    public String execute (){


        User u = Singleton.getMyUser();

        name=u.getNome();


        System.out.println("foto di "+u.getNome());


        return "SUCCESS";
    }
}
