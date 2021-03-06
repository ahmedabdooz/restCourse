package com.ibm.WeatherForecast.services;


import java.util.Set;

import com.ibm.WeatherForecast.dao.WeatherForecastDao;
import com.ibm.WeatherForecast.dao.WeatherForecastJDBCDaoImpl;
import com.ibm.WeatherForecast.dao.WeatherForecastStubDaoImpl;
import com.ibm.WeatherForecast.model.Location;
import com.ibm.WeatherForecast.model.Observation;

public class WeatherForecastServiceImpl implements WeatherForecastService{

	@Override
	public Set<Location> getAllLocations() {
		
		WeatherForecastDao weatherForecastDao = new WeatherForecastJDBCDaoImpl() ;
		
		return weatherForecastDao.getAllLocations();
	}

	@Override
	public Observation getObservation(int LocationId) {
		
		WeatherForecastDao weatherForecastDao = new WeatherForecastJDBCDaoImpl() ;
		
		return weatherForecastDao.getObservation(LocationId);
	}

}
