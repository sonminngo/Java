package kt;

import java.io.IOException;
import javax.servlet.*;

public class InputFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String username = request.getParameter("username");
        if (username == null || username.trim().isEmpty()) {
            request.setAttribute("message", "Username cannot be empty.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
