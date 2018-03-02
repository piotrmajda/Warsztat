package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.clientsDao;
import pl.coderslab.dao.vehiclesDao;
import pl.coderslab.entity.clients;
import pl.coderslab.entity.vehicles;

/**
 * Servlet implementation class addVehicle
 */
@WebServlet("/addVehicle")
public class addVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addVehicle() {
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
		.getRequestDispatcher("/WEB-INF/views/addVehicle.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");

		String prodYearWork = request.getParameter("prodYear");
		int prodYear;
		try
		{
			if(prodYearWork != null){
				prodYear = Integer.parseInt(prodYearWork);
			}else {
				prodYear = 0;
			}
		}catch (NumberFormatException e)
		{
			prodYear = 0;
		}
		String regNum = request.getParameter("regNum");
		String nextService = request.getParameter("nextService");
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
		vehicles newVehicle = new vehicles(brand, model, prodYear, regNum, nextService, clientId);
		vehiclesDao.vehiclesAdd(newVehicle);
		
doGet(request, response);
	}

}
