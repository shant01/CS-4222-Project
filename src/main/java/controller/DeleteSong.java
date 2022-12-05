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

@WebServlet("/DeleteSong")
//This class handles removing a song operation
public class DeleteSong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteSong()
	{ 
		super(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//title of song getting deleted
		String title = request.getParameter("title");
		DbService dbService = new DbService();
		dbService.deleteSong(title);
		dbService.close();
		//send back to songs page
		response.sendRedirect("DisplaySongs");
	}
}