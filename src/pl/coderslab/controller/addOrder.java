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
		List<vehicles> vehicles= vehiclesDao.listVehicles();
		request.setAttribute("vehicles", vehicles);
		List<employees> employees= employeesDao.listEmployees();
		request.setAttribute("employees", employees);		
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/addOrder.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		
		
		String plannedStartDate = request.getParameter("plannedStartDate");
		String employeeIdWork = request.getParameter("employeeId");
			int employeeId;
			try
			{
				if(employeeIdWork != null){
					employeeId = Integer.parseInt(employeeIdWork);
				}else {
					employeeId = 0;
				}
			}catch (NumberFormatException e)
			{
				employeeId = 0;
			}		
		String problemDesc = request.getParameter("problemDesc");
		String vehicleIdWork = request.getParameter("vehicleId");
			int vehicleId;
			try
			{
				if(vehicleIdWork != null){
					vehicleId = Integer.parseInt(vehicleIdWork);
				}else {
					vehicleId = 0;
				}
			}catch (NumberFormatException e)
			{
				vehicleId = 0;
			}	
		String clientIdWork = request.getParameter("clientId");
			int clientId;
			try
			{
				if(clientIdWork != null){
					clientId = Integer.parseInt(clientIdWork);
				}else {
					clientId = 0;
				}
			}catch (NumberFormatException e)
			{
				clientId = 0;
			}				
		String status = request.getParameter("status");
		
		orders newOrder = new orders(plannedStartDate, employeeId, problemDesc, vehicleId, clientId, status);
		ordersDao.ordersAdd(newOrder);
		
doGet(request, response);
	}

}
