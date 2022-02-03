<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>

<%
	String nickname = "Test";
%>

<!DOCTYPE html>
<html lang="it">
	<head>
        <meta charset="utf-8" name="Simone" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <link href="../css/styles.css" rel="stylesheet" />        
        <link href="../css/table.css" rel="stylesheet" />        
        <link rel="icon" type="image/x-icon" href="../img/logo.ico" />
        
		<title>LaScopa</title>
	</head>
	<body>
		<%@ include file="menu.jsp"%>
        
        <br />
        
        <section>
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5">
                    <div class="col-lg-6 div-presentazione">
                        <h1 class="mt-5">Benvenuto <%=nickname%></h1>
                        <p>Benvenuto nella tua pagina personale</p>
                    </div>
                </div>
            </div>
        </section>        
        
        <br />
        
        <section>
            <div class="container px-5 px-lg-5">
                <div class="row gx-5 gx-lg-5">
                    <div class="col-lg-12 div-presentazione">
                        <h2 class="mt-5">Giocatori online</h2>
                        <p>Sfida un giocatore cliccando sull'apposito bottone affianco al nickname e aspetta che risponda.</p>
                        <p>Se cambi idea puoi sempre annullare la sfida.</p>
                        <p>Ricoda anche tu puoi essere sfidato e sta a te decidere se accettare confermando la sfida.</p>
                    
						<br />
						
	                    <div class="tableTable">
							<div class="rowTable header">							
								<div class="cellTable">
									Nickname <a href=""><i class="fas fa-sort"></i></a>
								</div>							
								<div class="cellTable">
									Comando
								</div>
							</div>
							
							<%
							//if(listGiocatori != null && listGiocatori.size() > 0) {
								//Iterator<?> it = listGiocatori.iterator();
								
								//(it.hasNext()) {
	
							%>
							
							<div class="rowTable">
								<div class="cellTable" data-title="Nickname">
								</div>
								<div class="cellTable">								
									<a href="" class="">Sfida</a>
								</div>
							</div>
				
							<%
									
										//}
									//}
							%>
						</div>
						
						<br />
                    </div>
                </div>
            </div>
        </section>
        
        <!-- Javascript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="../js/scripts.js"></script>
	</body>
</html>