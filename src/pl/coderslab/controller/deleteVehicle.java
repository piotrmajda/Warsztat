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
 * Servlet implementation class deleteVehicle
 */
@WebServlet("/deleteVehicle")
public class deleteVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteVehicle() {
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
			vehiclesDao.vehiclesDel(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		List<vehicles> vehicles= vehiclesDao.listVehicles();
		request.setAttribute("vehicles", vehicles);
		List<clients> clients= clientsDao.listClients();
		request.setAttribute("clients", clients);
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/showVehiclesList.jsp")
		.forward(request, response);
	}

}
