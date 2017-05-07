package it.uniclam.action;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

/**
 * Created by GiovanniTrovini on 07/05/17.
 */
public class HomeAction extends ActionSupport {

    private int iduser;
    private String nome;
    private String cognome;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public String execute (){


        User u = Singleton.getMyUser();

        iduser=u.getIduser();
        nome=u.getNome();
        cognome=u.getCognome();






        return "success";
    }

}
