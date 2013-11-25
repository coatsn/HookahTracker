package edu.mines.ncoats.hookahtracker;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CoalsList extends ListFragment {

	String[] coalEntries = new String[] {
			"List Not Implemented",
			""
			};

	/**
	* Calls the xml file for creation
	* 
	* @param savedInstanceState, Retrieves app data
	*        container, tells the app where to inflate the layout
	*        inflater, allows the app to inflate the fragment
	*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		int last = coalEntries.length - 1;
		coalEntries[last] = getString(R.string.add_coal);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, coalEntries);
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

		if(position == coalEntries.length - 1){
			Intent intent = new Intent(getActivity().getApplicationContext(), AddNewCoal.class);
			startActivity(intent);
		}
	}
}