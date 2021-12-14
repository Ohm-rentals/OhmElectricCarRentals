package server.DataAccess;


import java.sql.*;

public class DataConnection {

    static final String DB_URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/";
    static final String USER = "dtiqzmpo";
    static final String PASSWORD = "DD9MFQuiTIB_7ZDsqk17ngu9dAh-Sefh";
    static final String SCHEMA = "ohm";

    private static DataConnection instance = new DataConnection();

    public synchronized static DataConnection getInstance()
    {
        return instance;
    }

    public synchronized Connection getConnection()
    {
        try
        {
            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection(DB_URL,USER,PASSWORD);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("DATABASE CONNECTION FAILED!");
        }
    }


/*
     public ResultSet getFromDatabase(String query) throws SQLException {
        Connection connection = DataConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet;
    }

     public PreparedStatement executeQuery(String query) throws SQLException {
        Connection connection = DataConnection.getInstance().getConnection();
        return connection.prepareStatement(query);
    }

 */
}
