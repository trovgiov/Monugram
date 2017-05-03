package it.uniclam.model;

/**
 * Created by GiovanniTrovini on 03/05/17.
 */
public class Monument {
    private int id_monument;
    private String monument;

    public Monument(String monument) {
        this.monument = monument;
    }

    public int getId_monument() {
        return id_monument;
    }

    public void setId_monument(int id_monument) {
        this.id_monument = id_monument;
    }

    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }
}
