package it.unisa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.*;
@WebServlet("/Register")

/**
 * Servlet implementation class LoginServlet
 */
public class RegisterServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    

     UserBean user = new UserBean();
     user.setnomeutente(request.getParameter("nickname"));
     user.setPassword(request.getParameter("password"));
     user.setEmail(request.getParameter("Email"));
     user.setCf(request.getParameter("CF"));
     user.setTel(request.getParameter("Telefono"));    
     user.setcognome(request.getParameter("Cognome"));
     user.setnome(request.getParameter("Nome"));
     user.setData(request.getParameter("datadinascita"));
     user.setCap(request.getParameter("CAP"));
     user.setVia(request.getParameter("VIA"));
     user.setCivico(request.getParameter("NCivico"));
     user.setPro(request.getParameter("Provincia"));
     user.setCart(request.getParameter("NCarta"));
     user.setScad(request.getParameter("datascadenza"));
     user.setCvv(request.getParameter("CVV"));   
     user.setIntestatario(request.getParameter("intestatario"));
     System.out.println("QUI 1");
     UserDAO.doSave(user);
	   		    
     if (user.isValid())
     {
    	 System.out.println("dfsfd");
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",user); 
          response.sendRedirect("LoginPage.jsp"); //logged-in page      		
     }
	        
     else 
    	 
          response.sendRedirect("ProductV.jsp"); //error page 
     
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}