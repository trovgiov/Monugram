package it.uniclam.model;

/**
 * Created by GiovanniTrovini on 11/05/17.
 */
public class Photo {



    private int id_photo;
    private String title;

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

    public Photo(int id_photo, String title, String monument,String nome,String cognome) {
        this.id_photo = id_photo;
        this.title = title;
        this.monument = monument;
        this.nome=nome;
        this.cognome=cognome;
    }

    public String getMonument() {
        return monument;

    }

    public void setMonument(String monument) {
        this.monument = monument;
    }

    private String monument;


    public int getId_photo() {
        return id_photo;
    }

    public void setId_photo(int id_photo) {
        this.id_photo = id_photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
