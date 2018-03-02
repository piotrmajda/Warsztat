package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.vehicles;
import pl.coderslab.service.DbUtil;

public class vehiclesDao {
	// add new client
	static public vehicles vehiclesAdd(vehicles newVehicle) {
		try {
			Connection c = DbUtil.getConn();
			PreparedStatement query;
			if (newVehicle.getProdYear() > 0 && newVehicle.getClientId() > 0) {
				query = c.prepareStatement("INSERT INTO vehicle VALUES(default, ?, ?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				query.setString(1, newVehicle.getBrand());
				query.setString(2, newVehicle.getModel());
				query.setInt(3, newVehicle.getProdYear());
				query.setString(4, newVehicle.getRegNum());
				query.setString(5, newVehicle.getNextService());
				query.setInt(6, newVehicle.getClientId());
			} else if (newVehicle.getProdYear() > 0) {
				query = c.prepareStatement(
						"INSERT INTO vehicle(id, brand, model, profYear, regNum, nextService) VALUES(default, ?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				query.setString(1, newVehicle.getBrand());
				query.setString(2, newVehicle.getModel());
				query.setInt(3, newVehicle.getProdYear());
				query.setString(4, newVehicle.getRegNum());
				query.setString(5, newVehicle.getNextService());
			} else {
				query = c.prepareStatement(
						"INSERT INTO vehicle(id, brand, model, regNum, nextService, clientId) VALUES(default, ?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				query.setString(1, newVehicle.getBrand());
				query.setString(2, newVehicle.getModel());
				query.setString(3, newVehicle.getRegNum());
				query.setString(4, newVehicle.getNextService());
				query.setInt(5, newVehicle.getClientId());

			}

			query.executeUpdate();
			ResultSet rs = query.getGeneratedKeys();
			if (rs.next()) {
				newVehicle.setId(rs.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return newVehicle;
	}

	// show list of all clients
	static public List<vehicles> listVehicles() {
		List<vehicles> vehicles = new ArrayList<>();
		try {
			Connection c = DbUtil.getConn();

			PreparedStatement query = c.prepareStatement("SELECT * FROM vehicle");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				vehicles vehicle = new vehicles(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				vehicle.setId(rs.getInt(1));
				vehicles.add(vehicle);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vehicles;

	}

	// delete client from db
	static public boolean vehiclesDel(int id) throws Exception {
		try {
			Connection c = DbUtil.getConn();

			PreparedStatement query = c.prepareStatement("DELETE FROM vehicle WHERE ID=?");
			query.setInt(1, id);

			query.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return true;

	}
	// edit client

	static public vehicles vehiclesEdit(vehicles editVehicle) {
		try {
			Connection c = DbUtil.getConn();
			PreparedStatement query = c.prepareStatement(
					"UPDATE vehicle SET brand = ?, model = ?, prodYear = ?, regNum= ?, nextService = ?, clientId =? WHERE id = ?");
			query.setString(1, editVehicle.getBrand());
			query.setString(2, editVehicle.getModel());
			query.setInt(3, editVehicle.getProdYear());
			query.setString(4, editVehicle.getRegNum());
			query.setString(5, editVehicle.getNextService());
			query.setInt(6, editVehicle.getClientId());
			query.setInt(7, editVehicle.getId());

			query.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return editVehicle;
	}

}
