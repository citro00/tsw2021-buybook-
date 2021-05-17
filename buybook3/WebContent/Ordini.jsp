<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
 Listaordini lista = (Listaordini) request.getAttribute("listaordini");
 List <OrdiniBean> ordini= lista.getListaordini();
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,it.unisa.*"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	<title>Ordini</title>
</head>

<body>
	<h2>Ordini</h2>
	<table border="1">
		<tr>
		
			<th>IDOrdine</th>
			<th>Stato </th>
			<th>costo</th>
			<th>Buono</th>
			<th>Cfcliente</th>
			<th>data</th>
		   <th>DETTAGLI</th>
			
		</tr>
		<%
			if (ordini != null && ordini.size() != 0) {
				Iterator<?> it = ordini.iterator();
				while (it.hasNext()) {
					OrdiniBean bean = (OrdiniBean) it.next();
		%>
		<tr>
			<td><%=bean.getId_ord() %></td>
			<td><%=bean.getStato()%></td>
			<td><%=bean.getCosto() %></td>
			<td><%=bean.getBuono() %></td>
			<td><%=bean.getCfcliente() %></td>
			<td><%=bean.getData() %></td>
			<td><a href="prodotto?action=dettagli&codice=<%=bean.getId_ord()%>" target=_blank>DETTAGLI</a>
			
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="6">Non ci sono ordini</td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="./ProductV.jsp">HOME</a>
</body>
</html>