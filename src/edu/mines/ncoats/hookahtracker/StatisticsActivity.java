package edu.mines.ncoats.hookahtracker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressLint("DefaultLocale")
public class StatisticsActivity extends Activity {

	private TextView avCoals, avShisha, favHookah, numSessions;
	/**
	 * Calls the xml file for creation and gets the intent.
	 * 
	 * @param savedInstanceState, Retrieves app data
	 */
	@SuppressLint("DefaultLocale")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if(MainActivity.isTablet){
			setContentView(R.layout.activity_main_menu_statistics);
		} else {
			setContentView(R.layout.activity_statistics);
		}

//		double average = MainActivity.db.getAverageCoals();
//		double averageShisha = MainActivity.db.getAverageShisha();
//		Log.d("average coals", "the average number of coals is: " + average);
//		Log.d("average shisha", "the average amount of shisha is: " + averageShisha);
		
		avCoals = (TextView) findViewById(R.id.average_coals_number);
		avShisha = (TextView) findViewById(R.id.average_shisha_number);
		favHookah = (TextView) findViewById(R.id.favorite_hookah);
		numSessions = (TextView) findViewById(R.id.total_sessions_number);
		
		String averageCoals = String.format("%.2f", MainActivity.db.getAverageCoals());
		String averageShisha = String.format("%.2f", MainActivity.db.getAverageShisha());

		avCoals.setText(averageCoals + " coals");
		avShisha.setText(averageShisha + " grams");
		numSessions.setText(MainActivity.db.getNumSessions() + " sessions");
		String favoriteHookah = MainActivity.db.getFavoriteHookah();
		favHookah.setText(favoriteHookah);
		//hello

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()) {
		case R.id.action_settings:
			Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
			startActivity(intent);
			break;
		case R.id.action_about:
			new AboutDialog().show(getFragmentManager(), "AboutDialog");
			break;
		case R.id.action_help:
			new HelpDialog().show(getFragmentManager(), "HelpDialog");
			break;
		}
		return true;
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
	}

}