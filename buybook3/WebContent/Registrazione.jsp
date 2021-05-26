<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Registrati</title>
	</head>

	<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="barranavigazionale.jsp"/>
		<form action="Register">

			Inserisci il tuo username 		
			<input type="text" name="nickname"/><br>		
		
			Inserisci la tua password
			<input type="password" name="password"/><br>
			
			Inserisci Nome
			<input type="text" name="Nome"/><br>
			
			Inserisci Cognome
			<input type="text" name="Cognome"/><br>
			
			Inserisci Email
			<input type="text" name="Email"/><br>
			
			Inserisci Codice Fiscale
			<input type="text" name="CF"/><br>
			
			Inserisci Telefono
			<input type="text" name="Telefono"/><br>
			
			Inserisci Data di nascita
			<input type="text" name="datadinascita"/><br>
			
			Inserisci Cap
			<input type="text" name="CAP"/><br>
			
			Inserisci Via
			<input type="text" name="VIA"/><br>
			
			Inserisci Numero civico
			<input type="text" name="NCivico"/><br>
			
			Inserisci Provincia
			<input type="text" name="Provincia"/><br>
			
			Inserisci Numero carta di credito
			<input type="text" name="NCarta"/><br>
			
			Inserisci Data scadenza
			<input type="text" name="datascadenza"/><br>
			
			Inserisci CVV
			<input type="text" name="CVV"/><br>
			
			Inserisci Intestatario carta
			<input type="text" name="intestatario"/><br>
			
			<input type="submit" value="Registrati">			
		
		</form>
				
	<jsp:include page="footer.jsp"/>

	</body>
</html>