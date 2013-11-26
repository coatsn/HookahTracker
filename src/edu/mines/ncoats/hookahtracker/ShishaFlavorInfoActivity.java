package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ShishaFlavorInfoActivity extends Activity {
	private String bName, sName;
	private int iGrams;
	private Shisha shisha;
	private TextView brandName, flavorName, grams;
	
	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shisha_flavor_info);
		Intent intent = getIntent();
		sName = intent.getStringExtra("shisha_name");
		shisha = MainActivity.db.getShishaByName(sName);
		bName = MainActivity.db.getBrandName(shisha.getBrandId());
		iGrams = shisha.getGrams();
		
		brandName = (TextView)findViewById(R.id.shisha_flavor_info);
		flavorName = (TextView)findViewById(R.id.shisha_flavor_name_info);
		grams = (TextView)findViewById(R.id.shisha_flavor_grams_info);
		
		brandName.setText(bName);
		flavorName.setText(sName);
		grams.setText(iGrams + "");

		
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
	
	public void deleteShisha(View view) {
		MainActivity.db.deleteShisha(shisha);
		Intent intent = new Intent(getApplicationContext(), ShishaFlavorActivity.class);
		startActivity(intent);
	}
	
}