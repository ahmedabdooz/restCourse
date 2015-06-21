package com.ibm.WeatherForecast.test;

import java.util.Set;

import com.ibm.WeatherForecast.model.Location;
import com.ibm.WeatherForecast.model.Observation;
import com.ibm.WeatherForecast.services.WeatherForecastService;
import com.ibm.WeatherForecast.services.WeatherForecastServiceImpl;

public class weatherForecastTest {

	
	public static void main(String[] args) {
		
		WeatherForecastService WeatherForecastService = new WeatherForecastServiceImpl();
		
		
		Set<Location>  locations = WeatherForecastService.getAllLocations();
		
		for(Location location: locations){
			System.out.println("Location ID: "+location.getId()+" , Locatio City: "+ location.getCity());
		}
		
		Observation observation = WeatherForecastService.getObservation(1);
		System.out.println("Obeservation ID: "+observation.getId());
		System.out.println("Obeservation Tempreture: "+observation.getTempreture());
		System.out.println("Obeservation Weather: "+observation.getWeather());
	}

}
