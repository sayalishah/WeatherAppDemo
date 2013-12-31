package com.example.weatherappdemo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WeatherInfo implements Serializable {
	private Integer weatherInfoId;
	private String weatherInfoMain;
	private String weatherInfoDescription;
	private String weatherInfoIcon;

	public Integer getWeatherInfoId() {
		return weatherInfoId;
	}

	public void setWeatherInfoId(Integer weatherInfoId) {
		this.weatherInfoId = weatherInfoId;
	}

	public String getWeatherInfoMain() {
		return weatherInfoMain;
	}

	public void setWeatherInfoMain(String weatherInfoMain) {
		this.weatherInfoMain = weatherInfoMain;
	}

	public String getWeatherInfoDescription() {
		return weatherInfoDescription;
	}

	public void setWeatherInfoDescription(String weatherInfoDescription) {
		this.weatherInfoDescription = weatherInfoDescription;
	}

	public String getWeatherInfoIcon() {
		return weatherInfoIcon;
	}

	public void setWeatherInfoIcon(String weatherInfoIcon) {
		this.weatherInfoIcon = weatherInfoIcon;
	}

	@Override
	public String toString() {
		return "WeatherInfo weatherInfoId=" + weatherInfoId
				+ ", weatherInfoMain=" + weatherInfoMain
				+ ", weatherInfoDescription=" + weatherInfoDescription
				+ ", weatherInfoIcon=" + weatherInfoIcon;
	}

}
