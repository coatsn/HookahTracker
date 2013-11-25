package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewHookah extends Activity {

	private EditText name;
	private EditText height;
	private EditText hoses;
	
	private static String nText, hText, hoText;
	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.new_hookah);
		name = (EditText)findViewById(R.id.hookah_name_input);
		height = (EditText)findViewById(R.id.hookah_height_input);
		hoses = (EditText)findViewById(R.id.hookah_hoses_input);
		
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
	* This will add a new hookah to the list of hookahs
	* 
	* @param view Allows the view to interact with the app
	*/
	public void addHookah(View view) {
		nText = name.getText().toString();
		hText = height.getText().toString();
		hoText = hoses.getText().toString();
		int iHeight = 0;
		int iHoses = 0;
		try {
			iHeight = Integer.parseInt(hText);
			iHoses = Integer.parseInt(hoText);
		} catch(NumberFormatException e) {
			Toast.makeText(this, "Please enter in an integer for height and hoses",
					Toast.LENGTH_LONG).show();
			return;
		}
		
		
		Hookah hookah = new Hookah(nText, iHeight, iHoses, 0);
		
		MainActivity.db.createHookah(hookah);
		Intent intent = new Intent(getApplicationContext(), HookahActivity.class);
		startActivity(intent);
	}
	
}
