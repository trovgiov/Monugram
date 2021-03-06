package it.uniclam.db;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Connessione DB con JDBC driver
 *
 */
public class DBUtility {

    public static final String DRIVERNAME = "com.mysql.jdbc.Driver";
   // public static final String USER = "sql11171626";
    //public static final String PASSWORD = "ipSx2liyxJ";
    //public static final String URL = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11171626";

    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String URL="jdbc:mysql://localhost/hego";

    static {

        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * Effettua la connessione al database
     * @return Connection
     */
    public static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            dbConnection = (Connection) DriverManager.getConnection(URL, USER,
                    PASSWORD);

             return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    /**
     * Ottiene un PreparedStatement
     * @param sql String
     * @return PreparedStatement
     * @throws SQLException
     */
    public static PreparedStatement getPreparedStatement(String sql)
            throws SQLException {
        return getDBConnection().prepareStatement(sql);
    }

    /**
     * Ottiene uno Statement
     * @return Statement
     * @throws SQLException
     */
    public static Statement getStatement() throws SQLException {

        return (Statement) getDBConnection().createStatement();
    }

}
