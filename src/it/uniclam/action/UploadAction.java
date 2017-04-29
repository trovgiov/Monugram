package it.uniclam.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by GiovanniTrovini on 29/04/17.
 */
public class UploadAction extends ActionSupport {

    private String nome;
    private String cognome;


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



        name=getNome();
        surname=getCognome();

        System.out.println("foto di "+name);


        return "SUCCESS";
    }
}
