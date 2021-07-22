package it.unisa;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/getPicture")

//Carica la foto copertina dal DB
public class GetPictureServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
             String id= request.getParameter("id");
             if(id!=null) {
                 byte[] bt = null;
                try {
                    bt = PhotoControl.load(id);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                 ServletOutputStream out=response.getOutputStream();
                 if(bt!=null) {
                     out.write(bt);
                     response.setContentType("image/jpeg");
                 }

                 out.close();
             }
         }

    }