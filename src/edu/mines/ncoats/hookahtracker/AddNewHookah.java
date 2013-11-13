package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class AddNewHookah extends Activity {

	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.new_hookah);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	* This will add a new hookah to the list of hookahs
	* 
	* @param view Allows the view to interact with the app
	*/
	public void addHookah(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Not Implemented", Toast.LENGTH_SHORT);
		toast.show();
	}
	
	/**
	* This will take the user to their camera app to take a photo, which will be saved to the hookah that they are adding
	* 
	* @param view Allows the view to interact with the app
	*/
	public void takePicture(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Not Implemented", Toast.LENGTH_SHORT);
		toast.show();
	}
}
