package it.unisa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO 	
{
   static Connection currentCon = null;
   static ResultSet rs = null;  
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
   private static final String TABLE_NAME= "cliente";
   private static final String TABLE_NAME2= "ordine";
   public static UserBean doRetrieve(UserBean bean) {
		
	      //preparing some objects for connection 
	      Statement stmt = null;    
	      PreparedStatement preparedStatement = null;
		
	      String username = bean.getnomeutente();    
	      String password = bean.getPassword();   
		    
	      String searchQuery =
	            "select * from cliente where nickname='"
	                     + username
	                     + "' AND password='"
	                     + password
	                     + "'";
		    
	   // "System.out.println" prints in the console; Normally used to trace the process
	   System.out.println("Your user name is " + username);          
	   System.out.println("Your password is " + password);
	   System.out.println("Query: "+searchQuery);	    
	   try 
	   {
	      //connect to DB 
		   Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/buybook");
			currentCon = ds.getConnection();
	      preparedStatement=currentCon.prepareStatement(searchQuery);
	      rs = preparedStatement.executeQuery(searchQuery);	        
	      boolean more = rs.next();
		       
	      // if user does not exist set the isValid variable to false
	      if (!more) 
	      {
	         System.out.println("Sorry, you are not a registered user! Please sign up first");
	         bean.setValid(false);
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {
	         String firstName = rs.getString("Nome");
	         String lastName = rs.getString("Cognome");
		     	
	         System.out.println("Welcome " + firstName);
	         bean.setnome(firstName);
	         bean.setCf(rs.getString("CF"));
	         bean.setcognome(lastName);
	         bean.setValid(true);
	      }
	   } 

	   catch (Exception ex) 
	   {
	      System.out.println("Log In failed: An Exception has occurred! " + ex);
	   } 
		    
	   //some exception handling
	   finally 
	   {
	      if (rs != null)	{
	         try {
	            rs.close();
	         } catch (Exception e) {}
	            rs = null;
	         }
		
	      if (stmt != null) {
	         try {
	            stmt.close();
	         } catch (Exception e) {}
	            stmt = null;
	         }
		
	      if (currentCon != null) {
	         try {
	            currentCon.close();
	         } catch (Exception e) {
	         }

	         currentCon = null;
	      }
	   }

	return bean;
		
	   }
   
   //aggiunto alex
   
  
   
//inserimento composizione ordine
   
   public synchronized static void doSave(UserBean user, Cart cart)throws SQLException {
   double totale=0;
   Date x=new Date(System.currentTimeMillis());
   java.sql.Date DataOrdine = new java.sql.Date(x.getTime());
   Connection connection = null;
   PreparedStatement preparedStatement = null;
   String sql=  "INSERT INTO " + UserDAO.TABLE_NAME2
           + " (id_ord,Stato,costo,Buono,Cfcliente,data) VALUES (?, ?, ?, ?, ?, ?)";
        String sss= "SELECT MAX(id_ord) FROM ordine";
 
  String aaa=  "INSERT INTO " + "composizione"
             + " (quantita,id_ordine,codd) VALUES (?,?, ?)";
   for(int i=0;i<cart.getProducts().size();i++) {
       totale=totale+cart.getProducts().get(i).Costototale();
       
   }
   CartProduct prod=new CartProduct(null);
   int i=0;

       try {  
    	   connection=ds.getConnection();
           preparedStatement = connection.prepareStatement(sss);
           ResultSet rs = preparedStatement.executeQuery();
           while (rs.next()) {
           i=rs.getInt(1)+1;}
           preparedStatement.close();
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setInt(1,i);
           preparedStatement.setString(2,"ordinato");
           preparedStatement.setDouble(3, totale );
           preparedStatement.setFloat(4, 0 );
           preparedStatement.setString(5,user.getCf());    
           preparedStatement.setDate(6,DataOrdine);
           preparedStatement.executeUpdate();
           preparedStatement.close();              
    	   System.out.println(cart.getProducts().size());
    	   for(int j=0; j<cart.getProducts().size();j++) {
               preparedStatement = connection.prepareStatement(aaa);
               prod=cart.getProducts().get(j);
               preparedStatement.setInt(1,prod.getDisponibilità());
               preparedStatement.setInt(2, i);
               preparedStatement.setString(3,prod.getIDProdotto());          
               preparedStatement.executeUpdate();
               preparedStatement.close();
           }       
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
   //inserisce dati dentro la tabella cliente
    public synchronized static void doSave(UserBean user1) throws SQLException {
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         String insertSQL = "INSERT INTO " + UserDAO.TABLE_NAME
                 + "(CF, Email, nickname, password, Telefono, Cognome, Nome, datadinascita, CAP, VIA, NCivico, Provincia, NCarta, datascadenza, CVV, intestatario)"
                 + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
         try {
        	 
             connection = ds.getConnection();
             preparedStatement = connection.prepareStatement(insertSQL);
             preparedStatement.setString(1, user1.getCf());
             System.out.println("CF CLIENTE: "+user1.getCf());
             preparedStatement.setString(2, user1.getEmail());
             preparedStatement.setString(3, user1.getnomeutente());
             preparedStatement.setString(4, user1.getPassword());
             preparedStatement.setString(5, user1.getTel());
             preparedStatement.setString(6, user1.getcognome());
             preparedStatement.setString(7, user1.getnome());
             preparedStatement.setString(8, user1.getData());
             preparedStatement.setString(9, user1.getCap());
             preparedStatement.setString(10, user1.getVia());
             preparedStatement.setString(11, user1.getCivico());
             preparedStatement.setString(12, user1.getPro());
             preparedStatement.setString(13, user1.getCart());
             preparedStatement.setString(14, user1.getScad());
             preparedStatement.setString(15, user1.getCvv());
             preparedStatement.setString(16, user1.getIntestatario());
                       
int m=preparedStatement.executeUpdate();       
  if(m==0) {
            	 user1.setValid(false);}
    else {
            	 user1.setValid(true);}} 
finally{
             try {
           if (preparedStatement != null)
                preparedStatement.close();
   } finally {
   if (connection != null)
       connection.close();
}}}}
       
     
                
