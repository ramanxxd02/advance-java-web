package in.co.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet Config do get method");
		ServletConfigCtl config= (ServletConfigCtl) getServletConfig();
		System.out.println(config.getInitParameter("driver"));
		System.out.println(config.getInitParameter("url"));
	}
}
