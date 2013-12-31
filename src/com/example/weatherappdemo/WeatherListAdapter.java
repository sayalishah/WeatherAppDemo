package com.example.weatherappdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WeatherListAdapter extends BaseAdapter {

	private ArrayList<DailyWeather> dailyWeatherInfoList;
	private LayoutInflater inflater;

	public WeatherListAdapter(ArrayList<DailyWeather> pollinfoList,
			Activity activity) {
		super();
		this.dailyWeatherInfoList = pollinfoList;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void setListToAdapter(ArrayList<DailyWeather> pollinfolist) {

		this.dailyWeatherInfoList = pollinfolist;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dailyWeatherInfoList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = convertView;
		if (convertView == null)

			vi = inflater.inflate(R.layout.weather_item, null);

		TextView pollItemtext = (TextView) vi.findViewById(R.id.poll_text);

		pollItemtext.setText(this.dailyWeatherInfoList.get(position)
				.getDailyWeatherbase());

		return vi;
	}

}
