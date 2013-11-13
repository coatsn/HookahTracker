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

import edu.mines.ncoats.hookahtracker.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends Activity {

	/**
	* Calls the xml file for creation and gets the intent.
	* 
	* @param savedInstanceState, Retrieves app data
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}