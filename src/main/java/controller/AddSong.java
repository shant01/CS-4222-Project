package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DbService;
import tables.Musician;
import tables.Song;


@WebServlet("/AddSong")
//This class handles adding a song operation
public class AddSong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddSong() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/AddSong.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int mus_ssn = Integer.parseInt(request.getParameter("mus_ssn"));
		String album_id = request.getParameter("album_id");
		
		//make a new Song
		Song entry = new Song();
		//check if song is an an album
		if (album_id.equals("")) {
			album_id = null;
			entry.setAlbum_id(null);
		}
		else {
			entry.setAlbum_id(Integer.valueOf(album_id));
		}
		entry.setTitle(title);
		entry.setAuthor(author);
		entry.setMus_ssn(mus_ssn);
		
		//insert data into database
        DbService dbService = new DbService();
        dbService.addSong(entry);
        //send back to songs page
		response.sendRedirect("DisplaySongs");
	}

}