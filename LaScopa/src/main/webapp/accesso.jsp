<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>

<%


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
            <div class="container px-5 px-lg-5">
                <div class="row gx-5 gx-lg-5">
                    <div class="col-lg-12 div-presentazione">
                        <h3 class="mt-5">Modulo di accesso</h3>
                        <p>Inserendo i dati che hai inserito al momento della registrazione potrai effettuare l'accesso e goderti tutti i vantaggi che porta.</p>
       			 	</div>
                </div>
            </div>
        </section>
        
        <br />
        
        <section>
            <div class="container px-5 px-lg-5">
                <div class="row gx-5 gx-lg-5">
                    <div class="col-lg-12 div-proposta"> 
                        <form id="form" action="${pageContext.servletContext.contextPath}/Accesso" method="post" enctype="multipart/form-data" onsubmit="event.preventDefault(); validate(this)">
                        	<br /><label for="email">Email:</label><br />
                        	<input type="email" name="email" placeholder=" inserire una email" required><br />	
                        	
                        	<br /><label for="password">Password:</label><br />
                        	<input type="password" name="password" placeholder=" inserire una password" required><br />	
                        	
                        	<br /><input type="submit" class="" value="Accedi"><br /><br />
                        </form>
       			 	</div>
                </div>
            </div>
        </section>
        
        <!-- Javascript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/scripts.js"></script>
	</body>
</html>