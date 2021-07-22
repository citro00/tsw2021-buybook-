package it.unisa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.concurrent.Executor;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

@WebServlet("/controllo")
public class Controllo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, java.io.IOException {


}
public void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, java.io.IOException {
response.setContentType("text/html");
String email=request.getParameter("email");
PrintWriter out=response.getWriter();
System.out.println("Prova");
try {
if(UserDAO.control(email)) {
   out.print("Email già presente");
}
else {
   out.print("");
}
} catch (NamingException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
	
}
