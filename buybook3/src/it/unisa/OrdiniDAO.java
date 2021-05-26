package it.unisa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
	public static synchronized Collection<OrdiniBean> doRetrieveByKey(String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Date x=new Date(System.currentTimeMillis());
		java.sql.Date DataOrdine = new java.sql.Date(x.getTime());
		
		Collection<OrdiniBean> lista= new LinkedList<OrdiniBean>();
		

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
				lista.add(ordine);
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
	
	public static List<OrdiniBean> doRetrieveByKey2(String x, String d1,String d2) throws SQLException {
	       Connection connection = null;
	       PreparedStatement preparedStatement = null;
	       String selectSQL;

	      List <OrdiniBean> ordini = new LinkedList<OrdiniBean>();
	       if(x!=null) {
	           selectSQL = "SELECT * FROM ordine" + " WHERE Cfcliente= ?";
	       }
	       else {

	           selectSQL = "SELECT * FROM ordine" + " WHERE data IN (?,?)";
	       }
	       try {
	            connection = ds.getConnection();
	            preparedStatement = connection.prepareStatement(selectSQL);
	            if(x!=null) {
	                preparedStatement.setString(1, x);
	            } else {
	                preparedStatement.setString(1, d1);
	                preparedStatement.setString(2, d2);
	            }


	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                OrdiniBean bean = new OrdiniBean();
	                bean.setId_ord(rs.getInt("id_ord"));
					bean.setStato(rs.getString("Stato"));
					bean.setCosto(rs.getFloat("costo"));
					bean.setBuono(rs.getFloat("Buono"));
					bean.setCfcliente(rs.getString("Cfcliente"));
					bean.setData(rs.getDate("data"));
	                ordini.add(bean);
	            }

	        } finally {
	            try {
	                if (preparedStatement != null)
	                    preparedStatement.close();
	            } finally {
	                if (connection != null)
	                    connection.close();
	            }
	        }
	       
	        return ordini;
	    }
	
	
	
	public static synchronized Collection<OrdiniBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		 Date x=new Date(System.currentTimeMillis());
		 java.sql.Date DataOrdine = new java.sql.Date(x.getTime());
		
		 Collection<OrdiniBean> lista=new LinkedList<OrdiniBean>();
		

		String selectSQL = "SELECT * FROM " + "ordine";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				OrdiniBean ordine= new OrdiniBean();
				ordine.setId_ord(rs.getInt("id_ord"));
				ordine.setStato(rs.getString("Stato"));
				ordine.setCosto(rs.getFloat("costo"));
				ordine.setBuono(rs.getFloat("Buono"));
				ordine.setCfcliente(rs.getString("Cfcliente"));
				ordine.setData(rs.getDate("data"));
				lista.add(ordine);
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