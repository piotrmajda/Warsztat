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
 * Servlet implementation class deleteClient
 */
@WebServlet("/deleteClient")
public class deleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteClient() {
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
		int id = Integer.parseInt(request.getParameter("delId"));

		try {
			clientsDao.clientsDel(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		


		List<clients> clients= clientsDao.listClients();
		request.setAttribute("clients", clients);
		getServletContext()
			.getRequestDispatcher("/WEB-INF/views/showClientsList.jsp")
			.forward(request, response);
	}

}
