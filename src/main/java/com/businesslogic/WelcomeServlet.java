package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WelcomeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // putting false into session means that if a session is not created do not create one. true creates one.
		HttpSession session = request.getSession(false);
		String uname = (String)session.getAttribute("Username");  // getAttribute gets the name from loginValidation. This has to be type cast.
		PrintWriter out = response.getWriter();
		out.println("Welcome " + uname);
		// this is another way to create a link to another page instead of using RequestDispatcher
		out.println("<a href=\"LogoutServlet\">Log out</a>");
	}
}
