//package br.com.empresa.projeto.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.struts2.interceptor.ServletRequestAware;
//import org.apache.struts2.interceptor.ServletResponseAware;
//
//public class FilterLogin implements Filter {
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//	}
//
//	@Override
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
//			throws IOException, ServletException {
//		
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//		HttpSession session =  request.getSession();
//		
//		System.out.println("entrei aqui");
//		
//		if (session.getAttribute("usuarioLogado") != null) {
//			System.out.println("logado");
//			chain.doFilter(request, response);
//		}  else {
//			System.out.println("não logado");
//			//response.sendRedirect(request.getContextPath());
//		}
//		
//		
//	}
//
//	@Override
//	public void destroy() {
//		throw new UnsupportedOperationException("Not supported yet.");
//	}
//
//}
