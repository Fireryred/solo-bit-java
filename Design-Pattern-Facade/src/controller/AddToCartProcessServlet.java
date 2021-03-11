package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

public class AddToCartProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AddToCartProcessServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int qty = Integer.parseInt(request.getParameter("qty"));
		String username = (String) request.getSession().getAttribute("username");
		
		Product product = new Product(name, qty, username);
		
		product.process();
		request.setAttribute("hasOrdered", product.getHasOrdered());
		
		response.sendRedirect("product.action?name=" + product.getName());
	}
}