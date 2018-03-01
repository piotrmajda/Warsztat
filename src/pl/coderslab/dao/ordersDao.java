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

//	static public List<orders> listOrders() {
//		List<orders> orders = new ArrayList<>();
//		try {
//			Connection c = DbUtil.getConn();
//
//			PreparedStatement query = c.prepareStatement("SELECT * FROM clients");
//			ResultSet rs = query.executeQuery();
//
//			while (rs.next()) {
//				clients client = new clients( rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
//				client.setId(rs.getInt(1));
//				clients.add(client);
//			}
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return clients;
//
//	}
//	
//	static public boolean clientsDel(int id) throws Exception {
//		try {
//			Connection c = DbUtil.getConn();
//
//			PreparedStatement query = c.prepareStatement("DELETE FROM clients WHERE ID=?");
//			query.setInt(1, id);
//
//			query.executeUpdate();
//			
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return true;
//
//	}
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

