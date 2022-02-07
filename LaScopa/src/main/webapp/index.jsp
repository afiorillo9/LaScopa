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
		<%@ include file="menu.jsp"%>
        
        <br />
        
        <section>
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5">
                    <div class="col-lg-6 div-presentazione">
                        <h1 class="mt-5">Benvenuto!</h1>
                        <p>Ti presentiamo il gioco della scopa versione web</p>
                    </div>
                </div>
            </div>
        </section>
        
        <br />
        
        <section>
            <div class="container px-5 px-lg-5">
                <div class="row gx-5 gx-lg-5">
                    <div class="col-lg-12 div-presentazione">
                        <h3 class="mt-5">La storia</h3>
                        <p>Bla bla bla.</p>
       			 	</div>
                </div>
            </div>
        </section>
        
        <br />
        
        <section>
            <div class="container px-5 px-lg-5">
                <div class="row gx-5 gx-lg-5">
                    <div class="col-lg-12 div-presentazione">
                        <h3 class="mt-5">Cosa puoi fare ora?</h3>
                        <p>Bla bla bla.</p>
       			 	</div>
                </div>
            </div>
        </section>
        
        <!-- Javascript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/scripts.js"></script>
	</body>
</html>