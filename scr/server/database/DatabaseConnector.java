package server.database;

import java.sql.*;

public class DatabaseConnector
{
  static final String DB_URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/dtiqzmpo?currentSchema=OhmCarRental";
  static final String USER = "dtiqzmpo";
  static final String PASSWORD = "DD9MFQuiTIB_7ZDsqk17ngu9dAh-Sefh";

  private static DatabaseConnector instance = new DatabaseConnector();

  public synchronized static DatabaseConnector getInstance()
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
}
