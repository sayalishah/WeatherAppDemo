package com.example.weatherappdemo.activities;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.example.weatherappdemo.DownloadData;
import com.example.weatherappdemo.R;
import com.example.weatherappdemo.WeatherJsonParser;
import com.example.weatherappdemo.utils.Utils;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputActivity extends Activity implements LocationListener {

	private EditText inputEditText;
	private TextView locationTextView;
	private Button btn;
	private String TAG = "InputActivity";
	private LocationManager locationManager;
	private String cityName;

	private final Long MIN_TIME = 120000l;
	private final Float MIN_DIST = 1000f;
	private String APPID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		APPID = getResources().getString(R.string.APP_ID);
		initLocationListeners();
		initViews();
		initListeners();
	}

	private void initViews() {
		inputEditText = (EditText) findViewById(R.id.inputActivityeditText);
		btn = (Button) findViewById(R.id.getWeatherData);
		locationTextView = (TextView) findViewById(R.id.currentLocationTextViewId);
	}

	private void initListeners() {
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (inputEditText.getText().toString() != null
						&& !inputEditText.getText().toString()
								.equalsIgnoreCase("")) {

					getWeatherDataOnrequest(inputEditText.getText().toString());

				} else {
					Toast.makeText(InputActivity.this,
							"Please enter valid input", Toast.LENGTH_LONG)
							.show();
				}
			}
		});

		locationTextView.setClickable(true);

		locationTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getCityName();

			}
		});
	}

	private void initLocationListeners() {

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DIST, this);

	}

	private void getCityName() {

		if (cityName != null && !cityName.equalsIgnoreCase("")) {
			getWeatherDataOnrequest(cityName);
		} else {
			Toast.makeText(InputActivity.this, Utils.NOT_FETCH_DATA,
					Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}

	private void getWeatherDataOnrequest(String cityName) {

		if (Utils.isInternetConnectionAvailable(InputActivity.this)) {
			new WeatherInfoAsyncTask(cityName).execute();
		} else {
			// internet connection not available
		}

	}

	private class WeatherInfoAsyncTask extends AsyncTask<Void, Void, String> {

		private String cityName;
		private ProgressDialog mProgressDialog;
		private boolean result;
		private WeatherJsonParser weatherJsonParser;

		public WeatherInfoAsyncTask(String cityName) {
			super();
			Log.i(TAG, "cityName == " + cityName);
			this.cityName = cityName;
			this.result = false;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			weatherJsonParser = new WeatherJsonParser();
			// mProgressDialog = new ProgressDialog(getActivity());
			mProgressDialog = new ProgressDialog(InputActivity.this);
			// Set progressdialog title
			mProgressDialog.setTitle("Downloading...");
			// Set progressdialog message

			mProgressDialog.setIndeterminate(false);
			// Show progressdialog
			mProgressDialog.show();
		}

		@Override
		protected String doInBackground(Void... params) {
			// Create the array

			String appiddata = "&APPID=" + APPID;

			String url = Utils.DOWNLOAD_WEATHER_URL + cityName + appiddata;
			// String url = Utils.QUESTIONS_URL;
			Log.i(TAG, "??????????????????????????????" + url);
			DownloadData downloadUserInfo = new DownloadData(url);
			String data = downloadUserInfo.executeHttpGet();

			Log.i(TAG, "????????????????????????????????data == " + data);

			if (data != null && !data.equals("")) {
				Log.i(TAG, "" + data);

				weatherJsonParser.parseWeatherArray(data);
				this.result = true;

			} else {

			}

			return "";
		}

		//
		@Override
		protected void onPostExecute(String result) {

			mProgressDialog.dismiss();
			if (this.result) {
				// go to next screen
				Intent i = new Intent(InputActivity.this,
						WeatherListActivity.class);
				i.putExtra(Utils.SHARE_WEATHER_OBJECT,
						weatherJsonParser.getWeatherDetailInfo());
				startActivity(i);

			} else {
				// show toast
				Toast.makeText(InputActivity.this, "Unable to fetch data",
						Toast.LENGTH_LONG).show();
			}

		}

	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

		Log.i(TAG, "Latitude == " + location.getLatitude());
		Log.i(TAG, "Longitude == " + location.getLongitude());

		Geocoder gcd = new Geocoder(InputActivity.this, Locale.getDefault());

		try {
			List<Address> addresses = null;
			addresses = gcd.getFromLocation(location.getLatitude(),
					location.getLongitude(), 1);
			if (addresses != null && addresses.size() > 0) {
				Log.i(TAG, "addreess == " + addresses.get(0).getLocality());
				cityName = addresses.get(0).getLocality();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
