
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	ProductBean prodotto = (ProductBean) request.getAttribute("prodotto");

%>

<!DOCTYPE html>
<html> 
	<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,it.unisa.*"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	<title>buybook </title>
</head>
	
	<body>
		<jsp:include page="header.jsp"/>
		<jsp:include page="barranavigazionale.jsp"/>
		<h2>Details</h2>
		
		<table border="1">
			<tr>
				<th>Codice</th>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Prezzo</th>
				<th>Quantità</th>
				<th>Sconto</th>
			</tr>

			<tr>
				<td><%=prodotto.getCodice()%></td>
				<td><%=prodotto.getName()%></td>
				<td><%=prodotto.getgenere()%></td>
				<td><%=prodotto.getPrezzo()%></td>
				<td><%=prodotto.getQuantità()%></td>
				<td><%=prodotto.getSconto()%></td>
				
				<td><a href="prodotto?action=addC&codice=<%=prodotto.getCodice()%>"target=_blank>Aggiungi al Carrello</a></td>		
			</tr>
		
		</table>
		<jsp:include page="footer.jsp"/>
	</body>
</html>