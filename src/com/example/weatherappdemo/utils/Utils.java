package com.example.weatherappdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;



public class Utils {
	
	public static String DOWNLOAD_WEATHER_URL = "http://api.openweathermap.org/data/2.5/history/city?q=";
	public static String SHARE_WEATHER_OBJECT = "weatherdetails";
	public static String NOT_FETCH_DATA = "Unable to fetch data";
	public static final String NETWORK_CONNECTION_CHECK = "Network connection failed";
	
	public static boolean isInternetConnectionAvailable(Context context) {
		ConnectivityManager connMgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		} else {

			Toast.makeText(context, Utils.NETWORK_CONNECTION_CHECK,
					Toast.LENGTH_LONG).show();
			return false;
		}
	}

}
