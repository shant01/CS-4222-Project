package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DbService;

@WebServlet("/DeleteMusician")
//This class handles removing a musician operation
public class DeleteMusician extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteMusician()
	{ 
		super(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//ssn of a musician getting deleted
		int ssn = Integer.parseInt(request.getParameter("ssn"));
		DbService dbService = new DbService();
		dbService.deleteMusician(ssn);
		dbService.close();
		//go back to musicians page
		response.sendRedirect("DisplayMusicians");
	}
}
	
