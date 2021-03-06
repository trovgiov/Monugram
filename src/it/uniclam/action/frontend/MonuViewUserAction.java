package it.uniclam.action.frontend;

import it.uniclam.db.DBUtility;
import it.uniclam.model.Photo;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Consente la visualizzazione delle foto relative all'utente che si è loggato
 */
    public class MonuViewUserAction {
        User u;
        private int idusr;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        private String status;
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

        private String nome;
        private String cognome;

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

        public String execute(){
            try{



                 u = Singleton.getMyUser();
                idusr = u.getIdUser();
                Connection con = DBUtility.getDBConnection();
                String sql;

                System.out.println("Status : "+getStatus());
                sql = "SELECT p.idPhoto,p.tag,p.Monument_idMonument,m.Monumento FROM Photo p, Monument m \n"+
                        "WHERE p.User_idUser='"+idusr+"' AND p.Monument_idMonument=m.idMonument  and p.status='"+getStatus()+"' ORDER BY today DESC";

                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);


                while (rs.next()) {

                    //Monument m=new Monument(rs.getString("monumento"));
                    //idmon=rs.getInt("idMonument");

                    Photo p = new Photo(rs.getInt("p.idPhoto"), rs.getString("p.tag"),rs.getString("m.Monumento"),u.getNome(),u.getCognome());

                   nome=u.getNome();
                   cognome=u.getCognome();
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

