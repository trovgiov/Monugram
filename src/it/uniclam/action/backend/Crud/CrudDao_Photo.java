package it.uniclam.action.backend.Crud;

import it.uniclam.db.DBUtility;
import it.uniclam.model.Photo;
import it.uniclam.model.PhotoView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudDao_Photo {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CrudDao_Photo() {
        dbConnection = DBUtility.getDBConnection();
    }



    public List<PhotoView> getAllPhotos() {
        List<PhotoView> photos = new ArrayList<PhotoView>();

        String query = "select p.idPhoto,p.tag,p.today,u.nome,u.cognome,m.monumento,p.status\n" +
                "from Photo p , Monument m, User u \n" +
                "where p.User_idUser = u.idUser and p.Monument_idMonument = m.idMonument\n" +
                "and p.status='unchecked' order by p.idPhoto desc";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                PhotoView p  = new PhotoView();


                p.setIdPhoto(rs.getInt("p.idPhoto"));
                p.setTitolo(rs.getString("p.tag"));
                p.setToday(rs.getDate("p.today"));
                p.setNome(rs.getString("u.nome"));
                p.setCognome(rs.getString("u.cognome"));
                p.setMonumento(rs.getString("m.monumento"));
                p.setStato(rs.getString("p.status"));



                photos.add(p);

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return photos;
    }
}