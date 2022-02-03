/**
 * 
 */
package it.unisa.lascopa.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @author simon
 *
 */
public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		HttpSession session = hrequest.getSession(false);
		
		boolean ruoloGestore = hrequest.getRequestURI().contains("/gestore/");
		boolean ruoloGiocatore = hrequest.getRequestURI().contains("/giocatore/");
		
		if(ruoloGestore && session != null) {
			String roleSession = (String) session.getAttribute("ruolo");
			
			if(roleSession != null && roleSession.equalsIgnoreCase("gestore"))
				chain.doFilter(request, response);
			else {
				hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp");
				return;
			}
		} else if(ruoloGiocatore && session != null) {
			String roleSession = (String) session.getAttribute("ruolo");
			
			if(roleSession != null && roleSession.equalsIgnoreCase("giocatore")) 
				chain.doFilter(request, response);
			else {
				hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp");
				return;
			}
		} else {
			hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp");
			return;
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {

	}
	
	public void destroy() {

	}
}
