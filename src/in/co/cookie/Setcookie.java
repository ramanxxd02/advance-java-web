package in.co.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Setcookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String value = req.getParameter("value");

		Cookie c = new Cookie(name, value);

		c.setMaxAge(15);// possitive ho to uthne second me distroye ho jati h cookie
		                // null ya 0 ho to genrate hote hi distroye ho jati h cookie
		                // nagetive ho to genrate hi nhi hoti hai cookie

		resp.addCookie(c);
	}

}
