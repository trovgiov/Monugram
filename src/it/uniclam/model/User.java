package it.uniclam.model;

/**
 * Created by GiovanniTrovini on 18/04/17.
 */
public class User {

    private int iduser;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private int point;

    public User() {
    }

    public User(int iduser, String nome, String cognome, String email, String password, int point) {
        this.iduser = iduser;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;

        this.point = point;
    }

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
}