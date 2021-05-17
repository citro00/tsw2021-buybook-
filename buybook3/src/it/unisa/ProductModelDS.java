package it.unisa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductModelDS implements ProductModel {

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

	private static final String TABLE_NAME = "prodotto";

	
	public synchronized ProductBean doRetrieveByKey(String x) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ProductBean bean = new ProductBean();
		
		String selectSQL = "SELECT * FROM " + ProductModelDS.TABLE_NAME + " WHERE codice = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, x);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setCodice(rs.getString("codice"));
				bean.setName(rs.getString("nome"));
				bean.setgenere(rs.getString("genere"));
				bean.setPrice(rs.getFloat("prezzo"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setQuantità(rs.getInt("N_pezzi"));
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
		return bean;
	}
/*   DODELETE ---> NON NECESSARIO ORA
	@Override
	public synchronized boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProductModelDS.TABLE_NAME + " WHERE CODE = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
*/
	@Override
	public synchronized Collection<ProductBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<ProductBean> prodotti = new LinkedList<ProductBean>();

		String selectSQL = "SELECT * FROM " + ProductModelDS.TABLE_NAME;

		if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY " + order;
        }
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductBean bean = new ProductBean();

				bean.setCodice(rs.getString("codice"));
				bean.setName(rs.getString("nome"));
				bean.setgenere(rs.getString("genere"));
				bean.setPrice(rs.getInt("prezzo"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setQuantità(rs.getInt("N_pezzi"));
				
				prodotti.add(bean);
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
		return prodotti;
	}
	public synchronized void update(CartProduct prod)throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql= "UPDATE " + ProductModelDS.TABLE_NAME + " SET N_pezzi = N_pezzi - ? WHERE codice=?";

            try {

                connection = ds.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, prod.getDisponibilità());
                preparedStatement.setString(2, prod.getIDProdotto());
                preparedStatement.executeUpdate();
        }

            finally {
                try {
                    if (preparedStatement != null)
                        preparedStatement.close();
                } finally {
                    if (connection != null)
                        connection.close();
                }
            }

        }

		
		
	}

