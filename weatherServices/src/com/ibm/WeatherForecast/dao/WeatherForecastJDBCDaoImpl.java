package com.ibm.WeatherForecast.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import com.ibm.WeatherForecast.model.Location;
import com.ibm.WeatherForecast.model.Observation;

public class WeatherForecastJDBCDaoImpl implements WeatherForecastDao {

	private static final String DB_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "admin";

	@Override
	public Set<Location> getAllLocations() {

		Set<Location> locations = new HashSet<Location>();
		Connection dbConnection = null;
		Statement stmt = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			String query = "select * from  weatherforecast.location";

			stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Location location = new Location();
				location.setId(rs.getInt("id"));
				location.setCity(rs.getString("city"));
				locations.add(location);
				System.out.println(location.getId() + "\t" + location.getCity() + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return locations;
	}

	@Override
	public Observation getObservation(int locationId) {
		Observation observation = new Observation();
		Connection dbConnection = null;
		Statement stmt = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			String query = "select * from  weatherforecast.observation where location_id="+locationId;

			stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				
				observation.setId(rs.getInt("id"));
				observation.setTempreture(rs.getInt("tempreture"));
				observation.setWeather(rs.getString("weather"));
				
				System.out.println(observation.getId() + "\t" + observation.getTempreture() + "\t"+observation.getWeather()+ "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return observation;
	}

}
