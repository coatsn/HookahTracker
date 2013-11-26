package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewFlavor extends Activity {
	private EditText name, grams;
	private String nText, gText;
	int brandID;
	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_flavor);
		brandID = ShishaFlavorActivity.brandID;
		
		name = (EditText)findViewById(R.id.shisha_flavor_input);
		grams = (EditText)findViewById(R.id.shisha_grams_input);
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
	* This will add a new brand of shisha to the list of different brands
	* 
	* @param view Allows the view to interact with the app
	*/
	public void addFlavor(View view) {
		nText = name.getText().toString();
		gText = grams.getText().toString();

		int iGrams = 0;
		try {
			iGrams = Integer.parseInt(gText);
		} catch(NumberFormatException e) {
			Toast.makeText(this, "Please enter in an integer for grams",
					Toast.LENGTH_LONG).show();
			return;
		}
		
		
		Shisha shisha = new Shisha(nText, brandID, iGrams);
		
		MainActivity.db.createShisha(shisha);
		Intent intent = new Intent(getApplicationContext(), ShishaFlavorActivity.class);
		intent.putExtra("real_brand_id", brandID);
		startActivity(intent);
	}
}