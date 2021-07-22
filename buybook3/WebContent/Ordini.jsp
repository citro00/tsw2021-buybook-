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
	
<link href="Ordini.css" rel="stylesheet" type="text/css">
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
	<section>
  
			
		<%
			if (ordini != null && ordini.size() != 0) {
				Iterator<?> it = ordini.iterator();
				while (it.hasNext()) {
					OrdiniBean bean = (OrdiniBean) it.next();
		%>
		
			
  <div class="panel-body">
            <div class="row">
                <div class="col-md-1"><img src="https://bootdey.com/img/Content/user_3.jpg" class="media-object img-thumbnail" /></div>
                <div class="col-md-11">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="pull-right"><label class="label label-danger">            <%=bean.getStato()%>
                            </label></div>
                            <span><strong>Id ordine: <%=bean.getId_ord() %>  Id Utente: <%=bean.getCfcliente() %></strong></span> 
                           Costo: <%=bean.getCosto() %> €
                            <br />
                            
                        </div>
                        <div class="col-md-12">Data ordine: <%=bean.getData() %> 
                        <a href="prodotto?action=dettagli&codice=<%=bean.getId_ord()%>">DETTAGLI</a> </div>
                    </div>
                </div>
            </div>
  
  

		<%
				}
			} 
		%>
		
		
		
	<jsp:include page="footer.jsp"/>

</body>
</html>






