package com.example.weatherappdemo.activities;

import com.example.weatherappdemo.DailyWeather;
import com.example.weatherappdemo.R;
import com.example.weatherappdemo.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherDetailInfoActivity extends Activity {
	private DailyWeather dailyWeather;
	private TextView detailTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather_detail);
		detailTextView = (TextView) findViewById(R.id.detailtextViewId);

		dailyWeather = (DailyWeather) getIntent().getSerializableExtra(
				Utils.SHARE_WEATHER_OBJECT);

		if (dailyWeather != null) {
			detailTextView.setText(dailyWeather.toString());
		} else {
			detailTextView.setText(Utils.NOT_FETCH_DATA);
		}
	}

}
