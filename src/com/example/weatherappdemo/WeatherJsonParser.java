package com.example.weatherappdemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class WeatherJsonParser {

	private String TAG = "JsonParser";
	private String MESSAGE_TAG = "message";
	private String CITY_ID_TAG = "city_id";
	private String COUNT_TAG = "cnt";
	private String LIST_TAG = "list";
	private String WEATHER_TAG = "weather";
	private String ID_TAG = "id";
	private String MAIN_TAG = "main";
	private String DESCRIPTION_TAG = "description";
	private String ICON_TAG = "icon";
	private String BASE_TAG = "base";
	private String TEMP_TAG = "temp";
	private String TEMP_MIN_TAG = "temp_min";
	private String TEMP_MAX_TAG = "temp_max";
	private String PRESSURE_TAG = "pressure";
	private String SEA_LEVEL_TAG = "sea_level";
	private String GRAND_LEVEL_TAG = "grnd_level";
	private String HUMIDITY_TAG = "humidity";
	private String SPEED_TAG = "speed";
	private String DEG_TAG = "deg";
	private String WIND_TAG = "wind";
	private String RAIN_TAG = "rain";
	private String H_TAG = "3h";
	private String CLOUDS_TAG = "clouds";
	private String ALL_TAG = "all";
	private String CITY_TAG = "city";
	private String ZOOM_TAG = "zoom";
	private String COUNTRY_TAG = "country";
	private String POPULATION_TAG = "population";
	private String FIND_TAG = "find";
	private String NAME_TAG = "name";
	private String DT_TAG = "dt";

	private WeatherDetailInfo weatherDetailInfo;
	private WeatherInfo weatherInfo;
	private DailyWeather dailyWeather;

	public WeatherJsonParser() {
		super();
		weatherDetailInfo = new WeatherDetailInfo();
		// TODO Auto-generated constructor stub
	}

	public String parseWeatherArray(String jsondata) {
		try {
			JSONObject jsonObj = new JSONObject(jsondata);

			String message = jsonObj.getString(MESSAGE_TAG);
			weatherDetailInfo.setWeatherDetailMessage(message);

			Integer cityid = jsonObj.getInt(CITY_ID_TAG);
			weatherDetailInfo.setWeatherDetailCityId(cityid);

			Integer cnt = jsonObj.getInt(COUNT_TAG);
			weatherDetailInfo.setWeatherDetailCnt(cnt);

			JSONArray listarr = jsonObj.getJSONArray(LIST_TAG);

			parseWeatherList(listarr);

			String temp = " result " + message + "city id == " + cityid
					+ "cnt == " + cnt + "list length ==" + listarr.length();

			// Log.i(TAG, " parseWeatherArray == " + temp);

			return temp;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private void parseWeatherList(JSONArray listJsonArr) {
		try {
			for (int i = 0; i < listJsonArr.length(); i++) {
				JSONObject listJsonObject = listJsonArr.getJSONObject(i);
				dailyWeather = null;
				dailyWeather = new DailyWeather();

				JSONArray weatherJsonArr = listJsonObject
						.getJSONArray(WEATHER_TAG);

				parseWeatherJsonArr(weatherJsonArr);

				String baseString = listJsonObject.getString(BASE_TAG);
				dailyWeather.setDailyWeatherbase(baseString);

				parseWeatherMainJsonObject(listJsonObject
						.getJSONObject(MAIN_TAG));

				parseWeatherWindJsonObject(listJsonObject
						.getJSONObject(WIND_TAG));

				JSONObject rainJsonObject = listJsonObject
						.getJSONObject(RAIN_TAG);

				Integer hInteger = rainJsonObject.getInt(H_TAG);
				dailyWeather.setDailyWeatherRainh(hInteger);

				JSONObject cloudsJsonObject = listJsonObject
						.getJSONObject(CLOUDS_TAG);

				Integer allInteger = cloudsJsonObject.getInt(ALL_TAG);
				dailyWeather.setDailyWeatherCloudsAll(allInteger);

				parseWeatherCityObject(listJsonObject.getJSONObject(CITY_TAG));

				Long dt = listJsonObject.getLong(DT_TAG);
				dailyWeather.setDailyWeatherDt(dt);

				weatherDetailInfo.addToList(dailyWeather);

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseWeatherJsonArr(JSONArray weatherJsonArr) {
		try {
			for (int i = 0; i < weatherJsonArr.length(); i++) {

				Log.i(TAG, "parseWeatherJsonArr  i == " + i);
				weatherInfo = null;
				weatherInfo = new WeatherInfo();

				JSONObject weatherJsonObject = weatherJsonArr.getJSONObject(i);

				Integer weatherid = weatherJsonObject.getInt(ID_TAG);
				weatherInfo.setWeatherInfoId(weatherid);

				String weatherMain = weatherJsonObject.getString(MAIN_TAG);
				weatherInfo.setWeatherInfoMain(weatherMain);

				String weatherDescription = weatherJsonObject
						.getString(DESCRIPTION_TAG);
				weatherInfo.setWeatherInfoDescription(weatherDescription);

				String weatherIcon = weatherJsonObject.getString(ICON_TAG);
				weatherInfo.setWeatherInfoIcon(weatherIcon);

				dailyWeather.addWeatherInfoToList(weatherInfo);

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseWeatherMainJsonObject(JSONObject mainJsonObject) {
		try {

			MainInfo mainInfo = new MainInfo();

			Double temp = mainJsonObject.getDouble(TEMP_TAG);
			mainInfo.setMainInfoTemp(temp);

			Double tempmin = mainJsonObject.getDouble(TEMP_MIN_TAG);
			mainInfo.setMainInfoTempmin(tempmin);

			Double tempmax = mainJsonObject.getDouble(TEMP_MAX_TAG);
			mainInfo.setMainInfoTempmax(tempmax);

			Double pressure = mainJsonObject.getDouble(PRESSURE_TAG);
			mainInfo.setMainInfoPressure(pressure);

			Double sealevel = mainJsonObject.getDouble(SEA_LEVEL_TAG);
			mainInfo.setMainInfoSealevel(sealevel);

			Double grandLevel = mainJsonObject.getDouble(GRAND_LEVEL_TAG);
			mainInfo.setMainInfoGrandLevel(grandLevel);

			Integer humidity = mainJsonObject.getInt(HUMIDITY_TAG);
			mainInfo.setMainInfoHumidity(humidity);

			dailyWeather.setDailyWeatherMainInfo(mainInfo);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parseWeatherCityObject(JSONObject cityJsonObject) {

		try {
			City city = new City();

			Integer zoom = cityJsonObject.getInt(ZOOM_TAG);
			city.setCityZoom(zoom);

			String country = cityJsonObject.getString(COUNTRY_TAG);
			city.setCityCountry(country);

			Long population = cityJsonObject.getLong(POPULATION_TAG);
			city.setCityPopulation(population);

			Integer cityId = cityJsonObject.getInt(ID_TAG);
			city.setCityId(cityId);

			String cityName = cityJsonObject.getString(NAME_TAG);
			city.setCityName(cityName);

			JSONArray findJsonArr = cityJsonObject.getJSONArray(FIND_TAG);
			for (int k = 0; k < findJsonArr.length(); k++) {
				String valueString = findJsonArr.getString(k);
				city.addToList(valueString);
			}

			dailyWeather.setDailyWeatherCity(city);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parseWeatherWindJsonObject(JSONObject mainJsonObject) {
		try {

			Double speed = mainJsonObject.getDouble(SPEED_TAG);
			dailyWeather.setDailyWeatherWindSpeed(speed);

			Integer humidity = mainJsonObject.getInt(DEG_TAG);
			dailyWeather.setDailyWeatherWindHumidity(humidity);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WeatherDetailInfo getWeatherDetailInfo() {
		return weatherDetailInfo;
	}

	public void setWeatherDetailInfo(WeatherDetailInfo weatherDetailInfo) {
		this.weatherDetailInfo = weatherDetailInfo;
	}

}
