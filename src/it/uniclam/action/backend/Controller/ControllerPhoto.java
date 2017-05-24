package it.uniclam.action.backend.Controller;

import com.opensymphony.xwork2.Action;
import it.uniclam.action.backend.Crud.CrudDao_Photo;
import it.uniclam.model.PhotoView;

import java.sql.Date;
import java.util.List;

/**
 * Created by GiovanniTrovini on 22/05/17.
 */
public class ControllerPhoto {
    private CrudDao_Photo dao = new CrudDao_Photo();

    private List<PhotoView> records;
    private String result;


    private int idPhoto;
    private String titolo;
    private Date today;
    private String nome;
    private String cognome;

    public CrudDao_Photo getDao() {
        return dao;
    }

    public void setDao(CrudDao_Photo dao) {
        this.dao = dao;
    }

    public List<PhotoView> getRecords() {
        return records;
    }

    public void setRecords(List<PhotoView> records) {
        this.records = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

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

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
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

    private String monumento;

    private String stato;


    public String list(){

        try{

            records=dao.getAllPhotos();
            result="OK";



        }

        catch(Exception e){

            result="ERROR";
         }



        return Action.SUCCESS;
    }
}
