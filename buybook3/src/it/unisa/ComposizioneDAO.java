    package it.unisa;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import javax.naming.Context;
	import javax.naming.InitialContext;
	import javax.naming.NamingException;
	import javax.sql.DataSource;

	public class ComposizioneDAO {
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
		
		//Cerca nel DB la composizione 
		public static synchronized ListaComposizioni doRetrieveByKey(int codice) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			ListaComposizioni lista=new ListaComposizioni();
			

			String selectSQL = "SELECT * FROM " + "composizione" + " WHERE id_ordine = ?";

			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1, codice);

				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					ComposizioneBean composizione= new ComposizioneBean();
					composizione.setCodice(rs.getString("codd"));   
					composizione.setId_ordine(rs.getInt("id_ordine"));   
					composizione.setQuantità(rs.getInt("quantita"));
					
					lista.AggiungiComposizione(composizione);
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

