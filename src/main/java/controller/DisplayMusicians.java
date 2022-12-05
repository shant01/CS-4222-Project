package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DbService;

@WebServlet(urlPatterns = "/DisplayMusicians", loadOnStartup = 1)
//This class handles displaying the musicians
public class DisplayMusicians extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayMusicians() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService dbService = new DbService();
		//give jsps access to the data
    	getServletContext().setAttribute("musicians", dbService.getMusicians());
    	dbService.close();
    	
        request.getRequestDispatcher( "/WEB-INF/DisplayMusicians.jsp" )
            .forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
