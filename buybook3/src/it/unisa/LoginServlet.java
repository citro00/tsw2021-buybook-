package it.unisa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import javax.servlet.annotation.*;
@WebServlet("/Login")

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
try
{	    
     UserBean user = new UserBean();
     user.setnomeutente(request.getParameter("nickname"));
     user.setPassword(request.getParameter("password"));
     System.out.println("QUI 1");
     user = UserDAO.doRetrieve(user);
	   		    
     if (user.isValid())
     {
	      HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",user); 
          response.sendRedirect("ProductV.jsp"); //logged-in page      		
     }      
     else { 
          response.sendRedirect("ProductV.jsp"); //error page 
}}	
catch (Throwable theException) 	    
  {
     System.out.println(theException); 
}}}
