package edu.mines.ncoats.hookahtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddNewShishaFragment extends Fragment {

	/**
	* Calls the xml file for creation
	* 
	* @param savedInstanceState, Retrieves app data
	*        container, tells the app where to inflate the layout
	*        inflater, allows the app to inflate the fragment
	*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_shisha_fragment, container, false);
    }
    
    public void addShisha(View view) {
//		Toast toast = Toast.makeText(getA, "Not Implemented", Toast.LENGTH_SHORT);
//		toast.show();
	}
}