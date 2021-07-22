package it.unisa;

import javax.naming.Context;
import java.sql.Connection;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.io.IOException;
import java.sql.*;


public class PhotoControl {
    private static DataSource ds;
    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/buybook");

        } catch (NamingException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    public static synchronized byte[] load(String id) throws SQLException  {
  Connection connection = null;
        PreparedStatement preparedStatement = null;

        byte[] bt=null;


        String selectSQL = "SELECT photo FROM prodotto WHERE codice= ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bt=rs.getBytes("photo");
        }} finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
        return bt;
    }
}
	



