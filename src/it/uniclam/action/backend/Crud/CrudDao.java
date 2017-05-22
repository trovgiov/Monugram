package it.uniclam.action.backend.Crud;

import it.uniclam.db.DBUtility;
import it.uniclam.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudDao {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CrudDao() {
        dbConnection = DBUtility.getDBConnection();
    }



    public List<User> getAllPeople() {
        List<User> users = new ArrayList<User>();

        String query = "SELECT * FROM User order by idUser DESC";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                User u = new User();


                u.setIduser((rs.getInt("idUser")));
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




    public void updateUser(User user) {
        String updateQuery = "UPDATE User SET  email = ?, point = ? WHERE idUser = ?";
        try {
            pStmt = dbConnection.prepareStatement(updateQuery);


            pStmt.setString(1, user.getEmail());
            pStmt.setInt(2, user.getPoint());
            pStmt.setInt(3, user.getIduser());


            pStmt.executeUpdate();
System.out.println("Email"+user.getEmail());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }



}