package http2requestresponse;

import java.io.PrintWriter;

import http2requestresponse.HttpServletRequest;

public class HelloServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<h1>Hello world</h1>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		doGet(request, response);
	}
	
}
