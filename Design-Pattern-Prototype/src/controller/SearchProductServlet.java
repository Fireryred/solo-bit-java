package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ViewProduct;
import utility.DBUtility;
import utility.PrototypeFactory;

public class SearchProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public SearchProductServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		ViewProduct viewProduct = (ViewProduct) PrototypeFactory.getPrototype("ViewProduct");
		
		ResultSet product = viewProduct.getRecords(DBUtility.SELECTPRODUCT, name);
		request.setAttribute("product", product);
		request.setAttribute("name", name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
	}
}
