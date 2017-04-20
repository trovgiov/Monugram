package it.uniclam.action;

import it.uniclam.db.RegisterDAO;

/**
 * Created by GiovanniTrovini on 20/04/17.
 */

public class RegisterAction {
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private int point;

    public RegisterAction() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    //setters and getters
    public String execute(){
        int i= RegisterDAO.save(this);
        if(i>0){
            return "success";
        }
        return "error";
    }
}