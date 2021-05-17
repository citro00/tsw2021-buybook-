package it.unisa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrdiniDAO {

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
	public static synchronized Listaordini doRetrieveByKey(String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		 Date x=new Date(System.currentTimeMillis());
		   java.sql.Date DataOrdine = new java.sql.Date(x.getTime());
		Listaordini lista=new Listaordini();
		

		String selectSQL = "SELECT * FROM " + "ordine" + " WHERE Cfcliente = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				OrdiniBean ordine= new OrdiniBean();
				ordine.setId_ord(rs.getInt("id_ord"));
				ordine.setStato(rs.getString("Stato"));
				ordine.setCosto(rs.getFloat("costo"));
				ordine.setBuono(rs.getFloat("Buono"));
				ordine.setCfcliente(rs.getString("Cfcliente"));
				ordine.setData(rs.getDate("data"));
				lista.Aggiungiordine(ordine);
		}} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return lista;
	}
}