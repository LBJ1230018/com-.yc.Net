package http3Cookie;

import java.io.PrintWriter;



public class HelloServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		PrintWriter pw=response.getWriter();
		pw.print("<h1>Hello world</h1>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		doGet(request, response);
	}
	
}
