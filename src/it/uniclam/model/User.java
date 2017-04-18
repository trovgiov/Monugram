package it.uniclam.model;

/**
 * Created by GiovanniTrovini on 18/04/17.
 */
public class User {

    private int iduser;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    private String name;
 private String surname;

    public User(int iduser ,String name, String surname) {
        this.iduser=iduser;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}