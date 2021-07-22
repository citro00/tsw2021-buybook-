<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<link href="ProductStyle.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <script type = "text/javascript" src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<title>Registrati</title>
	</head>

	<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="barranavigazionale.jsp"/>
	
	
	
	
	<script>
	
	function checkemail(){
                var valid=true;
                var email=/^\w+([.-]?\w+)@\w+([.-]?\w+)(.\w{2,3})+$/;
                var ema=document.getElementById("email");
                if(ema.value.match(email)){
                    ema.classList.remove("error");
                    document.getElementById("spanerror").innerHTML = " ";
                }
                else{
                    valid=false;
                    ema.classList.add("error");
                    document.getElementById("spanerror").innerHTML = "inserire un'email valida";

                }

                }
	
	</script>
	<script>
	function checkpass(){
        var valid=true;
        var email=/^.{7,15}$/;
        var ema=document.getElementById("pass");
        if(ema.value.match(email)){
            ema.classList.remove("error");
            document.getElementById("spane").innerHTML = " ";
        }
        else{
            valid=false;
            ema.classList.add("error");
            document.getElementById("spane").innerHTML = "inserire una password valida (da 7 a 15 caratteri)";

        }

        }
	
	
	$(document).ready(function(){
        $("#email").blur(function(){
            var email= $("#email").val();
            $.ajax({
            type:"POST",
            data:{email:email},
            url:"controllo",
            success:function(result){
            $("#c").html(result);
            }
            });
        });
    });
                </script>
                
		<form action="Register">

			<input type="text" name="nickname" placeholder="Username" required/><br>		
		<span id="spane"></span> <br>
			<input type="password" name="password" placeholder="Password"  class="" id="pass" onblur="checkpass()"/><br>
			
			<input type="text" name="Nome" placeholder="Nome"/ required><br>
			
			<input type="text" name="Cognome" placeholder="Cognome" required/><br>
			<span id="spanerror"></span> <br>
			<span id="c"> </span> <br>
			<input type="text" name="Email" placeholder="Email" class="" id="email" onblur="checkemail()" required/><br> 
		
			<input type="text" name="CF" placeholder="Codice fiscale" required/><br>
			
			<input type="text" name="Telefono" placeholder="Telefono"/><br>
			
			<input type="text" name="datadinascita" placeholder="Data di nascita"/><br>
			
			<input type="text" name="CAP" placeholder="Cap"/><br>
			
			<input type="text" name="VIA" placeholder="Via"/><br>
			
			<input type="text" name="NCivico" placeholder="Numero civico"/><br>
			
			<input type="text" name="Provincia" placeholder="Provincia"/><br>
			
			<input type="text" name="NCarta" placeholder="Numero carta"/><br>
			
			<input type="text" name="datascadenza" placeholder="Data di scadenza"/><br>
			
			<input type="text" name="CVV" placeholder="CVV"/><br>
			
			<input type="text" name="intestatario" placeholder="Intestatario carta"/><br>
			
			<a value="Registrati" href="LoginPage.jsp">Registrati	
		
		</form>
				
	<jsp:include page="footer.jsp"/>

	</body>
</html>