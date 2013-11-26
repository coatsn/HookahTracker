package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewCoal extends Activity {

	private EditText name, number;
	private String nText, numText;
	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_coal);
		
		name = (EditText)findViewById(R.id.coal_name_input);
		number = (EditText)findViewById(R.id.coal_number_input);
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
	* This will add a new coal to the list of coals
	* 
	* @param view Allows the view to interact with the app
	*/
	public void addCoal(View view) {
		nText = name.getText().toString();
		numText = number.getText().toString();
		int iNum = 0;
		try {
			iNum = Integer.parseInt(numText);
		} catch(NumberFormatException e) {
			Toast.makeText(this, "Please enter an integer for number",
					Toast.LENGTH_LONG).show();
			return;
		}
		
		
		Coal coal = new Coal(nText, iNum);
		
		MainActivity.db.createCoal(coal);
		Intent intent = new Intent(getApplicationContext(), CoalsActivity.class);
		startActivity(intent);
	}
}