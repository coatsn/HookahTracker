package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ShishaActivity extends Activity {

	/**
	 * Calls the xml file for creation and gets the intent.
	 * 
	 * @param savedInstanceState, Retrieves app data
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(MainActivity.isTablet){
			setContentView(R.layout.activity_main_menu_shisha);
		} else {
			setContentView(R.layout.shisha_list);
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
		case R.id.action_statistics:
			Intent intent2 = new Intent(getApplicationContext(), StatisticsActivity.class);
			startActivity(intent2);
			break;
		}
		return true;
	}

	/**
	 * This will send the user to the AddNewShisha activity
	 * 
	 * @param view Allows the view to interact with the app
	 */
	public void addShisha(View view) {
		Intent intent = new Intent(this, AddNewShisha.class);
		startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
	}
}
