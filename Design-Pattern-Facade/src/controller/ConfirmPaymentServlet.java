package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreditCard;
import model.Product;
import model.Receipt;
import model.database.UpdateTable;
import model.database.ViewTable;
import utility.DBUtility;
import utility.PrototypeFactory;

public class ConfirmPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String creditCard = request.getParameter("creditCardNumber");
		creditCard = creditCard.replaceAll("[^\\d.]", "");
		
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		
		String username = (String) request.getSession().getAttribute("username");
		double sum = 0;
		
		Product product = new Product(username);
		product.process();
		
		ViewTable viewTable = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		ResultSet records = viewTable.getRecords(DBUtility.SELECTORDERS, product.getOrderId());
		
		UpdateTable updateTable = (UpdateTable) PrototypeFactory.getPrototype("UpdateTable");
		
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
		
		CreditCard card = new CreditCard(creditCard, year, month);
		RequestDispatcher dispatcher;
		
		card.process();
		System.out.println(card.getIsInvalidCC());
		System.out.println(card.getIsInvalidExp());
		if (card.getIsInvalidCC() != null || card.getIsInvalidExp() != null) {
			request.setAttribute("card", card);
			dispatcher = request.getRequestDispatcher("checkout.jsp");
		} else {
			String email = null;
			
			//just to get userId
			int userId = 0;
			ResultSet record = viewTable.getRecords(DBUtility.SELECTUSERNAME, username);
			
			try {
				if(record.next()) {
					userId = record.getInt("id");
					email = record.getString("email");
				}
				record.beforeFirst();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//end of getting userId
			ServletContext context = request.getServletContext();
			
			Receipt receipt = new Receipt(records, product.getOrderId(), email, context);
			receipt.process();
			
			updateTable.updateTable(DBUtility.UPDATEORDER, true, userId);
			dispatcher = request.getRequestDispatcher("order-successful.jsp");
		}
		dispatcher.forward(request, response);
	}
}
