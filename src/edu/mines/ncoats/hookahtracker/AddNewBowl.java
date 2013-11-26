package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewBowl extends Activity {

	private EditText name, grams;
	private String nText, gText;
	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_bowl);
		
		name = (EditText)findViewById(R.id.bowl_name_input);
		grams = (EditText)findViewById(R.id.bowl_grams_input);
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
	* This will add a new bowl to the list of bowls
	* 
	* @param view Allows the view to interact with the app
	*/
	public void addBowl(View view) {
		nText = name.getText().toString();
		gText = grams.getText().toString();
		int iGrams = 0;
		try {
			iGrams = Integer.parseInt(gText);
		} catch(NumberFormatException e) {
			Toast.makeText(this, "Please enter an integer for grams",
					Toast.LENGTH_LONG).show();
			return;
		}
		
		
		Bowl bowl = new Bowl(nText, iGrams);
		
		MainActivity.db.createBowl(bowl);
		Intent intent = new Intent(getApplicationContext(), BowlActivity.class);
		startActivity(intent);
	}
}