<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
	<jsp:include page="barranavigazionale.jsp"/>
		<form action="Login">

			Inserisci il tuo username		
			<input type="text" name="nickname"/><br>		
		
			Inserisci la tua paswword
			<input type="password" name="password"/>
			
			<input type="submit" value="accedi">			
		
		</form>

<jsp:include page="footer.jsp"/>

	</body>
</html>
