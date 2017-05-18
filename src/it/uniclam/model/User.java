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
    private String login_type;

    public User(String idsession) {
        this.idsession = idsession;
    }

    public String getIdsession() {
        return idsession;
    }

    public void setIdsession(String idsession) {
        this.idsession = idsession;
    }

    private String idsession;

    //Costruttore per il backend
    public User(int iduser, String nome, String cognome, String email, int point, String login_type) {
        this.iduser = iduser;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
         this.point = point;
        this.login_type = login_type;
    }

    public String getLogin_type() {

        return login_type;
    }

    public void setLogin_type(String login_type) {
        this.login_type = login_type;
    }

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