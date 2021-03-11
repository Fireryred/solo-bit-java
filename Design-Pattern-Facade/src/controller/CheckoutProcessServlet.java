package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.database.ViewTable;
import utility.DBUtility;
import utility.PrototypeFactory;

public class CheckoutProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		double sum = 0;
		
		Product product = new Product(username);
		product.process();
		
		ViewTable viewTable = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		ResultSet records = viewTable.getRecords(DBUtility.SELECTORDERS, product.getOrderId());
		
		request.setAttribute("records", records);
		
		try {
			while (records.next()) {
				sum += records.getDouble("price") * records.getInt("quantity");
			}
			records.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("sum", sum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
		dispatcher.forward(request, response);
	}

}
