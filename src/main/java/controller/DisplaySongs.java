package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DbService;

@WebServlet(urlPatterns = "/DisplaySongs", loadOnStartup = 1)
//This class handles displaying the songs
public class DisplaySongs extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplaySongs() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService dbService = new DbService();
		//give jsps access to the data
    	getServletContext().setAttribute("songs", dbService.getSongs());
    	getServletContext().setAttribute("totalsongs", dbService.getTotalSongs());
    	dbService.close();
    	
        request.getRequestDispatcher( "/WEB-INF/DisplaySongs.jsp" )
            .forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
