package com.example.weatherappdemo;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class WeatherDetailInfo implements Serializable {

	private String weatherDetailMessage;
	private Integer weatherDetailCityId;
	private Integer weatherDetailCnt;

	private ArrayList<DailyWeather> dailyWeatherList;

	public WeatherDetailInfo() {
		super();
		dailyWeatherList = new ArrayList<DailyWeather>();
		// TODO Auto-generated constructor stub
	}

	public String getWeatherDetailMessage() {
		return weatherDetailMessage;
	}

	public void setWeatherDetailMessage(String weatherDetailMessage) {
		this.weatherDetailMessage = weatherDetailMessage;
	}

	public Integer getWeatherDetailCityId() {
		return weatherDetailCityId;
	}

	public void setWeatherDetailCityId(Integer weatherDetailCityId) {
		this.weatherDetailCityId = weatherDetailCityId;
	}

	public Integer getWeatherDetailCnt() {
		return weatherDetailCnt;
	}

	public void setWeatherDetailCnt(Integer weatherDetailCnt) {
		this.weatherDetailCnt = weatherDetailCnt;
	}

	public ArrayList<DailyWeather> getDailyWeatherList() {
		return dailyWeatherList;
	}

	public void setDailyWeatherList(ArrayList<DailyWeather> dailyWeatherList) {
		this.dailyWeatherList = dailyWeatherList;
	}

	public void addToList(DailyWeather dailyWeather) {
		this.dailyWeatherList.add(dailyWeather);
	}

}
