package com.example.weatherappdemo.activities;

import java.util.ArrayList;

import com.example.weatherappdemo.DailyWeather;
import com.example.weatherappdemo.WeatherListAdapter;
import com.example.weatherappdemo.R;
import com.example.weatherappdemo.WeatherDetailInfo;

import com.example.weatherappdemo.utils.Utils;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class WeatherListActivity extends Activity {

	private ListView poll_list;
	private ArrayList<DailyWeather> fragmentpollInfoList;
	private String TAG = "PollListFragment";
	private WeatherListAdapter listAdapter;
	private WeatherDetailInfo weatherDetail;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.weather_list_view);

		weatherDetail = (WeatherDetailInfo) getIntent().getSerializableExtra(
				Utils.SHARE_WEATHER_OBJECT);

		// weather detail object not found
		if (weatherDetail == null) {
			WeatherListActivity.this.finish();
		}

		fragmentpollInfoList = weatherDetail.getDailyWeatherList();

		listAdapter = new WeatherListAdapter(
				weatherDetail.getDailyWeatherList(), WeatherListActivity.this);
		initializeViews();

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	private void initializeViews() {

		poll_list = (ListView) findViewById(R.id.pollListViewId);

		poll_list.setAdapter(listAdapter);
		poll_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "item position  " + position);
				Log.i(TAG, "data  == " + fragmentpollInfoList.get(position));
				Intent i = new Intent(WeatherListActivity.this,
						WeatherDetailInfoActivity.class);
				i.putExtra(Utils.SHARE_WEATHER_OBJECT,
						fragmentpollInfoList.get(position));
				startActivity(i);
			}
		});
	}

}
