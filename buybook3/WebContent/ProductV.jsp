<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
	if(prodotti == null) {
		response.sendRedirect("./prodotto");	
		return;
	}
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,it.unisa.ProductBean"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	<title>buybook</title>
</head>

<body>

	<h2>Prodotti</h2>
	<a href="prodotto?action=ordini"target=_blank>ordini</a>
	<table border="1">
		<tr>
			<th>codice</th>
			<th>Nome </th>
			<th>genere </th>
			<th>Prezzo</th>
			<th>Sconto</th>
		</tr>
		<%
			if (prodotti != null && prodotti.size() != 0) {
				Iterator<?> it = prodotti.iterator();
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
		%>
		<tr>
			<td><%=bean.getCodice()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getgenere()%></td>
			<td><%=bean.getPrezzo() %></td>
			<td><%=bean.getSconto() %></td>
			<td><a href="prodotto?action=read&codice=<%=bean.getCodice()%>" target=_blank>DETTAGLI</a>
			<br>
			<a href="prodotto?action=addC&codice=<%=bean.getCodice()%>"target=_blank>Aggiungi al Carrello</a>
                
                </td>
			
		</tr>
		
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="6">Non ci sono prodotti</td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="./LoginPage.jsp"target=_blank>login</a>
	<a href="./Registrazione.jsp"target=_blank>Registrati</a>
</body>
</html>