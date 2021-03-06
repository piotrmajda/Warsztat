package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.clientsDao;
import pl.coderslab.dao.employeesDao;
import pl.coderslab.dao.ordersDao;
import pl.coderslab.dao.vehiclesDao;
import pl.coderslab.entity.clients;
import pl.coderslab.entity.employees;
import pl.coderslab.entity.orders;
import pl.coderslab.entity.vehicles;

/**
 * Servlet implementation class deleteOrder
 */
@WebServlet("/deleteOrder")
public class deleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteOrder() {
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
			ordersDao.ordersDel(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		List<vehicles> vehicles= vehiclesDao.listVehicles();
		request.setAttribute("vehicles", vehicles);
		List<employees> employees= employeesDao.listEmployees();
		request.setAttribute("employees", employees);
		List<orders> orders= ordersDao.listOrders();
		request.setAttribute("orders", orders);
		List<clients> clients= clientsDao.listClients();
		request.setAttribute("clients", clients);
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/showOrdersList.jsp")
		.forward(request, response);
	}

}

