package com.example.weatherappdemo;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class City implements Serializable {

	private Integer cityZoom;
	private String cityCountry;
	private Long cityPopulation;
	private Integer cityId;
	private String cityName;
	private ArrayList<String> cityList;

	public City() {
		super();
		// TODO Auto-generated constructor stub
		cityList = new ArrayList<String>();
	}

	public Integer getCityZoom() {
		return cityZoom;
	}

	public void setCityZoom(Integer cityZoom) {
		this.cityZoom = cityZoom;
	}

	public String getCityCountry() {
		return cityCountry;
	}

	public void setCityCountry(String cityCountry) {
		this.cityCountry = cityCountry;
	}

	public Long getCityPopulation() {
		return cityPopulation;
	}

	public void setCityPopulation(Long cityPopulation) {
		this.cityPopulation = cityPopulation;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public ArrayList<String> getCityList() {
		return cityList;
	}

	public void setCityList(ArrayList<String> cityList) {
		this.cityList = cityList;
	}

	public void addToList(String temp) {
		this.cityList.add(temp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cityList.size(); i++) {
			sb.append(cityList.get(i) + ",");
		}

		return "City cityZoom=" + cityZoom + ", cityCountry=" + cityCountry
				+ ", cityPopulation=" + cityPopulation + ", cityId=" + cityId
				+ ", cityName=" + cityName + ", cityList=" + sb.toString()
				+ " ";
	}

}
