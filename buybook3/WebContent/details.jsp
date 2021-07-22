
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
	<link href="Dettagli.css" rel="stylesheet" type="text/css">
		<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	
	<title>buybook </title>
</head>

	
<body>

  <main>
  <jsp:include page="header.jsp"/>
<jsp:include page="barranavigazionale.jsp"/>
    <div class="card">
      <div class="card__title">
       
        <h3>Articolo</h3>
      </div>
      <div class="card__body">
        <div class="half">
          <div class="featured_text">
            <h1><%=prodotto.getName()%></h1>
            <p class="sub"><%=prodotto.getAutore()%></p>
            <p class="price"><%=prodotto.getPrezzo()%> €</p>
          </div>
          <div class="image">
            <img src="./getPicture?id=<%=prodotto.getCodice()%>" onerror="this.src='./imgs/nophoto.png width="200px" height="200px">
          </div>
        </div>
        </div>
        <div class="half">
          <div class="description">
            <p>
			Codice: <%=prodotto.getCodice()%> <br>
			Pezzi: <%=prodotto.getQuantità()%> <br>
			Autore: <%=prodotto.getAutore()%> <br>
			Genere: <%=prodotto.getGenere()%> <br>
			Prezzo: <%=prodotto.getPrezzo()%> € <br>
			</p>
          </div>
    
        </div>
        
        <div class="action">
         <a href="prodotto?action=addC&codice=<%=prodotto.getCodice()%>">CARRELLO</a>
        </div>
      </div>
     
        
      </div>
    </div>
  </main>
  	<jsp:include page="footer.jsp"/>
</body>
</html>