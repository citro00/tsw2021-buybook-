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
	<link href="Carrello.css" rel="stylesheet" type="text/css">
	<title>Ordini</title>
</head>

<body>
<jsp:include page="header.jsp"/>
<jsp:include page="barranavigazionale.jsp"/>
	<h2>Composizioni</h2>
	
<table border="1">
		 <div class="table">
      
      <div class="layout-inline row th">
        <div class="col col-pro">Quantità</div>
        
        <div class="col col-qty align-center">Numero ordine</div>
        <div class="col col-price align-center "> 
Codice        </div>
      </div>
      
		   <%
            if (composizioni != null && composizioni.size() != 0) {
                Iterator<?> it = composizioni.iterator();
                while (it.hasNext()) {
                    ComposizioneBean bean = (ComposizioneBean) it.next();
        %>
		
			 <div class="layout-inline row">
        
        <div class="col col-pro layout-inline">
          <p><%= bean.getQuantità() %></p>
        </div>
        

        <div class="col col-qty layout-inline">
         
           <p> <%= bean.getId_ordine()%></p>
          
        </div>
        
        <div class="col col-price col-numeric">
          <p><%= bean.getCodice()%></p>
        </div>
        
        </div>
 <%
                }
            } 
        %>
      </div>
</body>
<jsp:include page="footer.jsp"/>

</html>