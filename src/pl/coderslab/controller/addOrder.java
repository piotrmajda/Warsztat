package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.clientsDao;
import pl.coderslab.dao.ordersDao;
import pl.coderslab.entity.clients;

/**
 * Servlet implementation class addOrder
 */
@WebServlet("/addOrder")
public class addOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<clients> clients= clientsDao.listClients();
		request.setAttribute("clients", clients);
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/addOrder.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String mail = request.getParameter("mail");
		
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		clients newOrder = new clients(name, surname, mail, phone);
		ordersDao.clientsAdd(newOrder);
	}

}
