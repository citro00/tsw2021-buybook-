<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
	
    UserBean user= (UserBean) session.getAttribute("currentSessionUser");
	ProductBean prodotto = (ProductBean) request.getAttribute("prodotto");
	
	Cart cart = (Cart) request.getAttribute("Cart");
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,it.unisa.*"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="ProductStyle.css" rel="stylesheet" type="text/css">
		<link href="Carrello.css" rel="stylesheet" type="text/css">
	
	<title>ACQUISTO</title>
</head>

<body>
<jsp:include page="header.jsp"/>
<jsp:include page="barranavigazionale.jsp"/>

		<h2>Carrello</h2>
		
			 <div class="table">
      
      <div class="layout-inline row th">
        <div class="col col-pro">Nome</div>
        
        <div class="col col-qty align-center">Quantità</div>
        <div class="col col-price align-center "> 
          Costo
        </div>
      </div>
      
		<% List<CartProduct> ProdottiCarrello= cart.getProducts(); 	
		   for(CartProduct beancart: ProdottiCarrello) {
		%>
		            <% if(beancart.getPezzi()>0){ %>
		
			 <div class="layout-inline row">
        
        <div class="col col-pro layout-inline">
          <p><%=beancart.getNome() %></p>
        </div>
        

        <div class="col col-qty layout-inline">
           <a href="prodotto?action=deleteC&codice=<%=beancart.getIDProdotto()%>" style="line-height:10px"><h1>-</h1></a>
           <p> <%=beancart.getPezzi() %> </p>
          <a href="prodotto?action=addC&codice=<%=beancart.getIDProdotto()%>" style="line-height:10px"><h2>+</h2></a>
        </div>
        
        <div class="col col-price col-numeric">
          <p><%=beancart.Costototale() %></p>
        </div>
        
        </div>
      </div>
      
			<%if(user!=null){ %>
			
           <a href="prodotto?action=acquista">ACQUISTA</a>
                   
            <%}%>
        
        <%if(user==null) {%><a href="Loginerrato.jsp">ACQUISTA</a>
        <%}%>
        <%}%>
        <%}%>
        
		
		

<jsp:include page="footer.jsp"/>
</body>
</html>