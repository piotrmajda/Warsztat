package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.employees;
import pl.coderslab.service.DbUtil;

public class employeesDao {
	//add new client
		static public employees employeesAdd(employees newEmployee) {
			try {
				Connection c = DbUtil.getConn();
				PreparedStatement query = c.prepareStatement("INSERT INTO employees VALUES(default, ?, ?, ?, ?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
					query.setString(1, newEmployee.getName());
					query.setString(2, newEmployee.getSurname());
					query.setString(3, newEmployee.getAddress());
					if(newEmployee.getPhone() > 0){
						query.setInt(4, newEmployee.getPhone());						
					}
					else {
						query.setNull(4, java.sql.Types.INTEGER);
					}
					query.setString(5, newEmployee.getNote());
					if(newEmployee.getEmployee_hours() > 0){
						query.setDouble(6, newEmployee.getEmployee_hours());
					}
					else{
						query.setNull(6, java.sql.Types.DOUBLE);
					}
									

				query.executeUpdate();
				ResultSet rs = query.getGeneratedKeys();
				if (rs.next()) {
					newEmployee.setId(rs.getInt(1));
				}
				c.close(); 

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return newEmployee;
		}
	//show list of all clients
		static public List<employees> listEmployees() {
			List<employees> employees = new ArrayList<>();
			try {
				Connection c = DbUtil.getConn();

				PreparedStatement query = c.prepareStatement("SELECT * FROM employees");
				ResultSet rs = query.executeQuery();

				while (rs.next()) {
					employees employee = new employees( rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getDouble(7));
					employee.setId(rs.getInt(1));
					employees.add(employee);
				}
				c.close(); 

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return employees;

		}
	//delete client from db
		static public boolean employeesDel(int id) throws Exception {
			try {
				Connection c = DbUtil.getConn();

				PreparedStatement query = c.prepareStatement("DELETE FROM employees WHERE ID=?");
				query.setInt(1, id);

				query.executeUpdate();

				c.close(); 

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return true;

		}
	// edit client	
		
		static public employees employeesEdit(employees editEmployees) {
			try {
				Connection c = DbUtil.getConn();
				PreparedStatement query = c.prepareStatement("UPDATE employees SET name = ?, surname = ?, address = ?, phone= ?, note = ?, employee_hours = ? WHERE id = ?");
					query.setString(1, editEmployees.getName());
					query.setString(2, editEmployees.getSurname());
					query.setString(3, editEmployees.getAddress());
					query.setInt(4, editEmployees.getPhone());
					query.setString(5, editEmployees.getNote());
					query.setDouble(6, editEmployees.getEmployee_hours());					
					query.setInt(7, editEmployees.getId());

				query.executeUpdate();
				c.close(); 

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return editEmployees;
		}
		

	}

