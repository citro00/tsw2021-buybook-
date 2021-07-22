<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%


Collection<?> ordini = (Collection<?>) request.getAttribute("prodotti");

%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,it.unisa.*"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	<title>Prodotti</title>
</head>

<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="barranavigazionale.jsp"/>
	<h2>Prodotti</h2>
	<table border="1">
	
		<tr>
		
			<th>Codice</th>
			<th>Autore </th>
			<th>Sconto</th>
			<th>Prezzo</th>
			<th>Genere</th>
			<th>N_pezzi</th>
		   	<th>Nome</th>
		   	<th>Copertina</th>
			
		</tr>
		<%
			if (ordini != null && ordini.size() != 0) {
				Iterator<?> it = ordini.iterator();
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
		%>
		<tr>
			<td><%=bean.getCodice() %></td>
			<td><%=bean.getAutore() %></td>
			<td><%=bean.getSconto() %></td>
			<td><%=bean.getPrezzo() %></td> 
			<td><%=bean.getGenere() %></td>
			<td><%=bean.getQuantità() %></td>
			<td><%=bean.getNome() %></td>
			<td><img src="./getPicture?id=<%=bean.getCodice()%>" onerror="this.src='./imgs/nophoto.png" width="100px" height="100px"></td>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="6">Non ci sono prodotti</td>
		</tr>
		<%
			}
		%>
	</table>
	<h2>Inserimento prodotti</h2>
        <form action="prodotto" method="post">
        <input type="hidden" name="action" value="inserimento"> 

        <label for="codice">Codice a barre: </label><br> 
        <input name="codice" type="text" maxlength="100" required placeholder="inserisci codice a barre"><br> 

        <label for="autore">Autore: </label><br>
        <textarea name="autore" type="text" maxlength="40" rows="40"></textarea><br>

		<label for="sconto">Sconto:</label><br>
		<input name="sconto" type="number" min="0"  required><br>

        <label for="prezzo">Prezzo: </label><br>
		<input name="prezzo" type="number" min="1" required><br>
		
        <label for="genere">Genere:</label><br> 
        <textarea name="genere" type="text" maxlength="100" rows="40" ></textarea><br>

        <label for="N_pezzi">Quantita: </label><br> 
       <input name="N_pezzi" type="number" min="1" required><br>

        <label for="nome">Nome: </label><br> 
        <textarea name="nome" maxlength="100" rows="40"></textarea><br>

        <input type="submit" value="submit"><input type="reset" value="Reset">



    </form>
	<h2>Modifica Prodotti</h2>
		
		<form action="prodotto" method="post">
			<input type="hidden" name="action" value="modificaCC"> 
			<label for="codice">Codice libro da modificare: </label><br> 
			<input name="codice" type="text" maxlength="20"  placeholder="inserisci codice"><br> 
			<label for="autore">Autore: </label><br>
			<textarea name="autore" maxlength="3" rows="3"  placeholder="inserire codice"></textarea><br>
			<input type="submit" value="submit"><input type="reset" value="Reset">
		</form>
		
		<form action="prodotto" method="post">
			<input type="hidden" name="action" value="modificaSc">
			<label for="codice">Codice libro da modificare: </label><br> 
			<input name="codice" type="text" maxlength="20"  placeholder="inserisci codice"><br> 
			<label for="sconto">Sconto: </label><br> 
			<input name="sconto" type="number" value="0"><br>
			<input type="submit" value="submit"><input type="reset" value="Reset">
		</form>
		
		<form action="prodotto" method="post">
			<input type="hidden" name="action" value="modificaPrz"> 
			<label for="codice">Codice libro da modificare: </label><br> 
			<input name="codice" type="text" maxlength="20"  placeholder="inserisci codice"><br> 
			<label for="prezzo">Prezzo :</label><br> 
			<input name="prezzo" type="number" value="0"><br>
			<input type="submit" value="submit"><input type="reset" value="Reset">
		</form>
		
		
		<form action="prodotto" method="post">
			<input type="hidden" name="action" value="modificaGen"> 
			<label for="codice">Codice libro da modificare: </label><br> 
			<input name="codice" type="text" maxlength="20"  placeholder="inserisci codice"><br> 
			<label for="genere">Genere: </label><br> 
			<textarea name="genere" maxlength="100"  placeholder="inserire genere prodotto"></textarea><br>
			<input type="submit" value="submit"><input type="reset" value="Reset">
		</form>
	
		<form action="prodotto" method="post">
			<input type="hidden" name="action" value="modificaPz"> 
			<label for="codice">Codice libro da modificare: </label><br> 
			<input name="codice" type="text" maxlength="20"  placeholder="inserisci codice"><br> 
			<label for="N_pezzi">Prezzo :</label><br> 
			<input name="N_pezzi" type="number" ><br>
			<input type="submit" value="submit"><input type="reset" value="Reset">
		</form>
		
		<form action="prodotto" method="post">
			<input type="hidden" name="action" value="modificaNom"> 
			<label for="codice">Codice libro da modificare: </label><br> 
			<input name="codice" type="text" maxlength="20"  placeholder="inserisci codice"><br> 
			<label for="nome">Nome: </label><br>
			<textarea name="nome" maxlength="100" rows="3" placeholder="inserire descrizione prodotto"></textarea><br>
			<input type="submit" value="submit"><input type="reset" value="Reset">
		</form>
<jsp:include page="footer.jsp"/>
</body>
</html>