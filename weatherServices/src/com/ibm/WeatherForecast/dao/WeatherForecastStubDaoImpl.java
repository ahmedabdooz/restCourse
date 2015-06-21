package com.ibm.WeatherForecast.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.ibm.WeatherForecast.model.Location;
import com.ibm.WeatherForecast.model.Observation;

public class WeatherForecastStubDaoImpl implements WeatherForecastDao {

	static final Map<Location, Observation> weatherForecastMap = new HashMap<Location, Observation>();
	static {
		weatherForecastMap.put(new Location(1, "Giza"), new Observation(1, 31,
				"warm"));
		weatherForecastMap.put(new Location(2, "Cairo"), new Observation(2, 28,
				"cloudy"));
		weatherForecastMap.put(new Location(3, "Alexandria"), new Observation(
				3, 25, "rainy"));
		weatherForecastMap.put(new Location(4, "Aswan"), new Observation(4, 37,
				"sunny"));
	}

	@Override
	public Set<Location> getAllLocations() {

		return weatherForecastMap.keySet();

	}
	
	@Override
	public Observation getObservation(int LocationId) {
		Iterator it = weatherForecastMap.entrySet().iterator();
		Observation observation = null;
		while (it.hasNext()) {
			Map.Entry<Location, Observation> weatherForecast = (Map.Entry<Location, Observation>) it
					.next();
			if (LocationId == weatherForecast.getKey().getId()) {
				observation =  weatherForecast.getValue();
				break;
			}
			else{
				observation =  null;
			}
		}
		return observation;
	}
}
