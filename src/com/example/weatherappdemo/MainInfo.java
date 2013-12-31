package com.example.weatherappdemo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MainInfo implements Serializable {

	private Double mainInfoTemp;
	private Double mainInfoTempmin;
	private Double mainInfoTempmax;
	private Double mainInfoPressure;
	private Double mainInfoSealevel;
	private Double mainInfoGrandLevel;
	private Integer mainInfoHumidity;

	public Double getMainInfoTemp() {
		return mainInfoTemp;
	}

	public void setMainInfoTemp(Double mainInfoTemp) {
		this.mainInfoTemp = mainInfoTemp;
	}

	public Double getMainInfoTempmin() {
		return mainInfoTempmin;
	}

	public void setMainInfoTempmin(Double mainInfoTempmin) {
		this.mainInfoTempmin = mainInfoTempmin;
	}

	public Double getMainInfoTempmax() {
		return mainInfoTempmax;
	}

	public void setMainInfoTempmax(Double mainInfoTempmax) {
		this.mainInfoTempmax = mainInfoTempmax;
	}

	public Double getMainInfoPressure() {
		return mainInfoPressure;
	}

	public void setMainInfoPressure(Double mainInfoPressure) {
		this.mainInfoPressure = mainInfoPressure;
	}

	public Double getMainInfoSealevel() {
		return mainInfoSealevel;
	}

	public void setMainInfoSealevel(Double mainInfoSealevel) {
		this.mainInfoSealevel = mainInfoSealevel;
	}

	public Double getMainInfoGrandLevel() {
		return mainInfoGrandLevel;
	}

	public void setMainInfoGrandLevel(Double mainInfoGrandLevel) {
		this.mainInfoGrandLevel = mainInfoGrandLevel;
	}

	public Integer getMainInfoHumidity() {
		return mainInfoHumidity;
	}

	public void setMainInfoHumidity(Integer mainInfoHumidity) {
		this.mainInfoHumidity = mainInfoHumidity;
	}

	@Override
	public String toString() {
		return "MainInfo mainInfoTemp=" + mainInfoTemp + ", mainInfoTempmin="
				+ mainInfoTempmin + ", mainInfoTempmax=" + mainInfoTempmax
				+ ", mainInfoPressure=" + mainInfoPressure
				+ ", mainInfoSealevel=" + mainInfoSealevel
				+ ", mainInfoGrandLevel=" + mainInfoGrandLevel
				+ ", mainInfoHumidity=" + mainInfoHumidity;
	}

}
