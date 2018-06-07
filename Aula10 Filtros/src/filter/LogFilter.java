package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/*")
public class LogFilter implements Filter {

    public LogFilter() {   }

	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario)session.getAttribute("logado");
		
		if(usuario == null) {
			System.out.println(req.getParameter("command"));
		}else {
			System.out.println(usuario.getNome()+ " -> " + req.getParameter("command"));
		}
		chain.doFilter(request, response);
		if(usuario == null) {
			System.out.println(req.getParameter("command"));
		}else {
			System.out.println(req.getParameter("command") + " -> " + usuario.getSenha());
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {}
}