package com.example.weatherappdemo;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DailyWeather implements Serializable {

	private ArrayList<WeatherInfo> dailyWeatherInfoList;
	private String dailyWeatherbase;
	private MainInfo dailyWeatherMainInfo;

	private Double dailyWeatherWindSpeed;

	private Integer dailyWeatherWindHumidity;

	private Integer dailyWeatherRainh;

	private Integer dailyWeatherCloudsAll;

	private City dailyWeatherCity;
	private Long dailyWeatherDt;

	public DailyWeather() {
		super();
		dailyWeatherInfoList = new ArrayList<WeatherInfo>();
	}

	public ArrayList<WeatherInfo> getDailyWeatherInfo() {
		return dailyWeatherInfoList;
	}

	public void setDailyWeatherInfo(ArrayList<WeatherInfo> dailyWeatherInfo) {
		this.dailyWeatherInfoList = dailyWeatherInfo;
	}

	public void addWeatherInfoToList(WeatherInfo weatherInfo) {
		this.dailyWeatherInfoList.add(weatherInfo);
	}

	public String getDailyWeatherbase() {
		return dailyWeatherbase;
	}

	public void setDailyWeatherbase(String dailyWeatherbase) {
		this.dailyWeatherbase = dailyWeatherbase;
	}

	public MainInfo getDailyWeatherMainInfo() {
		return dailyWeatherMainInfo;
	}

	public void setDailyWeatherMainInfo(MainInfo dailyWeatherMainInfo) {
		this.dailyWeatherMainInfo = dailyWeatherMainInfo;
	}

	public Double getDailyWeatherWindSpeed() {
		return dailyWeatherWindSpeed;
	}

	public void setDailyWeatherWindSpeed(Double dailyWeatherWindSpeed) {
		this.dailyWeatherWindSpeed = dailyWeatherWindSpeed;
	}

	public Integer getDailyWeatherWindHumidity() {
		return dailyWeatherWindHumidity;
	}

	public void setDailyWeatherWindHumidity(Integer dailyWeatherWindHumidity) {
		this.dailyWeatherWindHumidity = dailyWeatherWindHumidity;
	}

	public Integer getDailyWeatherRainh() {
		return dailyWeatherRainh;
	}

	public void setDailyWeatherRainh(Integer dailyWeatherRainh) {
		this.dailyWeatherRainh = dailyWeatherRainh;
	}

	public Integer getDailyWeatherCloudsAll() {
		return dailyWeatherCloudsAll;
	}

	public void setDailyWeatherCloudsAll(Integer dailyWeatherCloudsAll) {
		this.dailyWeatherCloudsAll = dailyWeatherCloudsAll;
	}

	public City getDailyWeatherCity() {
		return dailyWeatherCity;
	}

	public void setDailyWeatherCity(City dailyWeatherCity) {
		this.dailyWeatherCity = dailyWeatherCity;
	}

	public Long getDailyWeatherDt() {
		return dailyWeatherDt;
	}

	public void setDailyWeatherDt(Long dailyWeatherDt) {
		this.dailyWeatherDt = dailyWeatherDt;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dailyWeatherInfoList.size(); i++) {
			sb.append(dailyWeatherInfoList.get(i).toString() + ",");
		}

		return "DailyWeather dailyWeatherInfoList=" + sb.toString()
				+ "  dailyWeatherbase=" + dailyWeatherbase
				+ ", dailyWeatherMainInfo=" + dailyWeatherMainInfo
				+ ", dailyWeatherWindSpeed=" + dailyWeatherWindSpeed
				+ ", dailyWeatherWindHumidity=" + dailyWeatherWindHumidity
				+ ", dailyWeatherRainh=" + dailyWeatherRainh
				+ ", dailyWeatherCloudsAll=" + dailyWeatherCloudsAll
				+ ", dailyWeatherCity=" + dailyWeatherCity
				+ ", dailyWeatherDt=" + dailyWeatherDt;
	}

}
