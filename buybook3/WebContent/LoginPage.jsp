<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<header>
		<link href="New.css" rel="stylesheet" type="text/css">
		<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	
	
<jsp:include page="header.jsp"/>
	<jsp:include page="barranavigazionale.jsp"/>
</header>

<h2>Benvenuto</h2>
<div class="container" id="container">
	
	<div class="form-container sign-in-container">
		<form action="Login">
			<h1>Login</h1>
			<span>Inserire i tuoi dati</span>
			<input type="text" name="nickname" placeholder="Username" />
			<input type="password" name="password" placeholder="Password" />
			<input type="submit" value="Accedi">	</form>
	</div>
	<div class="overlay-container">
	
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Ciao!</h1>
				<p>Sei nuovo? Entra a far parte del nostro sito</p>
				<a href="Registrazione.jsp">Registrati</a>
			</div>
		</div>
	</div>
</div>


<jsp:include page="footer.jsp"/>

</html>
