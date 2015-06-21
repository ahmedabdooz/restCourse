package com.ibm.WeatherForecast.model;

public class Observation {
	
	int id;
	int tempreture;
	String weather;
	
	public Observation() {
		super();
		this.id = 0;
		this.tempreture = 0;
		this.weather = "";
	}
	
	
	public Observation(int id, int tempreture, String weather) {
		super();
		this.id = id;
		this.tempreture = tempreture;
		this.weather = weather;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTempreture() {
		return tempreture;
	}
	public void setTempreture(int tempreture) {
		this.tempreture = tempreture;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}

}
