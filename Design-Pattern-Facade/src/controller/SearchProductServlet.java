package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.database.CreateTable;
import model.database.InsertTable;
import model.database.ViewTable;
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
		CreateTable createTable = (CreateTable) PrototypeFactory.getPrototype("CreateTable");
		InsertTable insertProduct = (InsertTable) PrototypeFactory.getPrototype("InsertTable");
		ViewTable viewProduct = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		
		ResultSet records = viewProduct.getRecords(DBUtility.SELECTALLPRODUCTS);
		
		createTable.createTable(DBUtility.CREATETABLEPRODUCT);
		createTable.createTable(DBUtility.CREATETABLEPRODUCTDETAILS);
		
		if (records == null) {
			insertProduct.insertRecord(DBUtility.INSERTPRODUCT, "HP Chromebook 14", "https://cdn.mos.cms.futurecdn.net/g3wPJLSxNpGnv9PZGLHomH-970-80.jpg.webp", 17850.00);
			insertProduct.insertRecord(DBUtility.INSERTPRODUCT, "HP Elite Dragonfly", "https://cdn.mos.cms.futurecdn.net/347jbCQnSqziigoDYZssr9-970-80.jpg.webp", 81440.00);
			insertProduct.insertRecord(DBUtility.INSERTPRODUCT, "HP Envy x360 1040", "https://cdn.mos.cms.futurecdn.net/j6ndSR6hKav95QT83beRB4-970-80.jpg.webp", 54995.00);
			insertProduct.insertRecord(DBUtility.INSERTPRODUCT, "HP Omen 15", "https://cdn.mos.cms.futurecdn.net/YWCwFSLwSi3CPGrvkjqd2Q-970-80.jpg.webp", 67990.00);
			insertProduct.insertRecord(DBUtility.INSERTPRODUCT, "HP Spectre x360", "https://cdn.mos.cms.futurecdn.net/BWsKGDUhVnQCYUykJSmHxK-970-80.jpg.webp", 79990.00);
			insertProduct.insertRecord(DBUtility.INSERTPRODUCTDETAILS, 1, "Intel Celeron");
			insertProduct.insertRecord(DBUtility.INSERTPRODUCTDETAILS, 2, "Intel i7");
			insertProduct.insertRecord(DBUtility.INSERTPRODUCTDETAILS, 3, "Intel i5");
			insertProduct.insertRecord(DBUtility.INSERTPRODUCTDETAILS, 4, "Intel i7");
			insertProduct.insertRecord(DBUtility.INSERTPRODUCTDETAILS, 5, "Intel i7");
		}
		
		ResultSet product = viewProduct.getRecords(DBUtility.SELECTPRODUCT, name);
		request.setAttribute("product", product);
		request.setAttribute("name", name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
		
	}
}
