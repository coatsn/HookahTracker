package edu.mines.ncoats.hookahtracker;

import java.util.ArrayList;

import android.R.bool;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.ListActivity;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SessionActivity extends Activity {
	private boolean isChoosing = true;
	private int iCoals;
	private EditText numCoals;
	private Spinner hookahSpin, shishaSpin, coalSpin, bowlSpin;
	private String hookahEntries[], shishaEntries[], coalEntries[], bowlEntries[], hookahName, coalName, bowlName, shishaName;
	private int hookahId, shishaId, coalId, bowlId;
	private boolean noHookah, noShisha, noBowl, noCoals;
	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_session);
		
		numCoals = (EditText) findViewById(R.id.coal_number_input);
		
		
		ArrayList<Hookah> hookahs = MainActivity.db.getAllHookahs();
		ArrayList<Shisha> shishas = MainActivity.db.getAllFlavors();
		Log.d("length of flavors", "flavors: " + shishas.size());
		ArrayList<Coal> coals = MainActivity.db.getAllCoals();
		ArrayList<Bowl> bowls = MainActivity.db.getAllBowls();
		
		hookahEntries = new String[hookahs.size()];
		shishaEntries = new String[shishas.size()];
		coalEntries = new String[coals.size()];
		bowlEntries = new String[bowls.size()];
		
		for(int i = 0; i < hookahs.size(); i++) {
			hookahEntries[i] = hookahs.get(i).getName();
		}
		
		for(int i = 0; i < shishas.size(); i++) {
			shishaEntries[i] = shishas.get(i).getName();
		}
		
		for(int i = 0; i < coals.size(); i++) {
			coalEntries[i] = coals.get(i).getName();
		}
		
		for(int i = 0; i < bowls.size(); i++) {
			bowlEntries[i] = bowls.get(i).getName();
		}
		
		
		
		hookahSpin = (Spinner) findViewById(R.id.choose_hookah);
		shishaSpin = (Spinner) findViewById(R.id.choose_shisha);
		coalSpin = (Spinner) findViewById(R.id.choose_coals);
		bowlSpin = (Spinner) findViewById(R.id.choose_bowl);
		
		ArrayAdapter<String> hookAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hookahEntries);
		// Specify the layout to use when the list of choices appears
		hookAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		hookahSpin.setAdapter(hookAdapter);
		
		ArrayAdapter<String> shishAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, shishaEntries);
		// Specify the layout to use when the list of choices appears
		shishAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		shishaSpin.setAdapter(shishAdapter);
		
		ArrayAdapter<String> coalAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, coalEntries);
		// Specify the layout to use when the list of choices appears
		coalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		coalSpin.setAdapter(coalAdapter);
		
		ArrayAdapter<String> bowlAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bowlEntries);
		// Specify the layout to use when the list of choices appears
		bowlAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		bowlSpin.setAdapter(bowlAdapter);
		
		
		
		
		hookahSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
		        noHookah = false;
		        hookahName = hookahEntries[i];
		        Log.d("hookah name", "the hookah name is:" + hookahName);
		    } 

		    public void onNothingSelected(AdapterView<?> adapterView) {
		    	noHookah = true;
		        return;
		    } 
		}); 
		
		shishaSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
		        noShisha = false;
		        shishaName = shishaEntries[i];
		        Log.d("shisha name", "the shisha name is:" + shishaName);
		    } 

		    public void onNothingSelected(AdapterView<?> adapterView) {
		    	noShisha = true;
		        return;
		    } 
		}); 
		
		coalSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
		        noCoals = false;
		        coalName = coalEntries[i];
		        Log.d("coal name", "the coal name is:" + coalName);
		    } 

		    public void onNothingSelected(AdapterView<?> adapterView) {
		    	noCoals = true;
		        return;
		    } 
		}); 
		
		bowlSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
		        noBowl = false;
		        bowlName = bowlEntries[i];
		        Log.d("bowl name", "the bowl name is:" + bowlName);
		    } 

		    public void onNothingSelected(AdapterView<?> adapterView) {
		    	noBowl = true;
		        return;
		    } 
		}); 
		
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

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void startSession(View view) {
		int totalCoals = MainActivity.db.numCoalsFromName(coalName);
		iCoals = 0;
		try {
			iCoals = Integer.parseInt(numCoals.getText().toString());
		} catch(NumberFormatException e) {
			Toast.makeText(this, "Please enter an integer for number of coals",
					Toast.LENGTH_LONG).show();
			return;
		}
		
		if(iCoals > totalCoals) {
			Toast.makeText(this, "There are not enough coals of your selected type.",
					Toast.LENGTH_LONG).show();
			return;
		}
		
		hookahId = MainActivity.db.getHookahIdFromName(hookahName);
		shishaId = MainActivity.db.getShishaIdFromName(shishaName);
		coalId = MainActivity.db.getCoalIdFromName(coalName);
		bowlId = MainActivity.db.getBowlIdFromName(bowlName);
		
		Session session = new Session(hookahId, bowlId, shishaId, coalId, MainActivity.db.getDateTime());
		
		MainActivity.db.createSession(session);
		
	}
}