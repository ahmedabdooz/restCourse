package com.ibm.WeatherForecast.dao;

import java.util.Set;
import com.ibm.WeatherForecast.model.Location;
import com.ibm.WeatherForecast.model.Observation;

public interface WeatherForecastDao {
	

	Set<Location> getAllLocations();

	Observation getObservation(int LocationId);

}
