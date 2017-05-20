package it.uniclam.action.frontend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.model.Monument;
import it.uniclam.model.Session;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;


/**
 * Created by GiovanniTrovini on 29/04/17.
 */
public class UploadAction extends ActionSupport {


 User u ;
 Monument m;

    private String name;

    public Monument getM() {
        return m;
    }

    public void setM(Monument m) {
        this.m = m;
    }

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


private String monument;

    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }


    public String execute (){

        User u = Singleton.getMyUser();
        Monument m = Singleton.getMymonument();

        Session s = Singleton.getMysession();
        System.out.println("Session id "+s.getId());

        name=u.getNome();
        monument=m.getMonument();

        addActionMessage("Well done! Your image was successfully uploaded!");

        System.out.println("foto di user_id"+u.getNome());
        System.out.println("Monumento "+m.getMonument());

        return "SUCCESS";
    }
}