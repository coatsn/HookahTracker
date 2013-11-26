package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SettingsActivity extends Activity {

	/**
	 * Calls the xml file for creation and gets the intent.
	 * 
	 * @param savedInstanceState, Retrieves app data
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(MainActivity.isTablet){
			setContentView(R.layout.activity_main_menu_settings);
		} else {
			setContentView(R.layout.activity_settings);
		}




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
		case R.id.action_about:
			new AboutDialog().show(getFragmentManager(), "AboutDialog");
			break;
		case R.id.action_help:
			new HelpDialog().show(getFragmentManager(), "HelpDialog");
			break;
		case R.id.action_statistics:
			Intent intent2 = new Intent(getApplicationContext(), StatisticsActivity.class);
			startActivity(intent2);
			break;
		}
		return true;
	}

	public void clearDB(View view) {
		MainActivity.db.clearDB();
	}
	
	public void clearStats(View view) {
		MainActivity.db.clearStatistics();
	}
	
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
	}
}