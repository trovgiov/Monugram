package it.uniclam.action.backend.Crud;

import it.uniclam.db.DBUtility;
import it.uniclam.model.Monument;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Addolorata on 25/05/2017.
 */
public class CrudDao_Monument {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CrudDao_Monument() {
        dbConnection = DBUtility.getDBConnection();
    }


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

    public void updateMonument(Monument monument) {
        String updateQuery = "UPDATE Monument SET idMonument = ?, " +
                        "monument = ?, progress = ? WHERE idMonument = ?";
        try {
                pStmt = dbConnection.prepareStatement(updateQuery);
                pStmt.setInt(1, monument.getIdMonument());
                pStmt.setString(2, monument.getMonument());
                pStmt.setInt(4, monument.getProgress());
                pStmt.executeUpdate();

        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
    }

    public void deleteMonument(int id_monument) {
        String deleteQuery = "DELETE FROM Monument WHERE idMonument = ?";
        try {
                pStmt = dbConnection.prepareStatement(deleteQuery);
                pStmt.setInt(1, id_monument);
                pStmt.executeUpdate();
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
    }
}
