package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DbService;
import tables.Album;


@WebServlet("/AddAlbum")

//This class handles adding an album operation
public class AddAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddAlbum() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/AddAlbum.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int idno = (Integer.parseInt(request.getParameter("idno")));
		String title = request.getParameter("title");
		Date copyright_date = Date.valueOf(request.getParameter("copyright_date"));
		String format = request.getParameter("format");
		int album_id = (Integer.parseInt(request.getParameter("idno")));
		int prod_ssn = (Integer.parseInt(request.getParameter("prod_ssn")));
		
		//make a new album
		Album entry = new Album();
		entry.setIdno(idno);
		entry.setTitle(title);
		entry.setCopyright_date(copyright_date);
		entry.setFormat(format);
		entry.setAlbum_id(album_id);
		entry.setProd_ssn(prod_ssn);
		
		//insert data into database
        DbService dbService = new DbService();
        dbService.addAlbum(entry);
        //send back to albums page
		response.sendRedirect("DisplayAlbums");
	}

}