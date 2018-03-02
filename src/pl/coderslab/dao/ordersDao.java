package pl.coderslab.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.orders;
import pl.coderslab.service.DbUtil;

public class ordersDao {
	
	static public orders ordersAdd(orders newOrder) {
		try {
			Connection c = DbUtil.getConn();
			PreparedStatement query = c.prepareStatement("INSERT INTO orders(id, orderDate, plannedStartDate, employeeId, problemDesc, vehicleId, clientId, status) VALUES(default, NOW(), ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			query.setString(1, newOrder.getPlannedStartDate());
			if(newOrder.getEmployeeId() > 0){
				query.setInt(2, newOrder.getEmployeeId());						
			}
			else {
				query.setNull(2, java.sql.Types.INTEGER);
			}			
			query.setString(3, newOrder.getProblemDesc());
			if(newOrder.getVehicleId() > 0){
				query.setInt(4, newOrder.getVehicleId());						
			}
			else {
				query.setNull(4, java.sql.Types.INTEGER);
			}						
			if(newOrder.getClientId() > 0){
				query.setInt(5, newOrder.getClientId());						
			}
			else {
				query.setNull(5, java.sql.Types.INTEGER);
			}						
			query.setString(6, newOrder.getStatus());
			
			

			query.executeUpdate();
			ResultSet rs = query.getGeneratedKeys();
			
			if (rs.next()) {
				newOrder.setId(rs.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return newOrder;
	}

	static public List<orders> listOrders() {
		List<orders> orders = new ArrayList<>();
		try {
			Connection c = DbUtil.getConn();

			PreparedStatement query = c.prepareStatement("SELECT * FROM orders");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				orders order = new orders( rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getInt(12), rs.getString(13), rs.getString(14));
				order.setId(rs.getInt(1));
				orders.add(order);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return orders;

	}
	
	static public boolean ordersDel(int id) throws Exception {
		try {
			Connection c = DbUtil.getConn();

			PreparedStatement query = c.prepareStatement("DELETE FROM orders WHERE ID=?");
			query.setInt(1, id);

			query.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return true;

	}
	
	static public orders ordersEdit(orders editOrder) {
		try {
			Connection c = DbUtil.getConn();
			PreparedStatement query = c.prepareStatement("UPDATE orders SET orderDate = ?, startDate = ?, employeeId = ?, problemDesc= ?, repairDesc= ?, vehicleId= ?, generalCost= ?, partsCost= ?, employeeHours= ?, employeeHourlyRate= ?, clientId= ?, plannedStartDate= ?, status= ? WHERE id = ?");
			query.setString(1, editOrder.getOrderDate());
			query.setString(2, editOrder.getStartDate());
			if(editOrder.getEmployeeId() > 0){
				query.setInt(3, editOrder.getEmployeeId());						
			}
			else {
				query.setNull(3, java.sql.Types.INTEGER);
			}			
			query.setString(4, editOrder.getProblemDesc());
			query.setString(5, editOrder.getRepairDesc());		
			if(editOrder.getVehicleId() > 0){
				query.setInt(6, editOrder.getVehicleId());						
			}
			else {
				query.setNull(6, java.sql.Types.INTEGER);
			}		
			if(editOrder.getGeneralCost() > 0){
				query.setDouble(7, editOrder.getGeneralCost());						
			}
			else {
				query.setNull(7, java.sql.Types.DOUBLE);
			}
			if(editOrder.getPartsCost() > 0){
				query.setDouble(8, editOrder.getPartsCost());						
			}
			else {
				query.setNull(8, java.sql.Types.DOUBLE);
			}
			if(editOrder.getEmployeeHours() > 0){
				query.setDouble(9, editOrder.getEmployeeHours());						
			}
			else {
				query.setNull(9, java.sql.Types.DOUBLE);
			}
			if(editOrder.getEmployeeHourlyRate() > 0){
				query.setDouble(10, editOrder.getEmployeeHourlyRate());						
			}
			else {
				query.setNull(10, java.sql.Types.DOUBLE);
			}
			if(editOrder.getClientId() > 0){
				query.setInt(11, editOrder.getClientId());						
			}
			else {
				query.setNull(11, java.sql.Types.INTEGER);
			}				
			query.setString(12, editOrder.getPlannedStartDate());
			query.setString(13, editOrder.getStatus());
			query.setInt(14, editOrder.getId());

			
			query.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return editOrder;
	}
	

}

