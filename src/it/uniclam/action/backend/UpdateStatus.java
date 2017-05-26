package it.uniclam.action.backend;

import it.uniclam.db.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Enifix on 26/05/2017.
 */
public class UpdateStatus {
    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }
    private Connection dbConnection;
    private PreparedStatement st;
    private int idPhoto;

    public String execute()
    {
        String updateQuery = "UPDATE Photo SET status = ? WHERE idPhoto = ?";
        try {
            st = dbConnection.prepareStatement(updateQuery);

            st.setString(1,"checked");
            st.setInt(2,getIdPhoto());

            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "success";
    }
}
