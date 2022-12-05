package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DbService;
import tables.Musician;


@WebServlet("/AddMusician")
//This class handles adding an musician operation
public class AddMusician extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddMusician() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/AddMusician.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int ssn = (Integer.parseInt(request.getParameter("ssn")));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		//make a new musician
		Musician entry = new Musician();
		entry.setSsn(ssn);
		entry.setName(name);
		entry.setPhone(phone);
		entry.setAddress(address);
		
		//insert data into database
        DbService dbService = new DbService();
        dbService.addMusician(entry);
        //send back to musicians page
		response.sendRedirect("DisplayMusicians");
	}

}