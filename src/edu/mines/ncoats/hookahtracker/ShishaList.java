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

public class ShishaList extends ListFragment {

//	String[] shishaEntries = new String[] {
//			"",
//			""
//	};

	private String[] shishaEntries;
	private ArrayList<ShishaBrand> sbs;
	
	/**
	* Calls the xml file for creation
	* 
	* @param savedInstanceState, Retrieves app data
	*        container, tells the app where to inflate the layout
	*        inflater, allows the app to inflate the fragment
	*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		sbs = MainActivity.db.getAllShishaBrands();
		shishaEntries = new String[sbs.size() + 1];
		
		for(int i = 0; i < sbs.size(); i++) {
			Log.d("shishabrand name", "the name is :" + sbs.get(i).getName());
			shishaEntries[i] = sbs.get(i).getName();
		}
		
		int last = shishaEntries.length - 1;
		shishaEntries[last] = getString(R.string.add_shisha);
		
		for(int i = 0; i < shishaEntries.length; i++) {
			Log.d("shishaEntries","the element is: " + shishaEntries[i]);
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, shishaEntries);
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

		if(position == shishaEntries.length - 1){
			Intent intent = new Intent(getActivity().getApplicationContext(), AddNewShisha.class);
			startActivity(intent);
		} else {
			int brandID = sbs.get(position).getId();
			Log.d("brand_id", "the id is: " + brandID);
			Intent intent = new Intent(getActivity().getApplicationContext(), ShishaFlavorActivity.class);
			
			intent.putExtra("brand_id", brandID);
			startActivity(intent);
		}
	}




}
