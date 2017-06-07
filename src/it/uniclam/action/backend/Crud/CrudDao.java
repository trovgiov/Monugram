package it.uniclam.action.backend.Crud;

import it.uniclam.db.DBUtility;
import it.uniclam.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Lato Backend :
 * Implementazione query per la creazione di una lista di utenti, la modifica e la cancellazione
 */
public class CrudDao {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CrudDao() {
        dbConnection = DBUtility.getDBConnection();
    }


    /**
     * Lato Backend
     * inserisce nella lista utenti, tutti gli utenti presenti nel db
     * @return
     */
    public List<User> getAllPeople() {
        List<User> users = new ArrayList<User>();

        String query = "SELECT * FROM User order by idUser DESC";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                User u = new User();


                u.setIdUser((rs.getInt("idUser")));
                u.setNome((rs.getString("nome")));
                u.setCognome((rs.getString("cognome")));
                u.setEmail((rs.getString("email")));
                u.setPoint(rs.getInt("point"));
                u.setLogin_type(rs.getString("login_type"));


                users.add(u);


            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }


    /**
     * Aggiorna info dell'utente
     * @param u  User u : utente su cui effettuare la modifica
     */
    public void updateUser(User u) {
        String updateQuery = "UPDATE User SET email = ? , point = ? WHERE idUser = ?";
        try {
            pStmt = dbConnection.prepareStatement(updateQuery);


            pStmt.setString(1, u.getEmail());
            pStmt.setInt(2, u.getPoint());
            pStmt.setInt(3, u.getIdUser());


            pStmt.executeUpdate();
            System.out.println("Crud Email"+u.getEmail());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Elimina l'utente a partire dall'user id
     * @param userId
     */
    public void deleteStudent(int userId) {
        String deleteQuery = "DELETE FROM User WHERE idUser = ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setInt(1, userId);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }





}