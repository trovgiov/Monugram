package it.uniclam.action.frontend;

import it.uniclam.db.DBUtility;
import it.uniclam.model.Photo;
import it.uniclam.model.Session;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


    public class MonuViewUserAction {
        User u;
        private int idusr;

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
                Session s = Singleton.getMysession();
                u = Singleton.getMyUser();
                idusr = u.getIduser();
                Connection con = DBUtility.getDBConnection();
                String sql;
                sql = "SELECT p.idPhoto,p.tag,p.Monument_idMonument,m.Monumento FROM Photo p, Monument m \n"+
                        "WHERE p.User_idUser='"+idusr+"' AND p.Monument_idMonument=m.idMonument ORDER BY today DESC";

                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);


                while (rs.next()) {

                    //Monument m=new Monument(rs.getString("monumento"));
                    //idmon=rs.getInt("idMonument");

                    Photo p = new Photo(rs.getInt("p.idPhoto"), rs.getString("p.tag"),rs.getString("m.Monumento"),u.getNome(),u.getCognome());
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

