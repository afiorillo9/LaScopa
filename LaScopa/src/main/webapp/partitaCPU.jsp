<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>

<%
	String role = (String) session.getAttribute("ruolo");
	
	if(role != null) {
		if(role.equals("gestore")) {
			response.sendRedirect(request.getContextPath() + "/gestore/index.jsp");
			return;
		} 
		
		if(role.equals("giocatore")) {
			response.sendRedirect(request.getContextPath() + "/giocatore/index.jsp");
			return;
		}
	}
%>

<!DOCTYPE html>
<html lang="it">
	<head>
        <meta charset="utf-8" name="Simone" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <link href="css/styles.css" rel="stylesheet" />        
        <link rel="icon" type="image/x-icon" href="img/logo.ico" />
        
		<title>LaScopa</title>
	</head>
	<body>
		<%@ include file="menu-gioco.jsp"%>
        
        <br />
        
        <section>
            <div class="container px-5 px-lg-5">
                <div class="row gx-5 gx-lg-5">
                    <div class="col-lg-12 div-presentazione">
                    	
       			 	</div>
                </div>
            </div>
        </section>
        
        <!-- Javascript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/scripts.js"></script>
	</body>
</html>