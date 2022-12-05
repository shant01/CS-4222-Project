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

@WebServlet("/DeleteAlbum")
//This class handles removing an album operation
public class DeleteAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAlbum()
	{ 
		super(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//id of album getting deleted
		int idno = Integer.parseInt(request.getParameter("idno"));
		DbService dbService = new DbService();
		dbService.deleteAlbum(idno);
		dbService.close();
		//send back to albums page
		response.sendRedirect("DisplayAlbums");
	}
}
	
