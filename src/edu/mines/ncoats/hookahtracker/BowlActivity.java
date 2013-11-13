package edu.mines.ncoats.hookahtracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;


public class BowlActivity extends Activity {

	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.bowl_list);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	* This will send the user to the AddNewBowl activity
	* 
	* @param view Allows the view to interact with the app
	*/
	public void add(View view) {
		Intent intent = new Intent(this, AddNewBowl.class);
		startActivity(intent);
	}

}
