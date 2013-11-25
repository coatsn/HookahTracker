package edu.mines.ncoats.hookahtracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class HookahInfoActivity extends Activity {
	private String hName;
	private Hookah hookah;
	private TextView name, height, hoses;
	
	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hookah_info);
		Intent intent = getIntent();
		hName = intent.getStringExtra("hookah_name");
		hookah = MainActivity.db.getHookahByName(hName);
		
		
		
		name = (TextView)findViewById(R.id.hookah_name_info);
		height = (TextView)findViewById(R.id.hookah_height_info);
		hoses = (TextView)findViewById(R.id.hookah_hose_info);
		
		name.setText(hookah.getName());
		height.setText("" + hookah.getHeight());
		hoses.setText("" + hookah.getNumHoses());
		
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
	
	public void deleteHookah(View view) {
		MainActivity.db.deleteHookah(hookah);
		Intent intent = new Intent(getApplicationContext(), HookahActivity.class);
		startActivity(intent);
	}
}