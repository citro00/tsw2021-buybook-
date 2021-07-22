<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html>

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Admin Page</title>
	</head>

	<body>
<jsp:include page="header.jsp"/>
<jsp:include page="barranavigazionale.jsp"/>
<h1>Sezione admin</h1>
     

		<a href="prodotto?action=VOrdini">Ordini</a>
		<a href="prodotto?action=Catalogo">Catalogo</a>
		<br>
		
<jsp:include page="footer.jsp"/>
	</body>
</html>
