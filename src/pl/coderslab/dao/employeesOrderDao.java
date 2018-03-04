package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.orders;
import pl.coderslab.service.DbUtil;

public class employeesOrderDao {

	static public List<orders> listOrders(int id) {
		List<orders> orders = new ArrayList<>();
		try {
			Connection c = DbUtil.getConn();

			PreparedStatement query = c.prepareStatement("SELECT * FROM orders WHERE status = 'W naprawie' AND employeeId = ?");
			query.setInt(1, id);
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				orders order = new orders( rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getInt(12), rs.getString(13), rs.getString(14));
				order.setId(rs.getInt(1));
				orders.add(order);
			}
			c.close(); 

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return orders;

	}

}
