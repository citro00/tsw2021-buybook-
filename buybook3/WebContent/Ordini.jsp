<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserBean account= (UserBean) session.getAttribute("currentSessionUser");	
 	Collection<?> ordini= (Collection<?>) request.getAttribute("VOrdini");
 	if(ordini==null){
	 	response.sendRedirect("./ordini");
 	}
 

 
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
<jsp:include page="header.jsp"/>
<jsp:include page="barranavigazionale.jsp"/>
	<h2>Ordini</h2>
	<% if(account.getAdmin()==1){ %>
				<form action="prodotto" method="get">
				<input type="hidden" name="action" value="ricerca"> 
				<label for="CF"> CF cliente: </label><br> 
				<input name="CF" type="text" placeholder="inserisci codice fiscale"><br> 
				<input type="submit" value="submit"><input type="reset" value="Reset">
				</form>
				<br>
				<form action="prodotto" method="get">
				<input type="hidden" name="action" value="ricercaData"> 
				<label for="DataOrdine1">Data inizio: </label><br> 
				<input name="DataOrdine1" type="text" maxlength="20"  placeholder="inserisci data inizio"><br> 
				<label for="DataOrdine2">Data fine: </label><br>
				<input name="DataOrdine2" type="text" maxlength="20"  placeholder="inserisci data fine"><br> 
				<input type="submit" value="submit"><input type="reset" value="Reset">
				</form>
			
		<%} %>
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
			<td><a href="prodotto?action=dettagli&codice=<%=bean.getId_ord()%>">DETTAGLI</a>
			
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
		
	<jsp:include page="footer.jsp"/>

</body>
</html>