package it.uniclam.action;


import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestAction extends ActionSupport{

    private ArrayList<User> lista = new ArrayList<User>();

    public ArrayList<User> getLista() {
        return lista;
    }

    public void setLista(ArrayList<User> lista) {
        this.lista = lista;
    }

    public String execute () throws SQLException {


        java.sql.Statement s = DBUtility.getStatement();


        // Query di select informazioni
        String sql = "select*from User";

        try {

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                User u = new User(rs.getInt("iduser"),rs.getString("name"),rs.getString("surname"));


                lista.add(u);


            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }





        return "SUCCESS";


    }


}
