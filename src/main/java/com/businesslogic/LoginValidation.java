package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginValidation() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname = request.getParameter("txtUname");
		String pword = request.getParameter("txtPword");
		RequestDispatcher rd;
		
		if (uname.equalsIgnoreCase("java") && pword.equals("eclipse@123")) {
			
			// HttpSession is an interface. It creates a session object that is created by Servlet Container.
			// session id can get got through getId()
			// getSession(true) is creating a session if one is not created already
         	HttpSession session = request.getSession(true); 
         	// this is setting the object uname with the name Username
			session.setAttribute("Username", uname);    // (key, value) 
			rd = request.getRequestDispatcher("WelcomeServlet");  // calls the next servlet page
			rd.forward(request, response);
		}
		else {
			// to print the object to the web browser
			PrintWriter out = response.getWriter();
			// creates a header with invalid username and password
			out.println("<h3> Invalid username and password </h3>");
			// includes the index.html page 
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);  // options are includes or forwards
		}
		
	}

}
