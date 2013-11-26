/**
 * Description: This is the main activity for this application. It contains the main menu (which is a list fragment).
 * Each item in the list can be clicked, which will bring the user to the appropriate screen.
 * 
 * INCREMENTAL PROGRESS: This application meets most of the requirements detailed in the proposal.
 * However, we decided to hold off on implementing the databases until after this submission, as the 
 * screens and fragments took more time than we thought they would. Implementing the databases, on top
 * of the screens would have been more than we feel is necessary for this submission.
 *
 * Documentation Statement: This application was primarily tested on an Asus 
 * Transformer running Android 4.2
 * 
 * Some of the code in the ListFragment classes was taken from:
 * http://www.vogella.com/articles/AndroidFragments/article.html
 * http://androidexample.com/LISTVIEW/index.php?view=article_discription&aid=65&aaid=90
 * http://wptrafficanalyzer.in/blog/a-listfragment-application-in-android/
 *
 *
 * @author Timothy Waite, Nick Coats
 */

package edu.mines.ncoats.hookahtracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	static DatabaseHelper db;
	static boolean isTablet;

	/**
	 * Calls the xml file for creation and gets the intent.
	 * 
	 * @param savedInstanceState, Retrieves app data
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		isTabletDevice(this);
		db = new DatabaseHelper(getApplicationContext());
		//		db.onUpgrade(db.getWritableDatabase(), 3, 4);
		if(isTablet) {
			setContentView(R.layout.activity_main_tablet);
		} else {
			setContentView(R.layout.activity_main);
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
	 * Checks if the device is a tablet or a phone
	 * 
	 * @param activityContext
	 *            The Activity Context.
	 * @return Returns true if the device is a Tablet
	 */
	public static void isTabletDevice(Context activityContext) {
		// Verifies if the Generalized Size of the device is XLARGE to be
		// considered a Tablet
		boolean xlarge = ((activityContext.getResources().getConfiguration().screenLayout & 
				Configuration.SCREENLAYOUT_SIZE_MASK) == 
				Configuration.SCREENLAYOUT_SIZE_XLARGE);

		// If XLarge, checks if the Generalized Density is at least MDPI
		// (160dpi)
		if (xlarge) {
			DisplayMetrics metrics = new DisplayMetrics();
			Activity activity = (Activity) activityContext;
			activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

			// MDPI=160, DEFAULT=160, DENSITY_HIGH=240, DENSITY_MEDIUM=160,
			// DENSITY_TV=213, DENSITY_XHIGH=320
			if (metrics.densityDpi == DisplayMetrics.DENSITY_DEFAULT
					|| metrics.densityDpi == DisplayMetrics.DENSITY_HIGH
					|| metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM
					|| metrics.densityDpi == DisplayMetrics.DENSITY_TV
					|| metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH) {

				// Yes, this is a tablet!
				isTablet = true;
			}
		}else {

			// No, this is not a tablet!
			isTablet = false;
		}
		Log.d("is it a tablet?", isTablet + "");
	}

}