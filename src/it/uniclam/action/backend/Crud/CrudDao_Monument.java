package it.uniclam.action.backend.Crud;

import it.uniclam.db.DBUtility;
import it.uniclam.model.Monument;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Lato Backend :
 * Implementazione query per la creazione di una lista di monumenti,  modifica e la cancellazione
 */
public class CrudDao_Monument {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CrudDao_Monument() {
        dbConnection = DBUtility.getDBConnection();
    }


    /**
     * Lista monumenti
     * @return
     */
    public List<Monument> getAllMonuments() {
        List<Monument> monuments = new ArrayList<Monument>();

        String query = "SELECT * FROM Monument ORDER BY idMonument";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
               Monument monument = new Monument();

                monument.setIdMonument(rs.getInt("idMonument"));
                monument.setMonument(rs.getString("monumento"));
                monument.setProgress(rs.getInt("progress"));
                monuments.add(monument);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return monuments;
    }

    /**
     * Inserimento nuovo monumento
     * @param monument
     */
    public void addMonument(Monument monument) {
        String insertQuery = "INSERT INTO Monument(monumento, progress) VALUES (?,?)";
        try {
                pStmt = dbConnection.prepareStatement(insertQuery);
                pStmt.setString(1, monument.getMonument());
                pStmt.setInt(2, monument.getProgress());
                pStmt.executeUpdate();
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
    }

    /**
     * Aggiornamento info monumento
     * @param monument
     */
    public void updateMonument(Monument monument) {
       String updateQuery = "UPDATE Monument SET monumento = ?, progress = ? WHERE idMonument = ?";
        try {
                pStmt = dbConnection.prepareStatement(updateQuery);
                pStmt.setString(1, monument.getMonument());
                pStmt.setInt(2, monument.getProgress());
                pStmt.setInt(3, monument.getIdMonument());
                pStmt.executeUpdate();

        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
    }


    /**
     * Cancellazione monumento dal sistema
     * @param idMonument
     */
    public void deleteMonument(int idMonument) {

        String deleteQuery = "DELETE FROM Monument WHERE idMonument = ?";
        try{
                pStmt = dbConnection.prepareStatement(deleteQuery);
                pStmt.setInt(1, idMonument);
                pStmt.executeUpdate();
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
    }
}
