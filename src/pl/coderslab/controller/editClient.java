package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.clientsDao;
import pl.coderslab.entity.clients;

/**
 * Servlet implementation class editClient
 */
@WebServlet("/editClient")
public class editClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String mail = request.getParameter("mail");
		String phoneWork = request.getParameter("phone");
		int phone;
		try
		{
			if(phoneWork != null){
			      phone = Integer.parseInt(phoneWork);
			}else {
				phone = 0;
			}
		}catch (NumberFormatException e)
		{
		    phone = 0;
		
			
		
		}

		int id = Integer.parseInt(request.getParameter("id"));
		
		
		clients editClient = new clients(id, name, surname, mail, phone);
		clientsDao.clientsEdit(editClient);
		

		List<clients> clients= clientsDao.listClients();
		request.setAttribute("clients", clients);
		getServletContext()
			.getRequestDispatcher("/WEB-INF/views/showClientsList.jsp")
			.forward(request, response);
		
doGet(request, response);
	}
	
}
