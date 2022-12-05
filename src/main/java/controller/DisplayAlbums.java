package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DbService;

@WebServlet(urlPatterns = "/DisplayAlbums", loadOnStartup = 1)
//This class handles displaying the albums page
public class DisplayAlbums extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayAlbums() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService dbService = new DbService();
		//give jsps access to the data
    	getServletContext().setAttribute("albums", dbService.getAlbums());
    	getServletContext().setAttribute("cd_albums", dbService.getCDAlbum());
    	dbService.close();
    	
        request.getRequestDispatcher( "/WEB-INF/DisplayAlbums.jsp" )
            .forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
