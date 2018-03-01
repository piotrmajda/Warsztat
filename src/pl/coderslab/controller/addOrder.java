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
import pl.coderslab.entity.orders;

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
		
		
		
		String plannedStartDate = request.getParameter("plannedStartDate");
		String problemDesc = request.getParameter("problemDesc");
		int clientId = Integer.parseInt(request.getParameter("clientId"));
		String status = request.getParameter("status");
		
		orders newOrder = new orders(plannedStartDate, problemDesc, clientId, status);
		ordersDao.ordersAdd(newOrder);
		
doGet(request, response);
	}

}
