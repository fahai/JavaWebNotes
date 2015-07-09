package org.fahai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>ServletConfig Test</title></head>");
		out.println("<body>");
		out.println("Servlet Name: " + this.getServletName() + "<br/>");
		Enumeration parameters = this.getInitParameterNames();
		while (parameters.hasMoreElements()) {
			String key = (String) parameters.nextElement();
			String value = this.getInitParameter(key);
			out.println("&nbsp;&nbsp;" + key + " = " + value + "<br/>");
		}
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath("/");
		out.println("Current Web App Path: " + realPath + "<br/>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
