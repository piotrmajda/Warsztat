package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.clients;
import pl.coderslab.service.DbUtil;

public class clientsDao {
	
	static public clients clientsAdd(clients newClient) {
		try {
			Connection c = DbUtil.getConn();
			PreparedStatement query = c.prepareStatement("INSERT INTO clients VALUES(default, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			query.setString(1, newClient.getName());
			query.setString(2, newClient.getSurname());
			query.setString(3, newClient.getMail());
			query.setInt(4, newClient.getPhone());

			query.executeUpdate();
			ResultSet rs = query.getGeneratedKeys();
			if (rs.next()) {
				newClient.setId(rs.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(newClient.getId());
		return newClient;
	}

	static public List<clients> listClients() {
		List<clients> clients = new ArrayList<>();
		try {
			Connection c = DbUtil.getConn();

			PreparedStatement query = c.prepareStatement("SELECT * FROM clients");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				clients client = new clients( rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				client.setId(rs.getInt(1));
				clients.add(client);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return clients;

	}
	
	static public boolean clientsDel(int id) throws Exception {
		try {
			Connection c = DbUtil.getConn();

			PreparedStatement query = c.prepareStatement("DELETE FROM clients WHERE ID=?");
			query.setInt(1, id);

			query.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return true;

	}
	

}

