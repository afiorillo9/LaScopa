package it.unisa.lascopa.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * 1
 * @author fiorillo
 *
 */
@WebListener
public class MainContext implements ServletContextListener {

	
	public void contextInitialized(ServletContextEvent sce) {
		Utility.print("Startup web application");
		
		ServletContext context = sce.getServletContext();
		
		DataSource ds = null;
		
		try {
			
			Context initCtx = new InitialContext();

			Context emvCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) emvCtx.lookup("jdbc/lascopa");
			
			Connection con = null;
			
			try {
				
				con = ds.getConnection();
				
				DatabaseMetaData metadata = con.getMetaData();
				
				Utility.print("DBMS name : " + metadata.getDatabaseProductName());
				
				Utility.print("DBMS version : " + metadata.getDatabaseProductVersion());

			
			} catch(SQLException e) {
				
				Utility.print(this,e);
				
			} finally {
				
				if(con != null)
					
					try {
						
						con.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
			}
			
			
		
		} catch(NamingException e) {
			
			Utility.print(this,e);
			
		}
		
		context.setAttribute("Datasource", ds);
		
		Utility.print("DataSource creation : " + ds.toString() );
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		
		context.removeAttribute("DataSource");
		
		Utility.print("Shutdown web application");
		
	}
}
