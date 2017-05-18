package it.uniclam.action.frontend;

import it.uniclam.db.DBUtility;
import it.uniclam.model.Photo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by GiovanniTrovini on 14/05/17.
 */
public class MonuViewAction {

    public String getMonumento() {
        return monumento;
    }

    public void setMonumento(String monumento) {
        this.monumento = monumento;
    }

    private String monumento ;

    private ArrayList<Photo> lista = new ArrayList<Photo>();

    public ArrayList<Photo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Photo> lista) {
        this.lista = lista;
    }

    public String execute(){



        try{

            Connection con = DBUtility.getDBConnection();

            String sql;

            sql = "select u.nome,u.cognome,p.idPhoto,p.tag,p.Monument_idMonument,p.User_idUser,m.monumento from Photo p, User u,Monument m\n" +
                    "where p.User_idUser=u.idUser and p.Monument_idMonument=m.idMonument\n" +
                    "and m.monumento='"+getMonumento()+"'\n" +
                    "order by idPhoto DESC";

            java.sql.Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                //Monument m=new Monument(rs.getString("monumento"));
                //idmon=rs.getInt("idMonument");


                Photo p = new Photo(rs.getInt("p.idPhoto"), rs.getString("p.tag"),getMonumento(),rs.getString("u.nome"),rs.getString("u.cognome"));


                lista.add(p);

            }



            // chiusura rs2 e stmt2
            rs.close();
            stmt.close();
            // chiusura rs e stmt
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }






        return "success";
    }
}
