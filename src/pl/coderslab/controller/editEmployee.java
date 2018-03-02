package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.employeesDao;
import pl.coderslab.entity.employees;



/**
 * Servlet implementation class editEmployee
 */
@WebServlet("/editEmployee")
public class editEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEmployee() {
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
		
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
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
		String note = request.getParameter("note");
		double employee_hours;
		String employee_hoursWork = request.getParameter("employee_hours");
		employee_hoursWork = employee_hoursWork.replace(",", ".");
		
		try
		{
			if(employee_hoursWork != null){
				employee_hours = Integer.parseInt(employee_hoursWork);
			}else {
				employee_hours = 0;
			}
		}catch (NumberFormatException e)
		{
			employee_hours = 0;
		
		
		}

		int id = Integer.parseInt(request.getParameter("id"));
		
		
		employees editEmployees = new employees(id, name, surname, address, phone, note, employee_hours);
		employeesDao.employeesEdit(editEmployees);
		

		List<employees> employees= employeesDao.listEmployees();
		request.setAttribute("employees", employees);
		getServletContext()
			.getRequestDispatcher("/WEB-INF/views/showEmployeesList.jsp")
			.forward(request, response);
		
doGet(request, response);
	}
	
}
