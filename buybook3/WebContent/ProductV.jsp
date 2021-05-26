<%@page import="it.unisa.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
	if(prodotti == null) {
		response.sendRedirect("./prodotto");	
		return;
	}
	UserBean account= (UserBean) session.getAttribute("currentSessionUser");
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
<jsp:include page="header.jsp"/>
<jsp:include page="barranavigazionale.jsp"/>

	<h2>Libri Disponibili</h2>
	
	<table border="1">
		<tr>
			<th>Codice</th>
			<th>Nome </th>
			<th>genere </th>
			<th>Prezzo</th>
			<th>Sconto</th>
		    <th>Autore</th>
		    <th>Azione</th>
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
			<td><%=bean.getAutore() %></td>
			<td><a href="prodotto?action=read&codice=<%=bean.getCodice()%>">DETTAGLI</a>
			<br>
			<a href="prodotto?action=addC&codice=<%=bean.getCodice()%>">Aggiungi al Carrello</a>
                
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
	
	<jsp:include page="footer.jsp"/>

</html>