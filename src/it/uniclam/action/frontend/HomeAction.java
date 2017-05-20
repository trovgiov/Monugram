package it.uniclam.action.frontend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.*;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by GiovanniTrovini on 07/05/17.
 */
public class HomeAction extends ActionSupport  implements
        ServletRequestAware {

    private int iduser;
    private String nome;
    private String cognome;



    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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


    public ArrayList<Photo> getLista_foto() {
        return lista_foto;
    }

    public void setLista_foto(ArrayList<Photo> lista_foto) {
        this.lista_foto = lista_foto;
    }

    private ArrayList<Photo> lista_foto = new ArrayList<Photo>();

    private String filepath;
    private HttpServletRequest servletRequest;

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public ArrayList<Monument> getLista_mon() {
        return lista_mon;
    }

    public void setLista_mon(ArrayList<Monument> lista_mon) {
        this.lista_mon = lista_mon;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    private ArrayList<Monument> lista_mon = new ArrayList<>();
    public String execute () throws SQLException {
        Session s = Singleton.getMysession();
         User u = Singleton.getMyUser();

        iduser=u.getIduser();
        nome=u.getNome();
        cognome=u.getCognome();

        setFilepath(servletRequest.getSession().getServletContext().getRealPath("/Monumenti/"));
        //System.out.println("filepath"+getFilepath());
        try{
        Connection con = DBUtility.getDBConnection();
        String sql;
        // sql = "select idPhoto,tag,Monument_idMonument,User_idUser from Photo order by idPhoto DESC";
            sql="select u.nome,u.cognome,p.idPhoto,p.tag,p.Monument_idMonument,p.User_idUser from Photo p, User u\n" +
                    "\n" +
                    "where p.User_idUser=u.idUser\n" +
                    "\n" +
                    "\n" +
                    " order by idPhoto DESC";
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Connection con1 = DBUtility.getDBConnection();
            String sql1;
            sql1 = "select monumento from Monument  where idMonument='"+rs.getInt("p.Monument_idMonument")+"'";
            java.sql.Statement stmt1 = con1.createStatement();
            ResultSet rs1 = stmt1.executeQuery(sql1);

            if(rs1.next()) {
                String monumento = rs1.getString("monumento");
                //System.out.println(monumento);

                String nome= rs.getString("u.nome");
                String cognome=rs.getString("u.cognome");

                Photo p = new Photo(rs.getInt("p.idPhoto"), rs.getString("p.tag"), monumento,nome,cognome);

                lista_foto.add(p);

            }
             rs1.close();
            stmt1.close();
         }
        //controllo se l'utente esiste
        // se check = false -> utente non esiste
        //se check = true -> utente esiste
         rs.close();
        stmt.close();

        // Creo la lista per la scelta dinamica di monumenti
            try{
                Connection con2 = DBUtility.getDBConnection();
                String sql2;
                sql2 = "SELECT * from Monument";
                java.sql.Statement stmt2 = con2.createStatement();

                ResultSet rs2 = stmt2.executeQuery(sql2);
                while (rs2.next()) {

                    //Monument m=new Monument(rs.getString("monumento"));
                    //idmon=rs.getInt("idMonument");

                    Monument m = new Monument(rs2.getInt("idMonument"),rs2.getString("monumento"));

                    lista_mon.add(m);
                }
                // chiusura rs2 e stmt2
                 rs2.close();
                stmt2.close();

                // chiusura rs e stmt
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            Singleton.setMyUser(u);


    } catch (SQLException e) {
        e.printStackTrace();
    }

        return "success";
    }
}