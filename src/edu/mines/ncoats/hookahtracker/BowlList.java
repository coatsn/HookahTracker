package edu.mines.ncoats.hookahtracker;

import java.util.ArrayList;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BowlList extends ListFragment {

//	String[] bowlEntries = new String[] {
//			"List Not Implemented",
//			""
//			};
	String [] bowlEntries;

	/**
	* Calls the xml file for creation
	* 
	* @param savedInstanceState, Retrieves app data
	*        container, tells the app where to inflate the layout
	*        inflater, allows the app to inflate the fragment
	*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		ArrayList<Bowl> bowls = MainActivity.db.getAllBowls();
		Log.d("length of bowl array", "the length is: " + bowls.size());
		bowlEntries = new String[bowls.size() + 1];
		
		for(int i = 0; i < bowls.size(); i++) {
			bowlEntries[i] = bowls.get(i).getSize() + " gram " + bowls.get(i).getName();
		}
		
		int last = bowlEntries.length - 1;
		bowlEntries[last] = getString(R.string.add_bowl);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, bowlEntries);
		setListAdapter(adapter);



		return super.onCreateView(inflater, container, savedInstanceState);		
	}

	/**
	* Overrides the onListItemClick function of a ListFragment
	* 
	* @param l, the ListView that is being clicked
	*        v, the view that the ListView is in
	*        position, which item in the list is being clicked
	*        id, the id of the item that is being clicked
	*/
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		if(position == bowlEntries.length - 1){
			Intent intent = new Intent(getActivity().getApplicationContext(), AddNewBowl.class);
			startActivity(intent);
		}
	}
}

