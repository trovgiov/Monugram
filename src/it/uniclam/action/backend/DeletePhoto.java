package it.uniclam.action.backend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.DBUtility;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Implementazione query per la cancellazione delle foto sia nel sistema che nel db
 */
public class DeletePhoto extends ActionSupport implements ServletRequestAware {
    private Connection dbConnection;
    private PreparedStatement pStmt;
    private int idPhoto;

    private HttpServletRequest servletRequest;


    private String filepath;

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }


    public String execute() throws SQLException {




        User u = Singleton.getMyUser();
        System.out.println("Username " + u.getUsername());

      boolean photo_deleted;





        System.out.println("Id photo cancellata " + getIdPhoto());


        // se vero , allora devo cancellarla nel server
        // /monumenti/nome_monumento/nomefile



            try {
                Connection con = DBUtility.getDBConnection();


                String query = "select m.monumento, p.tag from Monument m , Photo p where p.Monument_idMonument=m.idMonument and p.idPhoto ='" + getIdPhoto() + "'";

                java.sql.Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(query);

                System.out.println("Sonodentro e id photo è  " + getIdPhoto());


                String folder = null;
                String filename = null;

                while (rs.next()) {
                    System.out.println("Sonodentro 2");

                    folder = rs.getString("m.monumento");
                    filename = rs.getString("p.tag");


                }
                setFilepath(servletRequest.getSession().getServletContext().getRealPath("/Monumenti/" + folder + "/" + filename));

                System.out.println("PATH  " + getFilepath());

                System.out.println("FOLDER  " + folder);
                System.out.println("\nFILENAME  " + filename);


                File file = new File(getFilepath());

                boolean isdeleted = file.delete();


                // Rafforzare le condizioni !!!

                if (isdeleted==true) {
                    System.out.println(file.getName() + " is deleted!");

                    // Cancello la foto dal db

                    photo_deleted= deletePhoto(getIdPhoto());
                    System.out.println("Foto cancellta nel db"+photo_deleted);



                } else {
                    System.out.println("Delete operation is failed.");
                }





                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }


            return "success";

    }


    boolean deletePhoto(int idPhoto) throws SQLException {

        boolean deleted = false;

        dbConnection = DBUtility.getDBConnection();


        String deleteQuery = "DELETE FROM Photo WHERE idPhoto= ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setInt(1, idPhoto);

            pStmt.executeUpdate();

            deleted = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        pStmt.close();


        return deleted;
    }


    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }


}