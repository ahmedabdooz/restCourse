package com.ibm.WeatherForecast.services;

import java.util.Set;

import com.ibm.WeatherForecast.model.Location;
import com.ibm.WeatherForecast.model.Observation;

public interface WeatherForecastService {
	
	Set<Location> getAllLocations();

	Observation getObservation(int LocationId);

}
