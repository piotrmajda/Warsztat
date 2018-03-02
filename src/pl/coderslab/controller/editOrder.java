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
 * Servlet implementation class editOrder
 */
@WebServlet("/editOrder")
public class editOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String orderDate = request.getParameter("orderDate");
		String startDate = request.getParameter("startDate");
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
		String repairDesc = request.getParameter("repairDesc");
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
		String generalCostWork = request.getParameter("generalCost");
			double generalCost;
			try
			{
				if(generalCostWork != null){
					generalCost = Double.parseDouble(generalCostWork);
				}else {
					generalCost = 0;
				}
			}catch (NumberFormatException e)
			{
				generalCost = 0;
			}		
		String partsCostWork = request.getParameter("partsCost");
			double partsCost;
			try
			{
				if(partsCostWork != null){
					partsCost = Double.parseDouble(partsCostWork);
				}else {
					partsCost = 0;
				}
			}catch (NumberFormatException e)
			{
				partsCost = 0;
			}		
		String employeeHoursWork = request.getParameter("employeeHours");
			double employeeHours;
			try
			{
				if(employeeHoursWork != null){
					employeeHours = Double.parseDouble(employeeHoursWork);
				}else {
					employeeHours = 0;
				}
			}catch (NumberFormatException e)
			{
				employeeHours = 0;
			}	
		String employeeHourlyRateWork = request.getParameter("employeeHourlyRate");
			double employeeHourlyRate;
			try
			{
				if(employeeHourlyRateWork != null){
					employeeHourlyRate = Double.parseDouble(employeeHourlyRateWork);
				}else {
					employeeHourlyRate = 0;
				}
			}catch (NumberFormatException e)
			{
				employeeHourlyRate = 0;
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
		String plannedStartDate = request.getParameter("plannedStartDate");	
		String status = request.getParameter("status");		
		int id = Integer.parseInt(request.getParameter("id"));
		
		orders editOrder = new orders(id, orderDate, startDate, employeeId, problemDesc, repairDesc, vehicleId, generalCost, partsCost, employeeHours, employeeHourlyRate, clientId, plannedStartDate, status);
		ordersDao.ordersEdit(editOrder);
		
		
		
		
		
		
		

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
