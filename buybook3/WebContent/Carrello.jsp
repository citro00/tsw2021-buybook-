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
	<title>ACQUISTO</title>
</head>

<body>
<jsp:include page="header.jsp"/>
<jsp:include page="barranavigazionale.jsp"/>

		<h2>Carrello</h2>
		<table border="1">
		<tr>
			<th>Nome</th>
			<th>Costo totale</th>
			<th>Quantità</th>
			<th>Azione</th>
		</tr>
		<% List<CartProduct> ProdottiCarrello= cart.getProducts(); 	
		   for(CartProduct beancart: ProdottiCarrello) {
		%>
		<tr>
			<% if(beancart.getPezzi()>0){ %>
			<td><%=beancart.getNome() %></td>
			<td><%=beancart.Costototale() %></td>
			<td><%=beancart.getPezzi() %></td>
			<td><a href="prodotto?action=deleteC&codice=<%=beancart.getIDProdotto()%>">Cancella dal carrello</a><br>
			
			
			<%if(user!=null){ %>
			
            <td><a href="prodotto?action=acquista"><button>ACQUISTA</button></a></td>
                   
            <%}%>
        
        <%if(user==null) {%><td><a href="Loginerrato.jsp"><button>ACQUISTA</button></a></td>
        <%}%>
        <%}%>
        <%}%>
        
		</tr>
		

<jsp:include page="footer.jsp"/>
</body>
</html>