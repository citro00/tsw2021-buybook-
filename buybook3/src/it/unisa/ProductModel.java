package it.unisa;

import java.sql.SQLException;
import java.util.Collection;

public interface ProductModel {
	
	public ProductBean doRetrieveByKey(String code) throws SQLException;
	
	public Collection<ProductBean> doRetrieveAll(String s) throws SQLException;
	
	public void update(CartProduct s) throws SQLException;
}
