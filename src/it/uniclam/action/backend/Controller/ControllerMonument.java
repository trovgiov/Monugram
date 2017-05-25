package it.uniclam.action.backend.Controller;

import com.opensymphony.xwork2.Action;
import it.uniclam.action.backend.Crud.CrudDao_Monument;
import it.uniclam.model.Monument;

import java.io.IOException;
import java.util.List;

/**
 * Created by Addolorata on 24/05/2017.
 */
public class ControllerMonument {

    private CrudDao_Monument dao = new CrudDao_Monument();

    private List<Monument> records;
    private String result;
    private String message;
    private Monument record;

    private int id_monument;
    private String monument;
    private int progress;

    public CrudDao_Monument getDao() {
        return dao;
    }

    public void setDao(CrudDao_Monument dao) {
        this.dao = dao;
    }

    public List<Monument> getRecords() {
        return records;
    }

    public void setRecords(List<Monument> records) {
        this.records = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Monument getRecord() {
        return record;
    }

    public void setRecord(Monument record) {
        this.record = record;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String list() {
        try {
            // Fetch Data from Monuments Table
            records = dao.getAllMonuments();
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }


    public String create() throws IOException {
        record = new Monument();

        record.setId_monument(id_monument);
        record.setMonument(monument);
        record.setProgress(progress);

        try {
            // Create new record
            dao.addMonument(record);
            result = "OK";

        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }


    public String update() throws IOException {
        Monument monument = new Monument();

        monument.setMonument(getMonument());
        monument.setProgress(getProgress());

        try {
            // Update existing record
            dao.updateMonument(monument);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }


    public String delete() throws IOException {
        // Delete record
        try {
            dao.deleteMonument(id_monument);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }

}
