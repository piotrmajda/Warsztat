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
			PreparedStatement query = c.prepareStatement("INSERT INTO orders(id, orderDate, plannedStartDate, problemDesc, clientId, status) VALUES(default, NOW(), ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			query.setString(1, newOrder.getPlannedStartDate());
			query.setString(2, newOrder.getProblemDesc());
			query.setInt(3, newOrder.getClientId());
			query.setString(4, newOrder.getStatus());
//			query.setInt(5, newOrder.getVehicleId());
//			query.setInt(6, newOrder.getEmployeeId());
			
			

			query.executeUpdate();
			ResultSet rs = query.getGeneratedKeys();
			
			if (rs.next()) {
				newOrder.setId(rs.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(newOrder.getId());
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
//	
//	static public clients clientsEdit(clients editClient) {
//		try {
//			Connection c = DbUtil.getConn();
//			PreparedStatement query = c.prepareStatement("UPDATE clients SET name = ?, surname = ?, mail = ?, phone= ? WHERE id = ?");
//			query.setString(1, editClient.getName());
//			query.setString(2, editClient.getSurname());
//			query.setString(3, editClient.getMail());
//			query.setInt(4, editClient.getPhone());
//			query.setInt(5, editClient.getId());
//			
//			query.executeUpdate();
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(editClient.getId());
//		return editClient;
//	}
//	
//
}

