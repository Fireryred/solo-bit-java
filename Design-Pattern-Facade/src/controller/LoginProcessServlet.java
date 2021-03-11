package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.getSession().invalidate();
		User user = new User(username, password);
		
		user.process();
		request.setAttribute("user", user);
		
		request.getSession().setAttribute("username", username);
		RequestDispatcher dispatcher = request.getRequestDispatcher(user.getWebsite());
		dispatcher.forward(request, response);
	}
}
