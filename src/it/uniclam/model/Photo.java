package it.uniclam.model;

/**
 * Created by GiovanniTrovini on 11/05/17.
 */
public class Photo {



    private int idPhoto;
    private String title;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

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

    private String nome;
    private String cognome;

    public Photo(int idPhoto, String title, String status, String nome, String cognome, String monument) {
        this.idPhoto = idPhoto;
        this.title = title;
        this.status = status;
        this.nome = nome;
        this.cognome = cognome;
        this.monument = monument;
    }

    public Photo(int idPhoto, String title, String monument, String nome, String cognome) {
        this.idPhoto = idPhoto;
        this.title = title;
        this.monument = monument;
        this.nome=nome;
        this.cognome=cognome;
    }

    public Photo(){}

    public String getMonument() {
        return monument;

    }

    public void setMonument(String monument) {
        this.monument = monument;
    }

    private String monument;


    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
