package in.co.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Forwardservlet01")
public class Forwardservlet01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Forward Servlet 01 do get");

		RequestDispatcher rd = req.getRequestDispatcher("ForwardServlet02");

		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Forward Servlet 01 do post");

		RequestDispatcher rd = req.getRequestDispatcher("ForwardServlet02");

		rd.forward(req, resp);

	}
}
