package controller;

import utility.LaptopFactory;
import utility.ProcessorFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.laptop.*;
import model.processor.*;

public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DisplayProductServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		
		HPLaptop laptop = new LaptopFactory().getLaptop(name.toUpperCase());
		request.setAttribute("Laptop", laptop);
		
		
		Processor processor = new ProcessorFactory().getProcessor(name);
		request.setAttribute("Processor", processor);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}