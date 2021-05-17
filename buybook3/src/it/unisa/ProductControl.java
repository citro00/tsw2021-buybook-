package it.unisa;

import java.io.IOException; 
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.ProductModel;

import it.unisa.ProductModelDS;
import it.unisa.Cart;
import it.unisa.ProductBean;
import it.unisa.CartProduct;

/**
 * Servlet implementation class ProductControl
 */
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDS usa il DataSource

	static boolean isDataSource = true;
	
	static ProductModel model;
	
	static {
			model = new ProductModelDS();
	}

	public ProductControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		 
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		String action = request.getParameter("action");

		try {
			if (action != null) {
				if (action.equalsIgnoreCase("addC")) {
					String codice = (request.getParameter("codice"));
					cart.addProduct(new CartProduct(model.doRetrieveByKey(codice)));
					request.getSession().setAttribute("Cart", cart);
					request.setAttribute("Cart", cart);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");	
					dispatcher.forward(request, response);
				}  else if (action.equalsIgnoreCase("deleteC")) {
					String codice = (request.getParameter("codice"));
					cart.deleteProduct(new CartProduct(model.doRetrieveByKey(codice)));
					request.getSession().setAttribute("Cart", cart);
					request.setAttribute("Cart", cart);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("read")) {
					String id = (request.getParameter("codice"));
					request.removeAttribute("prodotto");
					request.setAttribute("prodotto", model.doRetrieveByKey(id));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					//model.doDelete(id);
				} else if (action.equalsIgnoreCase("insert")) {
					String name = request.getParameter("Nome");
					String description = request.getParameter("genere");
					int price = Integer.parseInt(request.getParameter("prezzo"));
					int quantity = Integer.parseInt(request.getParameter("N_pezzi"));
					int sconto= Integer.parseInt(request.getParameter("sconto"));

					ProductBean bean = new ProductBean();
					bean.setName(name);
					bean.setgenere(description);
					bean.setPrice(price);
					bean.setQuantità(quantity);
					bean.setSconto(sconto);
					//model.doSave(bean);
					
				}
				else if (action.equalsIgnoreCase("acquista")) {
                    Cart c=(Cart)request.getSession().getAttribute("cart");
                    UserBean user = (UserBean)request.getSession().getAttribute("currentSessionUser");
                    
                    UserDAO.doSave(user,c);
                    for(CartProduct prod:c.getProducts())
                    { model.update(prod);
                   
                    }
                    c.getProducts().removeAll(c.getProducts());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductV.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
				else if (action.equalsIgnoreCase("ordini")) {           
                    UserBean user = (UserBean)request.getSession().getAttribute("currentSessionUser");
                  if (user!= null){
                	     Listaordini lista = OrdiniDAO.doRetrieveByKey(user.getCf());
                   request.setAttribute("listaordini",lista);                       
                  
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Ordini.jsp");
                    dispatcher.forward(request, response);
                    return;}
                  
                    else {
                  	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Loginerrato.jsp");
                        dispatcher.forward(request, response);}
  				}		
				
  				else if (action.equalsIgnoreCase("dettagli")) {           
                    int cod=Integer.parseInt(request.getParameter("codice")) ;                     
                  ListaComposizioni  lista2  =ComposizioneDAO.doRetrieveByKey(cod);
                  request.setAttribute("composizioni",lista2);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/composizioni.jsp");
                    dispatcher.forward(request, response);
                    return;
				
			}	
          
		}} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
		
		String sort = request.getParameter("sort");

		request.removeAttribute("prodotti");
		try {
			request.setAttribute("prodotti", model.doRetrieveAll(sort));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductV.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
