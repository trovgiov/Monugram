package it.uniclam.model;

import java.sql.Date;

/**
 * Bean entità PhotoView (visualizzazione foto)
 */
public class PhotoView {

    public PhotoView() {
    }

    private int idPhoto;
    private String titolo;

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getMonumento() {
        return monumento;
    }

    public void setMonumento(String monumento) {
        this.monumento = monumento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    private String nome;
    private String cognome;

    private Date today;

    private String monumento;

    private String stato;

    public PhotoView(String email,String monumento) {
        this.email = email;
        this.monumento=monumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}
