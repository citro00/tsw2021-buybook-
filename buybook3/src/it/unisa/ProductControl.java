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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	UserBean user= (UserBean) request.getSession().getAttribute("currentSessionUser");
		 
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		String action = request.getParameter("action");
		//System.out.println(action);
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
					/*
				} else if (action.equalsIgnoreCase("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					//model.doDelete(id);
					*/
				
				} else if (action.equalsIgnoreCase("inserimento")) {
					
					String cod= request.getParameter("codice");
					String autore=request.getParameter("autore");
					int sconto= Integer.parseInt(request.getParameter("sconto"));
					String description = request.getParameter("genere");
					int price = Integer.parseInt(request.getParameter("prezzo"));
					int quantity = Integer.parseInt(request.getParameter("N_pezzi"));	
					String name = request.getParameter("nome");	
					
					ProductBean bean = new ProductBean();
					bean.setCodice(cod);
					bean.setAutore(autore);
					bean.setSconto(sconto);
					bean.setgenere(description);
					bean.setPrice(price);
					bean.setQuantità(quantity);	
			     	bean.setName(name);		
					model.doSaveins(bean);
				
			        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalogo.jsp");
	                dispatcher.forward(request, response);
	                return;
					
				}
				else if (action.equalsIgnoreCase("acquista")) {
                    Cart c=(Cart)request.getSession().getAttribute("cart");
                    user = (UserBean)request.getSession().getAttribute("currentSessionUser");
                    
                    UserDAO.doSave(user,c);
                    for(CartProduct prod:c.getProducts())
                    { ((ProductModelDS) model).update(prod);
                   
                    }
                    c.getProducts().removeAll(c.getProducts());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductV.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
				
  				else if (action.equalsIgnoreCase("dettagli")) {           
                    int cod=Integer.parseInt(request.getParameter("codice")) ;                     
                  ListaComposizioni  lista2  =ComposizioneDAO.doRetrieveByKey(cod);
                  request.setAttribute("composizioni",lista2);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/composizioni.jsp");
                    dispatcher.forward(request, response);
                    return;
				
			}	
  				else if (action.equalsIgnoreCase("VOrdini")) {
  						user= (UserBean) request.getSession().getAttribute("currentSessionUser");
  						String redirect="";
  						if(user!=null) {
  							if(user.getAdmin()==1) {
  								request.setAttribute("VOrdini", OrdiniDAO.doRetrieveAll());
  								redirect="/Ordini.jsp";
  							}
  							else {
  								request.setAttribute("VOrdini", OrdiniDAO.doRetrieveByKey(user.getCf()));
								redirect="/Ordini.jsp";
  							}
  						} else redirect="/Loginerrato.jsp";
  	                                         
  	              
  	                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
  	                    dispatcher.forward(request, response);
  	                    return;
  				}
					else if (action.equalsIgnoreCase("Catalogo")) {
						
						request.setAttribute("prodotti", model.doRetrieveAll(""));
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalogo.jsp");			
								dispatcher.forward(request, response); return;
					}
					else if (action.equalsIgnoreCase("modificaCC")) {
						String id= request.getParameter("codice");
						String aut = request.getParameter("autore");
						model.doUpdate(id,aut,"autore");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalogo.jsp");
						dispatcher.forward(request, response);
						return;
					}
					else if (action.equalsIgnoreCase("modificaSc")) {
						String id= request.getParameter("codice");
						String sconto = request.getParameter("sconto");
						model.doUpdate(id,sconto,"sconto");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalogo.jsp");
						dispatcher.forward(request, response);
						return;
					}
					else if (action.equalsIgnoreCase("modificaPrz")) {
						String id= request.getParameter("codice");
						String prz = (request.getParameter("prezzo"));
						model.doUpdate(id,prz,"prezzo");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalogo.jsp");
						dispatcher.forward(request, response);
						return;
					}
					else if (action.equalsIgnoreCase("modificaNom")) {
						String id= request.getParameter("codice");
						String nome = request.getParameter("nome");
						model.doUpdate(id,nome,"nome");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalogo.jsp");
						dispatcher.forward(request, response);
						return;
					}	
					else if (action.equalsIgnoreCase("modificaGen")) {
						String id= request.getParameter("genere");
						String gen =request.getParameter("genere");
						model.doUpdate(id,gen,"genere");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalogo.jsp");
						dispatcher.forward(request, response);
						return;
					}
					else if (action.equalsIgnoreCase("modificaPz")) {
						String id= request.getParameter("genere");
						String pz = request.getParameter("N_pezzi");
						model.doUpdate(id,pz,"N_pezzi");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalogo.jsp");
						dispatcher.forward(request, response);
						return;
					}
					else if(action.equalsIgnoreCase("ricerca")) {
						String sort = request.getParameter("CF");
						
						request.removeAttribute("VOrdini");
						request.setAttribute("VOrdini", OrdiniDAO.doRetrieveByKey2(sort, null, null));
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Ordini.jsp");
						dispatcher.forward(request, response);
						return;
					}
					else if(action.equalsIgnoreCase("ricercaData")) {
						String d1= request.getParameter("DataOrdine1");
						String d2 = request.getParameter("DataOrdine2");

						request.removeAttribute("VOrdini");
						request.setAttribute("VOrdini", OrdiniDAO.doRetrieveByKey2(null,d1,d2));

						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Ordini.jsp");
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
