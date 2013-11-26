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

public class ShishaFlavorList extends ListFragment {

//	String[] shishaFlavorEntries = new String[] {
//			"List Not Implemented",
//			""
//			};

	String[] shishaFlavorEntries;
	ArrayList<Shisha> shish;
	
	/**
	* Calls the xml file for creation
	* 
	* @param savedInstanceState, Retrieves app data
	*        container, tells the app where to inflate the layout
	*        inflater, allows the app to inflate the fragment
	*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		shish = MainActivity.db.getAllShishaFlavors(ShishaFlavorActivity.brandID);
		Log.d("in the list", "in the list, the brandID is: " + ShishaFlavorActivity.brandID);
		shishaFlavorEntries = new String[shish.size() + 1];
		
		for(int i = 0; i < shish.size(); i++) {
			shishaFlavorEntries[i] = shish.get(i).name;
		}
		
		int last = shishaFlavorEntries.length - 1;
		shishaFlavorEntries[last] = getString(R.string.add_flavor);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, shishaFlavorEntries);
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

		if(position == shishaFlavorEntries.length - 1){
			Intent intent = new Intent(getActivity().getApplicationContext(), AddNewFlavor.class);
			startActivity(intent);
		} else {
			Intent intent = new Intent(getActivity().getApplicationContext(), ShishaFlavorInfoActivity.class);
			String shishaName = shish.get(position).getName();
			intent.putExtra("shisha_name", shishaName);
			startActivity(intent);
		}
	}
}
