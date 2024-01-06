package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connection.SingleConnection;





@WebFilter(urlPatterns = {"/principal/*"})
public class FilterAutentication  implements Filter {
    private static Connection connection;
  
	
	public FilterAutentication() {
        
        
    }

	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String usuariologado = (String) session.getAttribute("usuario");
		String urlAutenticar = req.getServletPath();
		if (usuariologado == null || usuariologado.equals("null") && ! urlAutenticar.equalsIgnoreCase("/principal/ServletLogin")){
			RequestDispatcher  redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlAutenticar);
			request.setAttribute("msg", "Por favor realize o  login !");
			redireciona.forward(request, response);
			return ;
		}else {
		chain.doFilter(request, response);
		
	    }
		 connection.commit();
		 }catch(Exception e){
			e.printStackTrace();					
			RequestDispatcher redirecionar = request.getRequestDispatcher("erros.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnection.getConnection();
	}

}
