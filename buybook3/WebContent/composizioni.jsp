<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
 ListaComposizioni lista = (ListaComposizioni) request.getAttribute("composizioni");
 List <ComposizioneBean> composizioni= lista.getListacomposizone();
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
	<h2>Composizioni</h2>
	<table border="1">
		<tr>
		
			<th>quantità</th>
			<th> numero ordine</th>
			<th>codice</th>
		
	
			
		</tr>
		<%
			if (composizioni != null && composizioni.size() != 0) {
				Iterator<?> it = composizioni.iterator();
				while (it.hasNext()) {
					ComposizioneBean bean = (ComposizioneBean) it.next();
		%>
		<tr>
			<td><%= bean.getQuantità() %></td>
			<td><%= bean.getId_ordine()%></td>
			<td><%=bean.getCodice()%></td>
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