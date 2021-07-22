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
<div class="hero-image">
      <div class="hero-text">
        <h1 style="font-size:30px">Buybook</h1>

      </div>
    </div>
<jsp:include page="barranavigazionale.jsp"/>

		<%
        int i=0;
        int j=0;

        String[] nomi= {"column side","column middle","column side"};
        if (prodotti != null && prodotti.size() != 0) {
                   Iterator<?> it = prodotti.iterator();
                   ArrayList<ProductBean> ls= new ArrayList<ProductBean>();
                   while (it.hasNext()) {
                       ProductBean bean = (ProductBean) it.next();
                       ls.add(bean);
                       System.out.println(ls.get(i).toString());
                       i++;
                       }

                 %>
          <div class= "row">
                <% for(i=0;i<ls.size();i++){%>


                 <div class="<%=nomi[j]%>">
                 <img src="./getPicture?id=<%=ls.get(i).getCodice()%>" onerror="this.src='./imgs/nophoto.png width="200px" height="200px">
                <br>
                <%=ls.get(i).getNome()%>
                <br>
                <%=ls.get(i).getPrezzo()%> Euro
                <br>
                <a href="prodotto?action=read&codice=<%=ls.get(i).getCodice()%>">DETTAGLI</a>
                <br>
                <a href="prodotto?action=addC&codice=<%=ls.get(i).getCodice()%>">CARRELLO</a>
	
                  </div>

 
        <%
        if(j<2) j++;
            else j=0;

                }
            } 
        %>
        </div>
	
	
	<jsp:include page="footer.jsp"/>

</html>