package it.uniclam.model;

/**
 * Bean entità monumento
 */
public class Monument {
    private int idMonument;
    private String monument;
    private int progress;

    public int getProgress() {
        return progress;
    }

    public Monument() {
    }

    public Monument(int idMonument, String monument, int progress) {
        this.idMonument = idMonument;
        this.monument = monument;
        this.progress = progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

/*    public Monument() {
        this.monument = monument;
    }*/

    public int getIdMonument() {
        return idMonument;
    }

    public Monument(int idMonument, String monument) {
        this.idMonument = idMonument;
        this.monument = monument;
    }

    public void setIdMonument(int idMonument) {
        this.idMonument = idMonument;
    }

    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }
}
